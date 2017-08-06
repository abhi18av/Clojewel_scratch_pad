function show_s_expr(expr::String)

parsed_expr = parse(expr)
return Meta.show_sexpr(parsed_expr)
end



expr = ARGS[1]
show_s_expr(expr)

