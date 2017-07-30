#println("Hello, world!")

 
#http://web.mit.edu/julia_v0.5.0/.julia-3c9d75391c.amd64_ubuntu1404/share/doc/julia/html/manual/metaprogramming.html


#https://en.wikibooks.org/wiki/Introducing_Julia/Metaprogramming#eval.28.29_and_.40eval

#http://web.mit.edu/julia_v0.5.0/.julia-3c9d75391c.amd64_ubuntu1404/share/doc/julia/html/manual/types.html


#https://sylvaticus.gitbooks.io/julia-language-a-concise-tutorial/content/metaprogramming.html



#https://github.com/chrisvoncsefalvay/learn-julia-the-hard-way

#ex1 = quote 1 + 1 end

#ex2 = (:call , :+ , 1 , 1)


#ex3 = Expr(:call, :*, 1, 1)


#ex4 = quote
#    convert(::Type{Bool}, x::Bool) = x
#convert(::Type{Bool}, x::Real) = x==0 ? false : x==1 ? true : throw(InexactError())

# promote Bool to any other numeric type
#promote_rule{T<:Number}(::Type{Bool}, ::Type{T}) = T

#typemin(::Type{Bool}) = false
#typemax(::Type{Bool}) = true

#end





jl_bool_source_file = quote 

# This file is a part of Julia. License is MIT: https://julialang.org/license

## boolean conversions ##

convert(::Type{Bool}, x::Bool) = x
convert(::Type{Bool}, x::Real) = x==0 ? false : x==1 ? true : throw(InexactError())

# promote Bool to any other numeric type
promote_rule{T<:Number}(::Type{Bool}, ::Type{T}) = T

typemin(::Type{Bool}) = false
typemax(::Type{Bool}) = true

## boolean operations ##

!(x::Bool) = box(Bool,not_int(unbox(Bool,x)))

(~)(x::Bool) = !x
(&)(x::Bool, y::Bool) = box(Bool,and_int(unbox(Bool,x),unbox(Bool,y)))
(|)(x::Bool, y::Bool) = box(Bool,or_int(unbox(Bool,x),unbox(Bool,y)))
($)(x::Bool, y::Bool) = (x!=y)

>>(x::Bool, c::Unsigned) = Int(x) >> c
<<(x::Bool, c::Unsigned) = Int(x) << c
>>>(x::Bool, c::Unsigned) = Int(x) >>> c

>>(x::Bool, c::Int) = Int(x) >> c
<<(x::Bool, c::Int) = Int(x) << c
>>>(x::Bool, c::Int) = Int(x) >>> c

>>(x::Bool, c::Integer) = Int(x) >> c
<<(x::Bool, c::Integer) = Int(x) << c
>>>(x::Bool, c::Integer) = Int(x) >>> c

signbit(x::Bool) = false
sign(x::Bool) = x
abs(x::Bool) = x
abs2(x::Bool) = x

<(x::Bool, y::Bool) = y&!x
<=(x::Bool, y::Bool) = y|!x

## do arithmetic as Int ##

+(x::Bool) =  Int(x)
-(x::Bool) = -Int(x)

+(x::Bool, y::Bool) = Int(x) + Int(y)
-(x::Bool, y::Bool) = Int(x) - Int(y)
*(x::Bool, y::Bool) = x & y
^(x::Bool, y::Bool) = x | !y
^(x::Integer, y::Bool) = ifelse(y, x, one(x))

function +{T<:AbstractFloat}(x::Bool, y::T)::promote_type(Bool,T)
    return ifelse(x, one(y) + y, y)
end
+(y::AbstractFloat, x::Bool) = x + y

function *{T<:Number}(x::Bool, y::T)::promote_type(Bool,T)
    return ifelse(x, y, copysign(zero(y), y))
end
function *{T<:Unsigned}(x::Bool, y::T)::promote_type(Bool,T)
    return ifelse(x, y, zero(y))
end
*(y::Number, x::Bool) = x * y

div(x::Bool, y::Bool) = y ? x : throw(DivideError())
fld(x::Bool, y::Bool) = div(x,y)
cld(x::Bool, y::Bool) = div(x,y)
rem(x::Bool, y::Bool) = y ? false : throw(DivideError())
mod(x::Bool, y::Bool) = rem(x,y)




end






function show_s_expr(jl_expr::Expr)
    
    jl_expr_str = string(jl_expr)
    quoted_expr = parse(jl_expr_str)
    s_expr = Meta.show_sexpr(quoted_expr)
    #s_expr = Meta.show_sexpr(jl_expr)
    
    return s_expr
    
end







show_s_expr(jl_bool_source_file)







# """
# ex = quote
#            x = 1
#            y = 2
#            x + y
#        end
# 
# 
# Meta.show_sexpr(ex) 
# 
# """
# 
# 
# function make_expr2(op, opr1, opr2)
#            opr1f, opr2f = map(x -> isa(x, Number) ? 2*x : x, (opr1, opr2))
#            retexpr = Expr(:call, op, opr1f, opr2f)
#            return retexpr
#        end
# 
#
# Meta.show_sexpr((make_expr2))
#  */


#Meta.show_sexpr(:(function f(x,y)                                        
#                      x + y                                                         
#                  end))    




#expr = quote 
#    function hypot(x,y)
#           x = abs(x)
#           y = abs(y)
#           if x > y
#               r = y/x
#               return x*sqrt(1+r*r)
#           end
#           if y == 0
#               return zero(x)
#           end
#           r = x/y
#           return y*sqrt(1+r*r)
#       end
#end


#Meta.show_sexpr(expr)























