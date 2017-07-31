# Understand how to read a function in string form and then eval it.


add9_1 = function (x::Int)

return (x + 9)

end



add9_2 = "
function (x::Int)

return (x + 9)

end"


parse(add9_2)




eval(Expr(:call, parse(add9_2), :9))

eval(Expr(:call, parse(add9_2), 9))




julia> code_lowered(add9_1)
1-element Array{LambdaInfo,1}:
 LambdaInfo template for (::##1#2)(x::Int64) at REPL[1]:3

julia> code_lowered(parse(add9_2))
0-element Array{LambdaInfo,1}




function eval_expr(ex )

eval(Expr(ex))

end


julia> code_lowered(add9)[1]
LambdaInfo template for add9(x::Int64) at REPL[118]:3
:(begin
        nothing
        return x + 9
    end)


macroexpand( :(@edit println("")) )

    expand()