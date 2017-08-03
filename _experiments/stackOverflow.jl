


"""rxpe_esrap: parse expr in reverse :p """
function rpxe_esrap(S_expr::Tuple)
  return Expr( Tuple( isa(i, Tuple) ? rpxe_esrap(i) : i for i in S_expr )... );
end



B  = IOBuffer();              # will use to 'capture' the s_expr in
Expr1 = :(1 + 2 * 3);            # the expr we want to generate an s_expr for

Meta.show_sexpr(B, Expr1);       # push s_expr into buffer B

seek(B, 0);                      # 'rewind' buffer
SExprStr = read(B, String);      # get buffer contents as string


close(B);                        # please to be closink after finished, da?

SExpr = parse(SExprStr) |> eval; # final s_expr in tuple form

SExpr
rpxe_esrap(SExpr)


##############

# corrected code


"""rxpe_esrap: parse expr in reverse :p """
function rpxe_esrap(S_expr::Tuple)
    return Expr( Any[isa(i, Tuple) ? rpxe_esrap(i) : i for i in S_expr]... );
end
    
    
B     = IOBuffer();              # will use to 'capture' the s_expr in
Expr1 = :(function add9( x) x + 9 end);            # the expr we want to generate an s_expr for
Meta.show_sexpr(B, Expr1);       # push s_expr into buffer B
    
    
seek(B, 0);                      # 'rewind' buffer
    SExprStr = readstring(B);      # get buffer contents as string
close(B);                        # please to be closink after finished, da?
SExpr = parse(SExprStr) |> eval;

rpxe_esrap(SExpr) |> show