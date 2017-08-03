

# parse_reverse: parse expr in reverse :p 
function parse_reverse(S_expr::Tuple)
    return Expr( Any[isa(i, Tuple) ? parse_reverse(i) : i for i in S_expr]... );
end
    
    
buffer = IObufferuffer();              # will use to 'capture' the s_expr in
expr = :(function add9( x) x + 9 end);            # the expr we want to generate an s_expr for

Meta.show_sexpr(expr)
Meta.show_sexpr(buffer, expr);       # push s_expr into buffer buffer
    
    
seek(buffer, 0);                      # 'rewind' buffer
SExprStr = readstring(buffer);      # get buffer contents as string
close(buffer);                # please to be closink after finished, da?

show(SExprStr)
SExpr = parse(SExprStr) |> eval;
show(SExpr)
parse_reverse(SExpr) |> show