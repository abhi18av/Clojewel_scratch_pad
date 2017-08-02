#include <string.h>
#include <clang-c/Index.h>
#include <glib.h>

static const char *framework_name;

static GHashTable *type_name_hash_table;

static void
register_type_name (const char *name, const char *cljc_name)
{
	if (!type_name_hash_table)
		type_name_hash_table = g_hash_table_new (g_str_hash, g_str_equal);
	g_hash_table_insert (type_name_hash_table, (gpointer)name, (gpointer)cljc_name);
}

static void
register_compound (const char *name)
{
	register_type_name (g_strdup (name), g_strdup_printf ("%s/%s", framework_name, name));
}

static void
register_enum (const char *name)
{
	register_type_name (g_strdup (name), g_strdup_printf ("%s/%s", framework_name, name));
}

static const char*
cljc_name_for_type_name (const char *name)
{
	if (!type_name_hash_table)
		return NULL;
	const char *cljc_name = g_hash_table_lookup (type_name_hash_table, name);
	return cljc_name;
}

static const char*
cljc_name_for_type (CXCursor cursor, CXType type)
{
	CXString spelling_cxstring = clang_getTypeSpelling (type);
	const char *spelling = clang_getCString (spelling_cxstring);
	const char *registered_name = cljc_name_for_type_name (spelling);
	clang_disposeString (spelling_cxstring);
	if (registered_name)
		return registered_name;

	switch (type.kind) {
		case CXType_Void:
			return ":void";
		case CXType_UShort:
			return ":unsigned-short";
		case CXType_UInt:
			return ":unsigned-int";
		case CXType_ULong:
			return ":unsigned-long";
		case CXType_ULongLong:
			return ":unsigned-long-long";
		case CXType_Char_S:
			return ":char";
		case CXType_SChar:
			return ":signed-char";
		case CXType_Short:
			return ":short";
		case CXType_Int:
			return ":int";
		case CXType_Long:
			return ":long";
		case CXType_LongLong:
			return ":long-long";
		case CXType_Float:
			return ":float";
		case CXType_Double:
			return ":double";
		case CXType_LongDouble:
			return ":long-double";
		case CXType_ObjCId:
			return ":id";
		case CXType_ObjCClass:
			return ":id"; /* FIXME: print actual type */
		case CXType_ObjCSel:
			return ":selector";
		case CXType_ObjCObjectPointer:
			return ":id"; /* FIXME: get actual type */
		case CXType_UChar:
			return ":unsigned-char";
		case CXType_Typedef:
			return cljc_name_for_type (cursor, clang_getCanonicalType (type));
		case CXType_Enum: {
			CXCursor referenced;
			CXType enum_type;
			if (clang_isReference (cursor.kind))
				referenced = clang_getCursorReferenced (cursor);
			else
				referenced = cursor;
			if (referenced.kind == CXCursor_TypedefDecl)
				enum_type = clang_getTypedefDeclUnderlyingType (referenced);
			else
				enum_type = clang_getEnumDeclIntegerType (referenced);
			if (enum_type.kind == CXType_Invalid)
				return NULL; /* FIXME: this means we're doing something wrong */
			return cljc_name_for_type (referenced, enum_type);
		}
		case CXType_Pointer: {
			CXType pointee_type = clang_getPointeeType (type);
			if (pointee_type.kind == CXType_Char_S && clang_isConstQualifiedType (pointee_type))
				return ":c-string-const";
			return NULL;
		}
		case CXType_Char16:
		case CXType_Char32:
		case CXType_UInt128:
		case CXType_WChar:
		case CXType_Int128:
		case CXType_NullPtr:
		case CXType_Overload:
		case CXType_Dependent:
		case CXType_Complex:
		case CXType_BlockPointer:
		case CXType_LValueReference:
		case CXType_RValueReference:
		case CXType_Record:
		case CXType_ObjCInterface:
		case CXType_FunctionNoProto:
		case CXType_FunctionProto:
		case CXType_ConstantArray:
		case CXType_Vector:
		case CXType_Unexposed:
		case CXType_Bool:
		case CXType_Char_U:
			return NULL;
		default:
			g_assert_not_reached ();
	}
}

static enum CXChildVisitResult
get_first_child_visitor_func (CXCursor cursor, CXCursor parent, CXClientData client_data)
{
	CXCursor *result = (CXCursor*)client_data;
	*result = cursor;
	return CXChildVisit_Break;
}

static void
print_type_fixme (CXCursor call_cursor, CXCursor cursor, CXType type)
{
	CXString spelling_cxstring = clang_getTypeSpelling (type);
	const char *spelling = clang_getCString (spelling_cxstring);
	CXString call_spelling_cxstring = clang_getCursorSpelling (call_cursor);
	const char *call_spelling = clang_getCString (call_spelling_cxstring);
	printf (";;FIXME: %s in %s\n", spelling, call_spelling);
	clang_disposeString (spelling_cxstring);
	clang_disposeString (call_spelling_cxstring);
}

typedef enum {
	STATE_BASE,
	STATE_ENUM
} VisitorState;

static VisitorState visitor_state = STATE_BASE;
static gboolean have_enum_members = FALSE;
static char *enum_name;

static enum CXChildVisitResult
visitor_func (CXCursor cursor, CXCursor parent, CXClientData client_data)
{
	enum CXCursorKind kind = clang_getCursorKind (cursor);

	switch (visitor_state) {
		case STATE_BASE:
			break;
		case STATE_ENUM: {
			gboolean is_typedef = FALSE;

			if (kind == CXCursor_EnumConstantDecl || kind == CXCursor_UnexposedAttr)
				break;
			if (kind == CXCursor_TypedefDecl) {
				CXType type = clang_getTypedefDeclUnderlyingType (cursor);
				if (type.kind == CXType_Unexposed) {
					CXString type_spelling_cxstring = clang_getTypeSpelling (type);
					const char *type_spelling = clang_getCString (type_spelling_cxstring);
					if (g_str_has_prefix (type_spelling, "enum ")) {
						CXString spelling_cxstring = clang_getCursorSpelling (cursor);
						const char *spelling = clang_getCString (spelling_cxstring);
						if (enum_name)
							g_free (enum_name);
						enum_name = g_strdup (spelling);
						clang_disposeString (spelling_cxstring);

						is_typedef = TRUE;
					}
					clang_disposeString (type_spelling_cxstring);
				}
			}
			if (have_enum_members)
				printf (" %s]\n", enum_name ? enum_name : "nil");
			if (enum_name)
				register_enum (enum_name);
			g_free (enum_name);
			enum_name = NULL;
			visitor_state = STATE_BASE;
			if (is_typedef)
				return CXChildVisit_Continue;
			break;
		}
		default:
			g_assert_not_reached ();
	}

	switch (kind) {
		case CXCursor_ObjCInterfaceDecl:
		case CXCursor_ObjCCategoryDecl:
			//printf ("@interface %s\n", clang_getCString (clang_getCursorSpelling (cursor)));
			return CXChildVisit_Recurse;
		case CXCursor_TypedefDecl: {
			CXType type = clang_getTypedefDeclUnderlyingType (cursor);
			if (type.kind == CXType_Unexposed) {
				CXString type_spelling_cxstring = clang_getTypeSpelling (type);
				const char *type_spelling = clang_getCString (type_spelling_cxstring);
				if (g_str_has_prefix (type_spelling, "struct ") || g_str_has_prefix (type_spelling, "union ")) {
					CXString spelling_cxstring = clang_getCursorSpelling (cursor);
					const char *spelling = clang_getCString (spelling_cxstring);
					g_assert (!cljc_name_for_type_name (spelling));
					register_compound (spelling);
					printf ("[:compound %s \"sizeof (%s)\"]\n", spelling, spelling);
					clang_disposeString (spelling_cxstring);
				}
				clang_disposeString (type_spelling_cxstring);
			}
			return CXChildVisit_Continue;
		}
		case CXCursor_EnumDecl: {
			CXString spelling_cxstring = clang_getCursorSpelling (cursor);
			const char *spelling = clang_getCString (spelling_cxstring);
			g_assert (visitor_state == STATE_BASE);
			visitor_state = STATE_ENUM;
			g_assert (!enum_name);
			if (strlen (spelling) > 0)
				enum_name = g_strdup (spelling);
			else
				enum_name = NULL;
			have_enum_members = FALSE;
			clang_disposeString (spelling_cxstring);
			return CXChildVisit_Recurse;
		}
		case CXCursor_EnumConstantDecl: {
			CXString spelling_cxstring = clang_getCursorSpelling (cursor);
			const char *spelling = clang_getCString (spelling_cxstring);
			g_assert (visitor_state == STATE_ENUM);
			if (!have_enum_members) {
				printf ("[:enum");
				have_enum_members = TRUE;
			}
			printf (" %s", spelling);
			clang_disposeString (spelling_cxstring);
			return CXChildVisit_Continue;
		}
		case CXCursor_FunctionDecl:
		case CXCursor_ObjCInstanceMethodDecl:
		case CXCursor_ObjCClassMethodDecl: {
			CXString spelling_cxstring = clang_getCursorSpelling (cursor);
			const char *spelling = clang_getCString (spelling_cxstring);

			if (clang_Cursor_isVariadic (cursor)) {
				printf (";;FIXME: variadic %s\n", spelling);
				clang_disposeString (spelling_cxstring);
				return CXChildVisit_Continue;
			}

			gboolean is_function = kind == CXCursor_FunctionDecl;
			int num_args = clang_Cursor_getNumArguments (cursor);
			CXCursor result_cursor;
			clang_visitChildren (cursor, get_first_child_visitor_func, &result_cursor);
			gboolean have_types = cljc_name_for_type (result_cursor, clang_getCursorResultType (cursor)) != NULL;
			if (have_types) {
				for (int i = 0; i < num_args; ++i) {
					CXCursor arg_cursor = clang_Cursor_getArgument (cursor, i);
					if (cljc_name_for_type (arg_cursor, clang_getCursorType (arg_cursor)) == NULL) {
						have_types = FALSE;
						print_type_fixme (cursor, arg_cursor, clang_getCursorType (arg_cursor));
						break;
					}
				}
			} else {
				print_type_fixme (cursor, result_cursor, clang_getCursorResultType (cursor));
			}
			if (have_types) {
				if (is_function)
					printf ("[:function %s", spelling);
				else {
					printf ("[:selector [%d", num_args);
					if (num_args == 0) {
						printf (" :%s", spelling);
					} else {
						char **parts = g_strsplit (spelling, ":", 0);
						for (int i = 0; i < num_args; ++i)
							printf (" :%s", parts [i]);
						g_strfreev (parts);
					}
					printf ("]");
				}
				printf (" [%s", cljc_name_for_type (result_cursor, clang_getCursorResultType (cursor)));
				for (int i = 0; i < num_args; ++i) {
					CXCursor arg_cursor = clang_Cursor_getArgument (cursor, i);
					printf (" %s", cljc_name_for_type (arg_cursor, clang_getCursorType (arg_cursor)));
				}
				printf ("]]\n");
			}
			clang_disposeString (spelling_cxstring);
			return CXChildVisit_Continue;
		}
		default:
			break;
	}
	return CXChildVisit_Continue;
}

int
main (int argc, const char *argv[])
{
	g_assert (argc >= 3);

	framework_name = argv [1];
	/* Remove framework name from argument list */
	for (int i = 1; argv [i]; ++i)
		argv [i] = argv [i + 1];
	--argc;

	CXIndex Index = clang_createIndex(0, 0);
	CXTranslationUnit TU = clang_parseTranslationUnit(Index, 0,
							  argv, argc, 0, 0, CXTranslationUnit_None);
	for (unsigned I = 0, N = clang_getNumDiagnostics(TU); I != N; ++I) {
		CXDiagnostic Diag = clang_getDiagnostic(TU, I);
		CXString String = clang_formatDiagnostic(Diag,
							 clang_defaultDiagnosticDisplayOptions());
		fprintf(stderr, "%s\n", clang_getCString(String));
		clang_disposeString(String);
	}
	CXCursor cursor = clang_getTranslationUnitCursor (TU);

	register_type_name ("BOOL", "Boolean");
	register_type_name ("_Bool", "Boolean");
	register_type_name ("unichar", "Character");

	printf ("[\n");
	clang_visitChildren (cursor, visitor_func, NULL);
	printf ("]\n");
	clang_disposeTranslationUnit(TU);
	clang_disposeIndex(Index);
	return 0;
}
