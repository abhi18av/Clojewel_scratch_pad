
julia> using Tokenize



julia> str = """
           function foo!{T<:Bar}(x::{T}=12)
               @time (x+x, x+x);
           end
           try
               foo
           catch
               bar
           end
           @time x+x
           y[[1 2 3]]
           [1*2,2;3,4]
           "string"; 'c'
           (a&&b)||(a||b)
           # comment
           #= comment
           is done here =#
           2%5
           a'/b'
           a.'\\b.'
           `command`
           12_sin(12)
           {}
           '
           """


julia> collect(tokenize(str))


julia> println(untokenize(collect(tokenize(str))))


