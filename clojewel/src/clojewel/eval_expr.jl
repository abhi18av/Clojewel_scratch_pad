function eval_expr(expr::String)

parsed_expr = parse(expr)
return eval(eval(parsed_expr))
end



expr = ARGS[1]
print(eval_expr(expr))

