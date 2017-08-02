# Understand how to read a function in string form and then eval it.

expression1 = "Expr(:call, :+, 1, 1)"

eval(eval(parse(expression1)))



function eval_from_string_s_expr(s)

eval(eval(parse(s)))

end



Meta.show_sexpr(parse("Expr(:call, :+, 1, 1)"))

parse("Expr(:call, :+, 1, 1)").args

parse("(:call, :+, 1, 1)").args

typeof(eval(x1[2]))


x_plus = eval(x1[2])

x_num1 , x_num2 = eval(x1[3]), eval(x1[4])



@eval(Expr(:call , x_plus, x_num1, x_num2))

eval(Expr(:call , x_plus, x_num1, x_num2))



add9_1 = function (x::Int)

return (x + 9)

end



add9_2 = "
function (x::Int)

return (x + 9)

end"


add9_2_parsed = parse(add9_2)


add9_2_parsed_evald = eval(add9_2_parsed)

parse(add9_2)

add9_1 == add9_2_parsed_evald

add9_1(9) == add9_2_parsed_evald(9)


eval(Expr(:call, parse(add9_2), :9))

eval(Expr(:call, parse(add9_2), 9))


code_lowered(add9_1)[1]
"""
LambdaInfo template for (::##1#2)(x::Int64) at REPL[1]:3
:(begin
        nothing
        return x + 9
    end)


"""


code_lowered(add9_2_parsed_evald)[1]

"""
LambdaInfo template for (::##5#6)(x::Int64) at none:4
:(begin
        nothing
        return x + 9
    end)

"""



code_lowered(add9_1)[1] == code_lowered(add9_2_parsed_evald)

code_lowered(add9_1)

"""
1-element Array{LambdaInfo,1}:
 LambdaInfo template for (::##1#2)(x::Int64) at REPL[1]:3
"""


code_lowered(parse(add9_2))




function eval_expr(ex )

eval(Expr(ex))

end


code_typed(add9_1)[1]

"""
LambdaInfo for (::##1#2)(::Int64)
:(begin
        return (Base.box)(Int64,(Base.add_int)(x,9))
    end::Int64)
"""

code_lowered(add9)[1]

"""
LambdaInfo template for add9(x::Int64) at REPL[118]:3
:(begin
        nothing
        return x + 9
    end)
"""

macroexpand( :(@edit println("")) )

expand()
