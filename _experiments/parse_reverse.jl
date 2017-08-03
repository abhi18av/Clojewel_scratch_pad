

# parse_reverse: parse expr in reverse :p 
function parse_reverse(S_expr::Tuple)
    return Expr( Any[isa(i, Tuple) ? parse_reverse(i) : i for i in S_expr]... );
end
    
    
B  = IOBuffer();              # will use to 'capture' the s_expr in
Expr1 = :(function add9( x) x + 9 end);            # the expr we want to generate an s_expr for
Meta.show_sexpr(B, Expr1);       # push s_expr into buffer B
    
    
seek(B, 0);                      # 'rewind' buffer
SExprStr = readstring(B);      # get buffer contents as string
close(B);                        # please to be closink after finished, da?
SExpr = parse(SExprStr) |> eval;

parse_reverse(SExpr) |> show