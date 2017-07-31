# Understand how to read a function in string form and then eval it.


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

julia> add9_1 == add9_2_parsed_evald
false

julia> add9_1(9) == add9_2_parsed_evald(9)
true


eval(Expr(:call, parse(add9_2), :9))

eval(Expr(:call, parse(add9_2), 9))


julia> code_lowered(add9_1)[1]
LambdaInfo template for (::##1#2)(x::Int64) at REPL[1]:3
:(begin
        nothing
        return x + 9
    end)

julia> code_lowered(add9_2_parsed_evald)[1]
LambdaInfo template for (::##5#6)(x::Int64) at none:4
:(begin
        nothing
        return x + 9
    end)



code_lowered(add9_1)[1] == code_lowered(add9_2_parsed_evald)

julia> code_lowered(add9_1)
1-element Array{LambdaInfo,1}:
 LambdaInfo template for (::##1#2)(x::Int64) at REPL[1]:3

julia> code_lowered(parse(add9_2))
0-element Array{LambdaInfo,1}




function eval_expr(ex )

eval(Expr(ex))

end


julia> code_typed(add9_1)[1]
LambdaInfo for (::##1#2)(::Int64)
:(begin
        return (Base.box)(Int64,(Base.add_int)(x,9))
    end::Int64)


julia> code_lowered(add9)[1]
LambdaInfo template for add9(x::Int64) at REPL[118]:3
:(begin
        nothing
        return x + 9
    end)


macroexpand( :(@edit println("")) )

    expand()