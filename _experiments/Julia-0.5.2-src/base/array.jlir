(:quote, (:block,
    (:line, 5, :none),
    (:typealias, (:curly, :Vector, :T), (:curly, :Array, :T, 1)),
    (:line, 6, :none),
    (:typealias, (:curly, :Matrix, :T), (:curly, :Array, :T, 2)),
    (:line, 7, :none),
    (:typealias, (:curly, :VecOrMat, :T), (:curly, :Union, (:curly, :Vector, :T), (:curly, :Matrix, :T))),
    (:line, 9, :none),
    (:typealias, (:curly, :DenseVector, :T), (:curly, :DenseArray, :T, 1)),
    (:line, 10, :none),
    (:typealias, (:curly, :DenseMatrix, :T), (:curly, :DenseArray, :T, 2)),
    (:line, 11, :none),
    (:typealias, (:curly, :DenseVecOrMat, :T), (:curly, :Union, (:curly, :DenseVector, :T), (:curly, :DenseMatrix, :T))),
    (:line, 15, :none),
    (:toplevel, (:import, :Core, :arraysize), (:import, :Core, :arrayset), (:import, :Core, :arrayref)),
    (:line, 17, :none),
    (:(=), (:call, :size, (:(::), :a, :Array), :d), (:block,
        (:line, 17, :none),
        (:call, :arraysize, :a, :d)
      )),
    (:line, 18, :none),
    (:(=), (:call, :size, (:(::), :a, :Vector)), (:block,
        (:line, 18, :none),
        (:tuple, (:call, :arraysize, :a, 1))
      )),
    (:line, 19, :none),
    (:(=), (:call, :size, (:(::), :a, :Matrix)), (:block,
        (:line, 19, :none),
        (:tuple, (:call, :arraysize, :a, 1), (:call, :arraysize, :a, 2))
      )),
    (:line, 20, :none),
    (:(=), (:call, :size, (:(::), :a, :Array)), (:block,
        (:line, 20, :none),
        (:block,
          (:macrocall, Symbol("@_inline_meta")),
          (:call, :_size, (:tuple,), :a)
        )
      )),
    (:line, 21, :none),
    (:(=), (:call, (:curly, :_size, :_, :N), (:(::), :out, (:curly, :NTuple, :N)), (:(::), :A, (:curly, :Array, :_, :N))), (:block,
        (:line, 21, :none),
        :out
      )),
    (:line, 22, :none),
    (:function, (:call, (:curly, :_size, :_, :M, :N), (:(::), :out, (:curly, :NTuple, :M)), (:(::), :A, (:curly, :Array, :_, :N))), (:block,
        (:line, 23, :none),
        (:macrocall, Symbol("@_inline_meta")),
        (:line, 24, :none),
        (:call, :_size, (:tuple, (:..., :out), (:call, :size, :A, (:call, :+, :M, 1))), :A)
      )),
    (:line, 27, :none),
    (:(=), (:call, :asize_from, (:(::), :a, :Array), :n), (:block,
        (:line, 27, :none),
        (:if, (:call, :>, :n, (:call, :ndims, :a)), (:tuple,), (:tuple, (:call, :arraysize, :a, :n), (:..., (:call, :asize_from, :a, (:call, :+, :n, 1)))))
      )),
    (:line, 29, :none),
    (:(=), (:call, :length, (:(::), :a, :Array)), (:block,
        (:line, 29, :none),
        (:call, :arraylen, :a)
      )),
    (:line, 30, :none),
    (:(=), (:call, (:curly, :elsize, :T), (:(::), :a, (:curly, :Array, :T))), (:block,
        (:line, 30, :none),
        (:if, (:call, :isbits, :T), (:call, :sizeof, :T), (:call, :sizeof, :Ptr))
      )),
    (:line, 31, :none),
    (:(=), (:call, :sizeof, (:(::), :a, :Array)), (:block,
        (:line, 31, :none),
        (:call, :*, (:call, :elsize, :a), (:call, :length, :a))
      )),
    (:line, 33, :none),
    (:function, (:call, (:curly, :isassigned, :T), (:(::), :a, (:curly, :Array, :T)), (:..., (:(::), :i, :Int))), (:block,
        (:line, 34, :none),
        (:(=), :ii, (:call, :sub2ind, (:call, :size, :a), (:..., :i))),
        (:line, 35, :none),
        (:||, (:comparison, 1, :(<=), :ii, :(<=), (:call, :length, :a)), (:return, false)),
        (:line, 36, :none),
        (:call, :(==), (:ccall, (:quote, #QuoteNode
              :jl_array_isassigned
            ), :Cint, (:tuple, :Any, :UInt), :a, (:call, :-, :ii, 1)), 1)
      )),
    (:line, 41, :none),
    (:function, (:call, (:curly, :unsafe_copy!, :T), (:(::), :dest, (:curly, :Ptr, :T)), (:(::), :src, (:curly, :Ptr, :T)), :n), (:block,
        (:line, 44, :none),
        (:ccall, (:quote, #QuoteNode
            :memmove
          ), (:curly, :Ptr, :Void), (:tuple, (:curly, :Ptr, :Void), (:curly, :Ptr, :Void), :UInt), :dest, :src, (:call, :*, :n, (:call, :sizeof, :T))),
        (:line, 46, :none),
        (:return, :dest)
      )),
    (:line, 49, :none),
    (:function, (:call, (:curly, :unsafe_copy!, :T), (:(::), :dest, (:curly, :Array, :T)), :doffs, (:(::), :src, (:curly, :Array, :T)), :soffs, :n), (:block,
        (:line, 50, :none),
        (:if, (:call, :isbits, :T), (:block,
            (:line, 51, :none),
            (:call, :unsafe_copy!, (:call, :pointer, :dest, :doffs), (:call, :pointer, :src, :soffs), :n)
          ), (:block,
            (:line, 53, :none),
            (:ccall, (:quote, #QuoteNode
                :jl_array_ptr_copy
              ), :Void, (:tuple, :Any, (:curly, :Ptr, :Void), :Any, (:curly, :Ptr, :Void), :Int), :dest, (:call, :pointer, :dest, :doffs), :src, (:call, :pointer, :src, :soffs), :n)
          )),
        (:line, 56, :none),
        (:return, :dest)
      )),
    (:line, 59, :none),
    (:function, (:call, (:curly, :copy!, :T), (:(::), :dest, (:curly, :Array, :T)), (:(::), :doffs, :Integer), (:(::), :src, (:curly, :Array, :T)), (:(::), :soffs, :Integer), (:(::), :n, :Integer)), (:block,
        (:line, 60, :none),
        (:&&, (:call, :(==), :n, 0), (:return, :dest)),
        (:line, 61, :none),
        (:||, (:call, :>, :n, 0), (:call, :throw, (:call, :ArgumentError, (:call, :string, "tried to copy n=", :n, " elements, but n should be nonnegative")))),
        (:line, 62, :none),
        (:if, (:||, (:call, :<, :soffs, 1), (:||, (:call, :<, :doffs, 1), (:||, (:call, :>, (:call, :-, (:call, :+, :soffs, :n), 1), (:call, :length, :src)), (:call, :>, (:call, :-, (:call, :+, :doffs, :n), 1), (:call, :length, :dest))))), (:block,
            (:line, 63, :none),
            (:call, :throw, (:call, :BoundsError))
          )),
        (:line, 65, :none),
        (:call, :unsafe_copy!, :dest, :doffs, :src, :soffs, :n)
      )),
    (:line, 68, :none),
    (:(=), (:call, (:curly, :copy!, :T), (:(::), :dest, (:curly, :Array, :T)), (:(::), :src, (:curly, :Array, :T))), (:block,
        (:line, 68, :none),
        (:call, :copy!, :dest, 1, :src, 1, (:call, :length, :src))
      )),
    (:line, 70, :none),
    (:(=), (:call, (:curly, :copy, (:<:, :T, :Array)), (:(::), :a, :T)), (:block,
        (:line, 70, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_copy
          ), (:curly, :Ref, :T), (:tuple, :Any), :a)
      )),
    (:line, 72, :none),
    (:function, (:call, (:curly, :reinterpret, :T, :S), (:(::), (:curly, :Type, :T)), (:(::), :a, (:curly, :Array, :S, 1))), (:block,
        (:line, 73, :none),
        (:(=), :nel, (:call, :Int, (:call, :div, (:call, :*, (:call, :length, :a), (:call, :sizeof, :S)), (:call, :sizeof, :T)))),
        (:line, 75, :none),
        (:return, (:call, :reinterpret, :T, :a, (:tuple, :nel)))
      )),
    (:line, 78, :none),
    (:function, (:call, (:curly, :reinterpret, :T, :S), (:(::), (:curly, :Type, :T)), (:(::), :a, (:curly, :Array, :S))), (:block,
        (:line, 79, :none),
        (:if, (:call, :(!=), (:call, :sizeof, :S), (:call, :sizeof, :T)), (:block,
            (:line, 80, :none),
            (:call, :throw, (:call, :ArgumentError, "result shape not specified"))
          )),
        (:line, 82, :none),
        (:call, :reinterpret, :T, :a, (:call, :size, :a))
      )),
    (:line, 85, :none),
    (:function, (:call, (:curly, :reinterpret, :T, :S, :N), (:(::), (:curly, :Type, :T)), (:(::), :a, (:curly, :Array, :S)), (:(::), :dims, (:curly, :NTuple, :N, :Int))), (:block,
        (:line, 86, :none),
        (:if, (:call, :!, (:call, :isbits, :T)), (:block,
            (:line, 87, :none),
            (:call, :throw, (:call, :ArgumentError, (:string, "cannot reinterpret Array{", :S, "} to ::Type{Array{", :T, "}}, type ", :T, " is not a bitstype")))
          )),
        (:line, 89, :none),
        (:if, (:call, :!, (:call, :isbits, :S)), (:block,
            (:line, 90, :none),
            (:call, :throw, (:call, :ArgumentError, (:string, "cannot reinterpret Array{", :S, "} to ::Type{Array{", :T, "}}, type ", :S, " is not a bitstype")))
          )),
        (:line, 92, :none),
        (:(=), :nel, (:call, :div, (:call, :*, (:call, :length, :a), (:call, :sizeof, :S)), (:call, :sizeof, :T))),
        (:line, 93, :none),
        (:if, (:call, :(!=), (:call, :prod, :dims), :nel), (:block,
            (:line, 94, :none),
            (:call, :throw, (:call, :DimensionMismatch, (:string, "new dimensions ", :dims, " must be consistent with array size ", :nel)))
          )),
        (:line, 96, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_reshape_array
          ), (:curly, :Array, :T, :N), (:tuple, :Any, :Any, :Any), (:curly, :Array, :T, :N), :a, :dims)
      )),
    (:line, 100, :none),
    (:function, (:call, (:curly, :reshape, :T, :N), (:(::), :a, (:curly, :Array, :T, :N)), (:(::), :dims, (:curly, :NTuple, :N, :Int))), (:block,
        (:line, 101, :none),
        (:if, (:call, :(!=), (:call, :prod, :dims), (:call, :length, :a)), (:block,
            (:line, 102, :none),
            (:call, :throw, (:call, :DimensionMismatch, (:string, "new dimensions ", :dims, " must be consistent with array size ", (:call, :length, :a))))
          )),
        (:line, 104, :none),
        (:if, (:call, :(==), :dims, (:call, :size, :a)), (:block,
            (:line, 105, :none),
            (:return, :a)
          )),
        (:line, 107, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_reshape_array
          ), (:curly, :Array, :T, :N), (:tuple, :Any, :Any, :Any), (:curly, :Array, :T, :N), :a, :dims)
      )),
    (:line, 111, :none),
    (:function, (:call, (:curly, :reshape, :T, :N), (:(::), :a, (:curly, :Array, :T)), (:(::), :dims, (:curly, :NTuple, :N, :Int))), (:block,
        (:line, 112, :none),
        (:if, (:call, :(!=), (:call, :prod, :dims), (:call, :length, :a)), (:block,
            (:line, 113, :none),
            (:call, :throw, (:call, :DimensionMismatch, (:string, "new dimensions ", :dims, " must be consistent with array size ", (:call, :length, :a))))
          )),
        (:line, 115, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_reshape_array
          ), (:curly, :Array, :T, :N), (:tuple, :Any, :Any, :Any), (:curly, :Array, :T, :N), :a, :dims)
      )),
    (:line, 120, :none),
    (:(=), (:call, (:curly, :similar, :T), (:(::), :a, (:curly, :Array, :T, 1))), (:block,
        (:line, 120, :none),
        (:call, (:curly, :Array, :T, 1), (:call, :size, :a, 1))
      )),
    (:line, 121, :none),
    (:(=), (:call, (:curly, :similar, :T), (:(::), :a, (:curly, :Array, :T, 2))), (:block,
        (:line, 121, :none),
        (:call, (:curly, :Array, :T, 2), (:call, :size, :a, 1), (:call, :size, :a, 2))
      )),
    (:line, 122, :none),
    (:(=), (:call, (:curly, :similar, :T), (:(::), :a, (:curly, :Array, :T, 1)), (:(::), :S, :Type)), (:block,
        (:line, 122, :none),
        (:call, (:curly, :Array, :S, 1), (:call, :size, :a, 1))
      )),
    (:line, 123, :none),
    (:(=), (:call, (:curly, :similar, :T), (:(::), :a, (:curly, :Array, :T, 2)), (:(::), :S, :Type)), (:block,
        (:line, 123, :none),
        (:call, (:curly, :Array, :S, 2), (:call, :size, :a, 1), (:call, :size, :a, 2))
      )),
    (:line, 124, :none),
    (:(=), (:call, (:curly, :similar, :T), (:(::), :a, (:curly, :Array, :T)), (:(::), :m, :Int)), (:block,
        (:line, 124, :none),
        (:call, (:curly, :Array, :T, 1), :m)
      )),
    (:line, 125, :none),
    (:(=), (:call, (:curly, :similar, :N), (:(::), :a, :Array), (:(::), :T, :Type), (:(::), :dims, (:curly, :Dims, :N))), (:block,
        (:line, 125, :none),
        (:call, (:curly, :Array, :T, :N), :dims)
      )),
    (:line, 126, :none),
    (:(=), (:call, (:curly, :similar, :T, :N), (:(::), :a, (:curly, :Array, :T)), (:(::), :dims, (:curly, :Dims, :N))), (:block,
        (:line, 126, :none),
        (:call, (:curly, :Array, :T, :N), :dims)
      )),
    (:line, 129, :none),
    (:function, (:call, (:curly, :getindex, :T), (:(::), (:curly, :Type, :T)), (:..., :vals)), (:block,
        (:line, 130, :none),
        (:(=), :a, (:call, (:curly, :Array, :T, 1), (:call, :length, :vals))),
        (:line, 131, :none),
        (:macrocall, Symbol("@inbounds"), (:for, (:(=), :i, (:(:), 1, (:call, :length, :vals))), (:block,
              (:line, 132, :none),
              (:(=), (:ref, :a, :i), (:ref, :vals, :i))
            ))),
        (:line, 134, :none),
        (:return, :a)
      )),
    (:line, 137, :none),
    (:(=), (:call, (:curly, :getindex, :T), (:(::), (:curly, :Type, :T))), (:block,
        (:line, 137, :none),
        (:block,
          (:macrocall, Symbol("@_inline_meta")),
          (:call, (:curly, :Array, :T, 1), 0)
        )
      )),
    (:line, 138, :none),
    (:(=), (:call, (:curly, :getindex, :T), (:(::), (:curly, :Type, :T)), :x), (:block,
        (:line, 138, :none),
        (:block,
          (:macrocall, Symbol("@_inline_meta")),
          (:(=), :a, (:call, (:curly, :Array, :T, 1), 1)),
          (:macrocall, Symbol("@inbounds"), (:(=), (:ref, :a, 1), :x)),
          :a
        )
      )),
    (:line, 139, :none),
    (:(=), (:call, (:curly, :getindex, :T), (:(::), (:curly, :Type, :T)), :x, :y), (:block,
        (:line, 139, :none),
        (:block,
          (:macrocall, Symbol("@_inline_meta")),
          (:(=), :a, (:call, (:curly, :Array, :T, 1), 2)),
          (:macrocall, Symbol("@inbounds"), (:block,
              (:(=), (:ref, :a, 1), :x),
              (:(=), (:ref, :a, 2), :y)
            )),
          :a
        )
      )),
    (:line, 140, :none),
    (:(=), (:call, (:curly, :getindex, :T), (:(::), (:curly, :Type, :T)), :x, :y, :z), (:block,
        (:line, 140, :none),
        (:block,
          (:macrocall, Symbol("@_inline_meta")),
          (:(=), :a, (:call, (:curly, :Array, :T, 1), 3)),
          (:macrocall, Symbol("@inbounds"), (:block,
              (:(=), (:ref, :a, 1), :x),
              (:(=), (:ref, :a, 2), :y),
              (:(=), (:ref, :a, 3), :z)
            )),
          :a
        )
      )),
    (:line, 142, :none),
    (:function, (:call, :getindex, (:(::), (:curly, :Type, :Any)), (:..., (:(::), :vals, :ANY))), (:block,
        (:line, 143, :none),
        (:(=), :a, (:call, (:curly, :Array, :Any, 1), (:call, :length, :vals))),
        (:line, 144, :none),
        (:macrocall, Symbol("@inbounds"), (:for, (:(=), :i, (:(:), 1, (:call, :length, :vals))), (:block,
              (:line, 145, :none),
              (:(=), (:ref, :a, :i), (:ref, :vals, :i))
            ))),
        (:line, 147, :none),
        (:return, :a)
      )),
    (:line, 149, :none),
    (:(=), (:call, :getindex, (:(::), (:curly, :Type, :Any))), (:block,
        (:line, 149, :none),
        (:call, (:curly, :Array, :Any, 1), 0)
      )),
    (:line, 151, :none),
    (:function, (:call, :fill!, (:(::), :a, (:curly, :Union, (:curly, :Array, :UInt8), (:curly, :Array, :Int8))), (:(::), :x, :Integer)), (:block,
        (:line, 152, :none),
        (:ccall, (:quote, #QuoteNode
            :memset
          ), (:curly, :Ptr, :Void), (:tuple, (:curly, :Ptr, :Void), :Cint, :Csize_t), :a, :x, (:call, :length, :a)),
        (:line, 153, :none),
        (:return, :a)
      )),
    (:line, 156, :none),
    (:function, (:call, (:curly, :fill!, (:<:, :T, (:curly, :Union, :Integer, :AbstractFloat))), (:(::), :a, (:curly, :Array, :T)), :x), (:block,
        (:line, 157, :none),
        (:(=), :xT, (:call, :convert, :T, :x)),
        (:line, 158, :none),
        (:for, (:(=), :i, (:call, :eachindex, :a)), (:block,
            (:line, 159, :none),
            (:macrocall, Symbol("@inbounds"), (:(=), (:ref, :a, :i), :xT))
          )),
        (:line, 161, :none),
        (:return, :a)
      )),
    (:line, 164, :none),
    (:(=), (:call, :fill, :v, (:(::), :dims, :Dims)), (:block,
        (:line, 164, :none),
        (:call, :fill!, (:call, (:curly, :Array, (:call, :typeof, :v)), :dims), :v)
      )),
    (:line, 165, :none),
    (:(=), (:call, :fill, :v, (:..., (:(::), :dims, :Integer))), (:block,
        (:line, 165, :none),
        (:call, :fill!, (:call, (:curly, :Array, (:call, :typeof, :v)), (:..., :dims)), :v)
      )),
    (:line, 167, :none),
    (:for, (:(=), (:tuple, :fname, :felt), (:tuple, (:tuple, (:quote, #QuoteNode
              :zeros
            ), (:quote, #QuoteNode
              :zero
            )), (:tuple, (:quote, #QuoteNode
              :ones
            ), (:quote, #QuoteNode
              :one
            )))), (:block,
        (:line, 168, :none),
        (:macrocall, Symbol("@eval"), (:block,
            (:line, 169, :none),
            (:(=), (:call, (:$, :fname), (:(::), :T, :Type), (:..., :dims)), (:block,
                (:line, 169, :none),
                (:call, :fill!, (:call, (:curly, :Array, :T), (:..., :dims)), (:call, (:$, :felt), :T))
              )),
            (:line, 170, :none),
            (:(=), (:call, (:$, :fname), (:..., :dims)), (:block,
                (:line, 170, :none),
                (:call, :fill!, (:call, (:curly, :Array, :Float64), (:..., :dims)), (:call, (:$, :felt), :Float64))
              )),
            (:line, 171, :none),
            (:(=), (:call, (:curly, (:$, :fname), :T), (:(::), :A, (:curly, :AbstractArray, :T))), (:block,
                (:line, 171, :none),
                (:call, :fill!, (:call, :similar, :A), (:call, (:$, :felt), :T))
              ))
          ))
      )),
    (:line, 175, :none),
    "    eye([T::Type=Float64,] m::Integer, n::Integer)\n\n`m`-by-`n` identity matrix.\nThe default element type is `Float64`.\n",
    (:line, 181, :none),
    (:function, (:call, :eye, (:(::), :T, :Type), (:(::), :m, :Integer), (:(::), :n, :Integer)), (:block,
        (:line, 182, :none),
        (:(=), :a, (:call, :zeros, :T, :m, :n)),
        (:line, 183, :none),
        (:for, (:(=), :i, (:(:), 1, (:call, :min, :m, :n))), (:block,
            (:line, 184, :none),
            (:(=), (:ref, :a, :i, :i), (:call, :one, :T))
          )),
        (:line, 186, :none),
        (:return, :a)
      )),
    (:line, 188, :none),
    (:(=), (:call, :eye, (:(::), :m, :Integer), (:(::), :n, :Integer)), (:block,
        (:line, 188, :none),
        (:call, :eye, :Float64, :m, :n)
      )),
    (:line, 189, :none),
    (:(=), (:call, :eye, (:(::), :T, :Type), (:(::), :n, :Integer)), (:block,
        (:line, 189, :none),
        (:call, :eye, :T, :n, :n)
      )),
    (:line, 190, :none),
    "    eye([T::Type=Float64,] n::Integer)\n\n`n`-by-`n` identity matrix.\nThe default element type is `Float64`.\n",
    (:line, 196, :none),
    (:(=), (:call, :eye, (:(::), :n, :Integer)), (:block,
        (:line, 196, :none),
        (:call, :eye, :Float64, :n)
      )),
    (:line, 198, :none),
    "    eye(A)\n\nConstructs an identity matrix of the same dimensions and type as `A`.\n\n```jldoctest\njulia> A = [1 2 3; 4 5 6; 7 8 9]\n3×3 Array{Int64,2}:\n 1  2  3\n 4  5  6\n 7  8  9\n\njulia> eye(A)\n3×3 Array{Int64,2}:\n 1  0  0\n 0  1  0\n 0  0  1\n```\n\nNote the difference from [`ones`](:func:`ones`).\n",
    (:line, 219, :none),
    (:(=), (:call, (:curly, :eye, :T), (:(::), :x, (:curly, :AbstractMatrix, :T))), (:block,
        (:line, 219, :none),
        (:call, :eye, :T, (:call, :size, :x, 1), (:call, :size, :x, 2))
      )),
    (:line, 221, :none),
    (:function, (:call, (:curly, :one, :T), (:(::), :x, (:curly, :AbstractMatrix, :T))), (:block,
        (:line, 222, :none),
        (:(=), (:tuple, :m, :n), (:call, :size, :x)),
        (:line, 223, :none),
        (:||, (:call, :(==), :m, :n), (:call, :throw, (:call, :DimensionMismatch, "multiplicative identity defined only for square matrices"))),
        (:line, 224, :none),
        (:call, :eye, :T, :m)
      )),
    (:line, 229, :none),
    (:(=), (:call, (:curly, :convert, :T), (:(::), (:curly, :Type, :Vector)), (:(::), :x, (:curly, :AbstractVector, :T))), (:block,
        (:line, 229, :none),
        (:call, :convert, (:curly, :Vector, :T), :x)
      )),
    (:line, 230, :none),
    (:(=), (:call, (:curly, :convert, :T), (:(::), (:curly, :Type, :Matrix)), (:(::), :x, (:curly, :AbstractMatrix, :T))), (:block,
        (:line, 230, :none),
        (:call, :convert, (:curly, :Matrix, :T), :x)
      )),
    (:line, 232, :none),
    (:(=), (:call, (:curly, :convert, :T, :n), (:(::), (:curly, :Type, (:curly, :Array, :T))), (:(::), :x, (:curly, :Array, :T, :n))), (:block,
        (:line, 232, :none),
        :x
      )),
    (:line, 233, :none),
    (:(=), (:call, (:curly, :convert, :T, :n), (:(::), (:curly, :Type, (:curly, :Array, :T, :n))), (:(::), :x, (:curly, :Array, :T, :n))), (:block,
        (:line, 233, :none),
        :x
      )),
    (:line, 235, :none),
    (:(=), (:call, (:curly, :convert, :T, :n, :S), (:(::), (:curly, :Type, (:curly, :Array, :T))), (:(::), :x, (:curly, :AbstractArray, :S, :n))), (:block,
        (:line, 235, :none),
        (:call, :convert, (:curly, :Array, :T, :n), :x)
      )),
    (:line, 236, :none),
    (:(=), (:call, (:curly, :convert, :T, :n, :S), (:(::), (:curly, :Type, (:curly, :Array, :T, :n))), (:(::), :x, (:curly, :AbstractArray, :S, :n))), (:block,
        (:line, 236, :none),
        (:call, :copy!, (:call, (:curly, :Array, :T, :n), (:call, :size, :x)), :x)
      )),
    (:line, 238, :none),
    (:(=), (:call, (:curly, :promote_rule, :T, :n, :S), (:(::), (:curly, :Type, (:curly, :Array, :T, :n))), (:(::), (:curly, :Type, (:curly, :Array, :S, :n)))), (:block,
        (:line, 238, :none),
        (:curly, :Array, (:call, :promote_type, :T, :S), :n)
      )),
    (:line, 242, :none),
    "    collect(element_type, collection)\n\nReturn an `Array` with the given element type of all items in a collection or iterable.\nThe result has the same shape and number of dimensions as `collection`.\n",
    (:line, 248, :none),
    (:(=), (:call, (:curly, :collect, :T), (:(::), (:curly, :Type, :T)), :itr), (:block,
        (:line, 248, :none),
        (:call, :_collect, :T, :itr, (:call, :iteratorsize, :itr))
      )),
    (:line, 250, :none),
    (:(=), (:call, (:curly, :_collect, :T), (:(::), (:curly, :Type, :T)), :itr, (:(::), :isz, :HasLength)), (:block,
        (:line, 250, :none),
        (:call, :copy!, (:call, (:curly, :Array, :T, 1), (:call, :Int, (:(::), (:call, :length, :itr), :Integer))), :itr)
      )),
    (:line, 251, :none),
    (:(=), (:call, (:curly, :_collect, :T), (:(::), (:curly, :Type, :T)), :itr, (:(::), :isz, :HasShape)), (:block,
        (:line, 251, :none),
        (:call, :copy!, (:call, :similar, (:curly, :Array, :T), (:call, :indices, :itr)), :itr)
      )),
    (:line, 252, :none),
    (:function, (:call, (:curly, :_collect, :T), (:(::), (:curly, :Type, :T)), :itr, (:(::), :isz, :SizeUnknown)), (:block,
        (:line, 253, :none),
        (:(=), :a, (:call, (:curly, :Array, :T, 1), 0)),
        (:line, 254, :none),
        (:for, (:(=), :x, :itr), (:block,
            (:line, 255, :none),
            (:call, :push!, :a, :x)
          )),
        (:line, 257, :none),
        (:return, :a)
      )),
    (:line, 261, :none),
    (:(=), (:call, :_similar_for, (:(::), :c, :AbstractArray), :T, :itr, (:(::), :SizeUnknown)), (:block,
        (:line, 261, :none),
        (:call, :similar, :c, :T, 0)
      )),
    (:line, 262, :none),
    (:(=), (:call, :_similar_for, (:(::), :c, :AbstractArray), :T, :itr, (:(::), :HasLength)), (:block,
        (:line, 262, :none),
        (:call, :similar, :c, :T, (:call, :Int, (:(::), (:call, :length, :itr), :Integer)))
      )),
    (:line, 263, :none),
    (:(=), (:call, :_similar_for, (:(::), :c, :AbstractArray), :T, :itr, (:(::), :HasShape)), (:block,
        (:line, 263, :none),
        (:call, :similar, :c, :T, (:call, :indices, :itr))
      )),
    (:line, 264, :none),
    (:(=), (:call, :_similar_for, :c, :T, :itr, :isz), (:block,
        (:line, 264, :none),
        (:call, :similar, :c, :T)
      )),
    (:line, 266, :none),
    "    collect(collection)\n\nReturn an `Array` of all items in a collection or iterator. For associative collections, returns\n`Pair{KeyType, ValType}`. If the argument is array-like or is an iterator with the `HasShape()`\ntrait, the result will have the same shape and number of dimensions as the argument.\n",
    (:line, 273, :none),
    (:(=), (:call, :collect, :itr), (:block,
        (:line, 273, :none),
        (:call, :_collect, (:(:), 1, 1), :itr, (:call, :iteratoreltype, :itr), (:call, :iteratorsize, :itr))
      )),
    (:line, 275, :none),
    (:(=), (:call, :collect_similar, :cont, :itr), (:block,
        (:line, 275, :none),
        (:call, :_collect, :cont, :itr, (:call, :iteratoreltype, :itr), (:call, :iteratorsize, :itr))
      )),
    (:line, 277, :none),
    (:(=), (:call, :_collect, :cont, :itr, (:(::), :HasEltype), (:(::), :isz, (:curly, :Union, :HasLength, :HasShape))), (:block,
        (:line, 277, :none),
        (:call, :copy!, (:call, :_similar_for, :cont, (:call, :eltype, :itr), :itr, :isz), :itr)
      )),
    (:line, 280, :none),
    (:function, (:call, :_collect, :cont, :itr, (:(::), :HasEltype), (:(::), :isz, :SizeUnknown)), (:block,
        (:line, 281, :none),
        (:(=), :a, (:call, :_similar_for, :cont, (:call, :eltype, :itr), :itr, :isz)),
        (:line, 282, :none),
        (:for, (:(=), :x, :itr), (:block,
            (:line, 283, :none),
            (:call, :push!, :a, :x)
          )),
        (:line, 285, :none),
        (:return, :a)
      )),
    (:line, 288, :none),
    (:if, (:call, :isdefined, :Core, (:quote, #QuoteNode
          :Inference
        )), (:block,
        (:line, 289, :none),
        (:(=), (:call, :_default_eltype, (:(::), :itrt, :ANY)), (:block,
            (:line, 289, :none),
            (:call, (:., (:., :Core, (:quote, #QuoteNode
                    :Inference
                  )), (:quote, #QuoteNode
                  :return_type
                )), :first, (:curly, :Tuple, :itrt))
          ))
      ), (:block,
        (:line, 291, :none),
        (:(=), (:call, :_default_eltype, (:(::), :itr, :ANY)), (:block,
            (:line, 291, :none),
            :Any
          ))
      )),
    (:line, 294, :none),
    (:(=), (:call, (:curly, :_array_for, :T), (:(::), (:curly, :Type, :T)), :itr, (:(::), :HasLength)), (:block,
        (:line, 294, :none),
        (:call, (:curly, :Array, :T, 1), (:call, :Int, (:(::), (:call, :length, :itr), :Integer)))
      )),
    (:line, 295, :none),
    (:(=), (:call, (:curly, :_array_for, :T), (:(::), (:curly, :Type, :T)), :itr, (:(::), :HasShape)), (:block,
        (:line, 295, :none),
        (:call, :similar, (:curly, :Array, :T), (:call, :indices, :itr))
      )),
    (:line, 297, :none),
    (:function, (:call, :collect, (:(::), :itr, :Generator)), (:block,
        (:line, 298, :none),
        (:(=), :isz, (:call, :iteratorsize, (:., :itr, (:quote, #QuoteNode
                :iter
              )))),
        (:line, 299, :none),
        (:(=), :et, (:call, :_default_eltype, (:call, :typeof, :itr))),
        (:line, 300, :none),
        (:if, (:call, :isa, :isz, :SizeUnknown), (:block,
            (:line, 301, :none),
            (:return, (:call, :grow_to!, (:call, (:curly, :Array, :et, 1), 0), :itr))
          ), (:block,
            (:line, 303, :none),
            (:(=), :st, (:call, :start, :itr)),
            (:line, 304, :none),
            (:if, (:call, :done, :itr, :st), (:block,
                (:line, 305, :none),
                (:return, (:call, :_array_for, :et, (:., :itr, (:quote, #QuoteNode
                        :iter
                      )), :isz))
              )),
            (:line, 307, :none),
            (:(=), (:tuple, :v1, :st), (:call, :next, :itr, :st)),
            (:line, 308, :none),
            (:call, :collect_to_with_first!, (:call, :_array_for, (:call, :typeof, :v1), (:., :itr, (:quote, #QuoteNode
                    :iter
                  )), :isz), :v1, :itr, :st)
          ))
      )),
    (:line, 312, :none),
    (:(=), (:call, :_collect, :c, :itr, (:(::), :EltypeUnknown), (:(::), :isz, :SizeUnknown)), (:block,
        (:line, 312, :none),
        (:call, :grow_to!, (:call, :_similar_for, :c, (:call, :_default_eltype, (:call, :typeof, :itr)), :itr, :isz), :itr)
      )),
    (:line, 315, :none),
    (:function, (:call, :_collect, :c, :itr, (:(::), :EltypeUnknown), (:(::), :isz, (:curly, :Union, :HasLength, :HasShape))), (:block,
        (:line, 316, :none),
        (:(=), :st, (:call, :start, :itr)),
        (:line, 317, :none),
        (:if, (:call, :done, :itr, :st), (:block,
            (:line, 318, :none),
            (:return, (:call, :_similar_for, :c, (:call, :_default_eltype, (:call, :typeof, :itr)), :itr, :isz))
          )),
        (:line, 320, :none),
        (:(=), (:tuple, :v1, :st), (:call, :next, :itr, :st)),
        (:line, 321, :none),
        (:call, :collect_to_with_first!, (:call, :_similar_for, :c, (:call, :typeof, :v1), :itr, :isz), :v1, :itr, :st)
      )),
    (:line, 324, :none),
    (:function, (:call, :collect_to_with_first!, (:(::), :dest, :AbstractArray), :v1, :itr, :st), (:block,
        (:line, 325, :none),
        (:(=), :i1, (:call, :first, (:call, :linearindices, :dest))),
        (:line, 326, :none),
        (:(=), (:ref, :dest, :i1), :v1),
        (:line, 327, :none),
        (:return, (:call, :collect_to!, :dest, :itr, (:call, :+, :i1, 1), :st))
      )),
    (:line, 330, :none),
    (:function, (:call, :collect_to_with_first!, :dest, :v1, :itr, :st), (:block,
        (:line, 331, :none),
        (:call, :push!, :dest, :v1),
        (:line, 332, :none),
        (:return, (:call, :grow_to!, :dest, :itr, :st))
      )),
    (:line, 335, :none),
    (:function, (:call, (:curly, :collect_to!, :T), (:(::), :dest, (:curly, :AbstractArray, :T)), :itr, :offs, :st), (:block,
        (:line, 338, :none),
        (:(=), :i, :offs),
        (:line, 339, :none),
        (:while, (:call, :!, (:call, :done, :itr, :st)), (:block,
            (:line, 340, :none),
            (:(=), (:tuple, :el, :st), (:call, :next, :itr, :st)),
            (:line, 341, :none),
            (:(=), :S, (:call, :typeof, :el)),
            (:line, 342, :none),
            (:if, (:||, (:call, :(===), :S, :T), (:<:, :S, :T)), (:block,
                (:line, 343, :none),
                (:macrocall, Symbol("@inbounds"), (:(=), (:ref, :dest, :i), (:(::), :el, :T))),
                (:line, 344, :none),
                (:+=, :i, 1)
              ), (:block,
                (:line, 346, :none),
                (:(=), :R, (:call, :typejoin, :T, :S)),
                (:line, 347, :none),
                (:(=), :new, (:call, :similar, :dest, :R)),
                (:line, 348, :none),
                (:call, :copy!, :new, 1, :dest, 1, (:call, :-, :i, 1)),
                (:line, 349, :none),
                (:macrocall, Symbol("@inbounds"), (:(=), (:ref, :new, :i), :el)),
                (:line, 350, :none),
                (:return, (:call, :collect_to!, :new, :itr, (:call, :+, :i, 1), :st))
              ))
          )),
        (:line, 353, :none),
        (:return, :dest)
      )),
    (:line, 356, :none),
    (:function, (:call, :grow_to!, :dest, :itr), (:block,
        (:line, 357, :none),
        (:(=), :out, (:call, :grow_to!, (:call, :similar, :dest, (:curly, :Union)), :itr, (:call, :start, :itr))),
        (:line, 358, :none),
        (:return, (:if, (:call, :isempty, :out), :dest, :out))
      )),
    (:line, 361, :none),
    (:function, (:call, :grow_to!, :dest, :itr, :st), (:block,
        (:line, 362, :none),
        (:(=), :T, (:call, :eltype, :dest)),
        (:line, 363, :none),
        (:while, (:call, :!, (:call, :done, :itr, :st)), (:block,
            (:line, 364, :none),
            (:(=), (:tuple, :el, :st), (:call, :next, :itr, :st)),
            (:line, 365, :none),
            (:(=), :S, (:call, :typeof, :el)),
            (:line, 366, :none),
            (:if, (:||, (:call, :(===), :S, :T), (:<:, :S, :T)), (:block,
                (:line, 367, :none),
                (:call, :push!, :dest, (:(::), :el, :T))
              ), (:block,
                (:line, 369, :none),
                (:(=), :new, (:call, :similar, :dest, (:call, :typejoin, :T, :S))),
                (:line, 370, :none),
                (:call, :copy!, :new, :dest),
                (:line, 371, :none),
                (:call, :push!, :new, :el),
                (:line, 372, :none),
                (:return, (:call, :grow_to!, :new, :itr, :st))
              ))
          )),
        (:line, 375, :none),
        (:return, :dest)
      )),
    (:line, 379, :none),
    (:(=), (:call, :start, (:(::), :A, :Array)), (:block,
        (:line, 379, :none),
        1
      )),
    (:line, 380, :none),
    (:(=), (:call, :next, (:(::), :a, :Array), :i), (:block,
        (:line, 380, :none),
        (:block,
          (:macrocall, Symbol("@_propagate_inbounds_meta")),
          (:tuple, (:ref, :a, :i), (:call, :+, :i, 1))
        )
      )),
    (:line, 381, :none),
    (:(=), (:call, :done, (:(::), :a, :Array), :i), (:block,
        (:line, 381, :none),
        (:block,
          (:macrocall, Symbol("@_inline_meta")),
          (:call, :(==), :i, (:call, :+, (:call, :length, :a), 1))
        )
      )),
    (:line, 386, :none),
    (:(=), (:call, :getindex, (:(::), :A, :Array), (:(::), :i1, :Real)), (:block,
        (:line, 386, :none),
        (:call, :arrayref, :A, (:call, :to_index, :i1))
      )),
    (:line, 387, :none),
    (:(=), (:call, :getindex, (:(::), :A, :Array), (:(::), :i1, :Real), (:(::), :i2, :Real), (:..., (:(::), :I, :Real))), (:block,
        (:line, 387, :none),
        (:block,
          (:macrocall, Symbol("@_inline_meta")),
          (:call, :arrayref, :A, (:call, :to_index, :i1), (:call, :to_index, :i2), (:..., (:call, :to_indexes, (:..., :I))))
        )
      )),
    (:line, 390, :none),
    (:function, (:call, :getindex, (:(::), :A, :Array), (:(::), :I, (:curly, :UnitRange, :Int))), (:block,
        (:line, 391, :none),
        (:macrocall, Symbol("@_inline_meta")),
        (:line, 392, :none),
        (:macrocall, Symbol("@boundscheck"), (:call, :checkbounds, :A, :I)),
        (:line, 393, :none),
        (:(=), :lI, (:call, :length, :I)),
        (:line, 394, :none),
        (:(=), :X, (:call, :similar, :A, :lI)),
        (:line, 395, :none),
        (:if, (:call, :>, :lI, 0), (:block,
            (:line, 396, :none),
            (:call, :unsafe_copy!, :X, 1, :A, (:call, :first, :I), :lI)
          )),
        (:line, 398, :none),
        (:return, :X)
      )),
    (:line, 400, :none),
    (:function, (:call, :getindex, (:(::), :A, :Array), (:(::), :c, :Colon)), (:block,
        (:line, 401, :none),
        (:(=), :lI, (:call, :length, :A)),
        (:line, 402, :none),
        (:(=), :X, (:call, :similar, :A, :lI)),
        (:line, 403, :none),
        (:if, (:call, :>, :lI, 0), (:block,
            (:line, 404, :none),
            (:call, :unsafe_copy!, :X, 1, :A, 1, :lI)
          )),
        (:line, 406, :none),
        (:return, :X)
      )),
    (:line, 410, :none),
    (:function, (:call, (:curly, :getindex, :S, (:<:, :T, :Real)), (:(::), :A, (:curly, :Array, :S)), (:(::), :I, (:curly, :Range, :T))), (:block,
        (:line, 411, :none),
        (:return, (:typed_comprehension, :S, (:generator, (:ref, :A, (:call, :to_index, :i)), (:(=), :i, :I))))
      )),
    (:line, 415, :none),
    (:(=), (:call, (:curly, :setindex!, :T), (:(::), :A, (:curly, :Array, :T)), :x, (:(::), :i1, :Real)), (:block,
        (:line, 415, :none),
        (:call, :arrayset, :A, (:(::), (:call, :convert, :T, :x), :T), (:call, :to_index, :i1))
      )),
    (:line, 416, :none),
    (:(=), (:call, (:curly, :setindex!, :T), (:(::), :A, (:curly, :Array, :T)), :x, (:(::), :i1, :Real), (:(::), :i2, :Real), (:..., (:(::), :I, :Real))), (:block,
        (:line, 416, :none),
        (:block,
          (:macrocall, Symbol("@_inline_meta")),
          (:call, :arrayset, :A, (:(::), (:call, :convert, :T, :x), :T), (:call, :to_index, :i1), (:call, :to_index, :i2), (:..., (:call, :to_indexes, (:..., :I))))
        )
      )),
    (:line, 419, :none),
    (:function, (:call, :setindex!, (:(::), :A, :Array), :x, (:(::), :I, (:curly, :AbstractVector, :Int))), (:block,
        (:line, 420, :none),
        (:&&, (:call, :is, :A, :I), (:(=), :I, (:call, :copy, :I))),
        (:line, 421, :none),
        (:for, (:(=), :i, :I), (:block,
            (:line, 422, :none),
            (:(=), (:ref, :A, :i), :x)
          )),
        (:line, 424, :none),
        (:return, :A)
      )),
    (:line, 426, :none),
    (:function, (:call, :setindex!, (:(::), :A, :Array), (:(::), :X, :AbstractArray), (:(::), :I, (:curly, :AbstractVector, :Int))), (:block,
        (:line, 427, :none),
        (:call, :setindex_shape_check, :X, (:call, :length, :I)),
        (:line, 428, :none),
        (:(=), :count, 1),
        (:line, 429, :none),
        (:if, (:call, :is, :X, :A), (:block,
            (:line, 430, :none),
            (:(=), :X, (:call, :copy, :X)),
            (:line, 431, :none),
            (:&&, (:call, :is, :I, :A), (:(=), :I, (:(::), :X, (:call, :typeof, :I))))
          ), (:block,
            (:line, 432, :none),
            (:if, (:call, :is, :I, :A), (:block,
                (:line, 433, :none),
                (:(=), :I, (:call, :copy, :I))
              ))
          )),
        (:line, 435, :none),
        (:for, (:(=), :i, :I), (:block,
            (:line, 436, :none),
            (:(=), (:ref, :A, :i), (:ref, :X, :count)),
            (:line, 437, :none),
            (:+=, :count, 1)
          )),
        (:line, 439, :none),
        (:return, :A)
      )),
    (:line, 443, :none),
    (:function, (:call, (:curly, :setindex!, :T), (:(::), :A, (:curly, :Array, :T)), (:(::), :X, (:curly, :Array, :T)), (:(::), :I, (:curly, :UnitRange, :Int))), (:block,
        (:line, 444, :none),
        (:macrocall, Symbol("@_inline_meta")),
        (:line, 445, :none),
        (:macrocall, Symbol("@boundscheck"), (:call, :checkbounds, :A, :I)),
        (:line, 446, :none),
        (:(=), :lI, (:call, :length, :I)),
        (:line, 447, :none),
        (:call, :setindex_shape_check, :X, :lI),
        (:line, 448, :none),
        (:if, (:call, :>, :lI, 0), (:block,
            (:line, 449, :none),
            (:call, :unsafe_copy!, :A, (:call, :first, :I), :X, 1, :lI)
          )),
        (:line, 451, :none),
        (:return, :A)
      )),
    (:line, 453, :none),
    (:function, (:call, (:curly, :setindex!, :T), (:(::), :A, (:curly, :Array, :T)), (:(::), :X, (:curly, :Array, :T)), (:(::), :c, :Colon)), (:block,
        (:line, 454, :none),
        (:(=), :lI, (:call, :length, :A)),
        (:line, 455, :none),
        (:call, :setindex_shape_check, :X, :lI),
        (:line, 456, :none),
        (:if, (:call, :>, :lI, 0), (:block,
            (:line, 457, :none),
            (:call, :unsafe_copy!, :A, 1, :X, 1, :lI)
          )),
        (:line, 459, :none),
        (:return, :A)
      )),
    (:line, 462, :none),
    (:(=), (:call, :setindex!, (:(::), :A, :Array), (:(::), :x, :Number), (:(::), :Colon)), (:block,
        (:line, 462, :none),
        (:call, :fill!, :A, :x)
      )),
    (:line, 463, :none),
    (:(=), (:call, (:curly, :setindex!, :T, :N), (:(::), :A, (:curly, :Array, :T, :N)), (:(::), :x, :Number), (:(::), (:curly, :Vararg, :Colon, :N))), (:block,
        (:line, 463, :none),
        (:call, :fill!, :A, :x)
      )),
    (:line, 467, :none),
    (:(=), (:call, :_growat!, (:(::), :a, :Vector), (:(::), :i, :Integer), (:(::), :delta, :Integer)), (:block,
        (:line, 467, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_grow_at
          ), :Void, (:tuple, :Any, :Int, :UInt), :a, (:call, :-, :i, 1), :delta)
      )),
    (:line, 472, :none),
    (:(=), (:call, :_deleteat!, (:(::), :a, :Vector), (:(::), :i, :Integer), (:(::), :delta, :Integer)), (:block,
        (:line, 472, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_del_at
          ), :Void, (:tuple, :Any, :Int, :UInt), :a, (:call, :-, :i, 1), :delta)
      )),
    (:line, 477, :none),
    (:function, (:call, (:curly, :push!, :T), (:(::), :a, (:curly, :Array, :T, 1)), :item), (:block,
        (:line, 479, :none),
        (:(=), :itemT, (:call, :convert, :T, :item)),
        (:line, 480, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_grow_end
          ), :Void, (:tuple, :Any, :UInt), :a, 1),
        (:line, 481, :none),
        (:(=), (:ref, :a, :end), :itemT),
        (:line, 482, :none),
        (:return, :a)
      )),
    (:line, 485, :none),
    (:function, (:call, :push!, (:(::), :a, (:curly, :Array, :Any, 1)), (:(::), :item, :ANY)), (:block,
        (:line, 486, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_grow_end
          ), :Void, (:tuple, :Any, :UInt), :a, 1),
        (:line, 487, :none),
        (:call, :arrayset, :a, :item, (:call, :length, :a)),
        (:line, 488, :none),
        (:return, :a)
      )),
    (:line, 491, :none),
    (:function, (:call, (:curly, :append!, :T), (:(::), :a, (:curly, :Array, :T, 1)), (:(::), :items, :AbstractVector)), (:block,
        (:line, 492, :none),
        (:(=), :n, (:call, :length, :items)),
        (:line, 493, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_grow_end
          ), :Void, (:tuple, :Any, :UInt), :a, :n),
        (:line, 494, :none),
        (:call, :copy!, :a, (:call, :+, (:call, :-, (:call, :length, :a), :n), 1), :items, 1, :n),
        (:line, 495, :none),
        (:return, :a)
      )),
    (:line, 498, :none),
    (:function, (:call, (:curly, :prepend!, :T), (:(::), :a, (:curly, :Array, :T, 1)), (:(::), :items, :AbstractVector)), (:block,
        (:line, 499, :none),
        (:(=), :n, (:call, :length, :items)),
        (:line, 500, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_grow_beg
          ), :Void, (:tuple, :Any, :UInt), :a, :n),
        (:line, 501, :none),
        (:if, (:call, :(===), :a, :items), (:block,
            (:line, 502, :none),
            (:call, :copy!, :a, 1, :items, (:call, :+, :n, 1), :n)
          ), (:block,
            (:line, 504, :none),
            (:call, :copy!, :a, 1, :items, 1, :n)
          )),
        (:line, 506, :none),
        (:return, :a)
      )),
    (:line, 509, :none),
    (:function, (:call, :resize!, (:(::), :a, :Vector), (:(::), :nl, :Integer)), (:block,
        (:line, 510, :none),
        (:(=), :l, (:call, :length, :a)),
        (:line, 511, :none),
        (:if, (:call, :>, :nl, :l), (:block,
            (:line, 512, :none),
            (:ccall, (:quote, #QuoteNode
                :jl_array_grow_end
              ), :Void, (:tuple, :Any, :UInt), :a, (:call, :-, :nl, :l))
          ), (:block,
            (:line, 514, :none),
            (:if, (:call, :<, :nl, 0), (:block,
                (:line, 515, :none),
                (:call, :throw, (:call, :ArgumentError, "new length must be ≥ 0"))
              )),
            (:line, 517, :none),
            (:ccall, (:quote, #QuoteNode
                :jl_array_del_end
              ), :Void, (:tuple, :Any, :UInt), :a, (:call, :-, :l, :nl))
          )),
        (:line, 519, :none),
        (:return, :a)
      )),
    (:line, 522, :none),
    (:function, (:call, :sizehint!, (:(::), :a, :Vector), (:(::), :sz, :Integer)), (:block,
        (:line, 523, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_sizehint
          ), :Void, (:tuple, :Any, :UInt), :a, :sz),
        (:line, 524, :none),
        :a
      )),
    (:line, 527, :none),
    (:function, (:call, :pop!, (:(::), :a, :Vector)), (:block,
        (:line, 528, :none),
        (:if, (:call, :isempty, :a), (:block,
            (:line, 529, :none),
            (:call, :throw, (:call, :ArgumentError, "array must be non-empty"))
          )),
        (:line, 531, :none),
        (:(=), :item, (:ref, :a, :end)),
        (:line, 532, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_del_end
          ), :Void, (:tuple, :Any, :UInt), :a, 1),
        (:line, 533, :none),
        (:return, :item)
      )),
    (:line, 536, :none),
    (:function, (:call, (:curly, :unshift!, :T), (:(::), :a, (:curly, :Array, :T, 1)), :item), (:block,
        (:line, 537, :none),
        (:(=), :item, (:call, :convert, :T, :item)),
        (:line, 538, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_grow_beg
          ), :Void, (:tuple, :Any, :UInt), :a, 1),
        (:line, 539, :none),
        (:(=), (:ref, :a, 1), :item),
        (:line, 540, :none),
        (:return, :a)
      )),
    (:line, 543, :none),
    (:function, (:call, :shift!, (:(::), :a, :Vector)), (:block,
        (:line, 544, :none),
        (:if, (:call, :isempty, :a), (:block,
            (:line, 545, :none),
            (:call, :throw, (:call, :ArgumentError, "array must be non-empty"))
          )),
        (:line, 547, :none),
        (:(=), :item, (:ref, :a, 1)),
        (:line, 548, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_del_beg
          ), :Void, (:tuple, :Any, :UInt), :a, 1),
        (:line, 549, :none),
        (:return, :item)
      )),
    (:line, 552, :none),
    (:function, (:call, (:curly, :insert!, :T), (:(::), :a, (:curly, :Array, :T, 1)), (:(::), :i, :Integer), :item), (:block,
        (:line, 554, :none),
        (:(=), :_item, (:call, :convert, :T, :item)),
        (:line, 555, :none),
        (:call, :_growat!, :a, :i, 1),
        (:line, 557, :none),
        (:macrocall, Symbol("@inbounds"), (:(=), (:ref, :a, :i), :_item)),
        (:line, 558, :none),
        (:return, :a)
      )),
    (:line, 561, :none),
    "    deleteat!(a::Vector, i::Integer)\n\nRemove the item at the given `i` and return the modified `a`. Subsequent items\nare shifted to fill the resulting gap.\n\n```jldoctest\njulia> deleteat!([6, 5, 4, 3, 2, 1], 2)\n5-element Array{Int64,1}:\n 6\n 4\n 3\n 2\n 1\n```\n",
    (:line, 577, :none),
    (:(=), (:call, :deleteat!, (:(::), :a, :Vector), (:(::), :i, :Integer)), (:block,
        (:line, 577, :none),
        (:block,
          (:call, :_deleteat!, :a, :i, 1),
          :a
        )
      )),
    (:line, 579, :none),
    (:function, (:call, (:curly, :deleteat!, (:<:, :T, :Integer)), (:(::), :a, :Vector), (:(::), :r, (:curly, :UnitRange, :T))), (:block,
        (:line, 580, :none),
        (:(=), :n, (:call, :length, :a)),
        (:line, 581, :none),
        (:||, (:call, :isempty, :r), (:call, :_deleteat!, :a, (:call, :first, :r), (:call, :length, :r))),
        (:line, 582, :none),
        (:return, :a)
      )),
    (:line, 585, :none),
    "    deleteat!(a::Vector, inds)\n\nRemove the items at the indices given by `inds`, and return the modified `a`.\nSubsequent items are shifted to fill the resulting gap. `inds` must be sorted and unique.\n\n```jldoctest\njulia> deleteat!([6, 5, 4, 3, 2, 1], 1:2:5)\n3-element Array{Int64,1}:\n 5\n 3\n 1\n\njulia> deleteat!([6, 5, 4, 3, 2, 1], (2, 2))\nERROR: ArgumentError: indices must be unique and sorted\n in deleteat!(::Array{Int64,1}, ::Tuple{Int64,Int64}) at ./array.jl:614\n ...\n```\n",
    (:line, 604, :none),
    (:function, (:call, :deleteat!, (:(::), :a, :Vector), :inds), (:block,
        (:line, 605, :none),
        (:(=), :n, (:call, :length, :a)),
        (:line, 606, :none),
        (:(=), :s, (:call, :start, :inds)),
        (:line, 607, :none),
        (:&&, (:call, :done, :inds, :s), (:return, :a)),
        (:line, 608, :none),
        (:(=), (:tuple, :p, :s), (:call, :next, :inds, :s)),
        (:line, 609, :none),
        (:(=), :q, (:call, :+, :p, 1)),
        (:line, 610, :none),
        (:while, (:call, :!, (:call, :done, :inds, :s)), (:block,
            (:line, 611, :none),
            (:(=), (:tuple, :i, :s), (:call, :next, :inds, :s)),
            (:line, 612, :none),
            (:if, (:call, :!, (:comparison, :q, :(<=), :i, :(<=), :n)), (:block,
                (:line, 613, :none),
                (:if, (:call, :<, :i, :q), (:block,
                    (:line, 614, :none),
                    (:call, :throw, (:call, :ArgumentError, "indices must be unique and sorted"))
                  ), (:block,
                    (:line, 616, :none),
                    (:call, :throw, (:call, :BoundsError))
                  ))
              )),
            (:line, 619, :none),
            (:while, (:call, :<, :q, :i), (:block,
                (:line, 620, :none),
                (:macrocall, Symbol("@inbounds"), (:(=), (:ref, :a, :p), (:ref, :a, :q))),
                (:line, 621, :none),
                (:+=, :p, 1),
                (:line, 621, :none),
                (:+=, :q, 1)
              )),
            (:line, 623, :none),
            (:(=), :q, (:call, :+, :i, 1))
          )),
        (:line, 625, :none),
        (:while, (:call, :(<=), :q, :n), (:block,
            (:line, 626, :none),
            (:macrocall, Symbol("@inbounds"), (:(=), (:ref, :a, :p), (:ref, :a, :q))),
            (:line, 627, :none),
            (:+=, :p, 1),
            (:line, 627, :none),
            (:+=, :q, 1)
          )),
        (:line, 629, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_del_end
          ), :Void, (:tuple, :Any, :UInt), :a, (:call, :+, (:call, :-, :n, :p), 1)),
        (:line, 630, :none),
        (:return, :a)
      )),
    (:line, 633, :none),
    (:const, (:(=), :_default_splice, (:vect,))),
    (:line, 635, :none),
    (:function, (:call, :splice!, (:(::), :a, :Vector), (:(::), :i, :Integer), (:kw, :ins, :_default_splice)), (:block,
        (:line, 636, :none),
        (:(=), :v, (:ref, :a, :i)),
        (:line, 637, :none),
        (:(=), :m, (:call, :length, :ins)),
        (:line, 638, :none),
        (:if, (:call, :(==), :m, 0), (:block,
            (:line, 639, :none),
            (:call, :_deleteat!, :a, :i, 1)
          ), (:block,
            (:line, 640, :none),
            (:if, (:call, :(==), :m, 1), (:block,
                (:line, 641, :none),
                (:(=), (:ref, :a, :i), (:ref, :ins, 1))
              ), (:block,
                (:line, 643, :none),
                (:call, :_growat!, :a, :i, (:call, :-, :m, 1)),
                (:line, 644, :none),
                (:(=), :k, 1),
                (:line, 645, :none),
                (:for, (:(=), :x, :ins), (:block,
                    (:line, 646, :none),
                    (:(=), (:ref, :a, (:call, :-, (:call, :+, :i, :k), 1)), :x),
                    (:line, 647, :none),
                    (:+=, :k, 1)
                  ))
              ))
          )),
        (:line, 650, :none),
        (:return, :v)
      )),
    (:line, 653, :none),
    (:function, (:call, (:curly, :splice!, (:<:, :T, :Integer)), (:(::), :a, :Vector), (:(::), :r, (:curly, :UnitRange, :T)), (:kw, :ins, :_default_splice)), (:block,
        (:line, 654, :none),
        (:(=), :v, (:ref, :a, :r)),
        (:line, 655, :none),
        (:(=), :m, (:call, :length, :ins)),
        (:line, 656, :none),
        (:if, (:call, :(==), :m, 0), (:block,
            (:line, 657, :none),
            (:call, :deleteat!, :a, :r),
            (:line, 658, :none),
            (:return, :v)
          )),
        (:line, 661, :none),
        (:(=), :n, (:call, :length, :a)),
        (:line, 662, :none),
        (:(=), :f, (:call, :first, :r)),
        (:line, 663, :none),
        (:(=), :l, (:call, :last, :r)),
        (:line, 664, :none),
        (:(=), :d, (:call, :length, :r)),
        (:line, 666, :none),
        (:if, (:call, :<, :m, :d), (:block,
            (:line, 667, :none),
            (:(=), :delta, (:call, :-, :d, :m)),
            (:line, 668, :none),
            (:call, :_deleteat!, :a, (:if, (:call, :<, (:call, :-, :f, 1), (:call, :-, :n, :l)), :f, (:call, :+, (:call, :-, :l, :delta), 1)), :delta)
          ), (:block,
            (:line, 669, :none),
            (:if, (:call, :>, :m, :d), (:block,
                (:line, 670, :none),
                (:call, :_growat!, :a, (:if, (:call, :<, (:call, :-, :f, 1), (:call, :-, :n, :l)), :f, (:call, :+, :l, 1)), (:call, :-, :m, :d))
              ))
          )),
        (:line, 673, :none),
        (:(=), :k, 1),
        (:line, 674, :none),
        (:for, (:(=), :x, :ins), (:block,
            (:line, 675, :none),
            (:(=), (:ref, :a, (:call, :-, (:call, :+, :f, :k), 1)), :x),
            (:line, 676, :none),
            (:+=, :k, 1)
          )),
        (:line, 678, :none),
        (:return, :v)
      )),
    (:line, 681, :none),
    (:function, (:call, :empty!, (:(::), :a, :Vector)), (:block,
        (:line, 682, :none),
        (:ccall, (:quote, #QuoteNode
            :jl_array_del_end
          ), :Void, (:tuple, :Any, :UInt), :a, (:call, :length, :a)),
        (:line, 683, :none),
        (:return, :a)
      )),
    (:line, 687, :none),
    (:function, (:call, :lexcmp, (:(::), :a, (:curly, :Array, :UInt8, 1)), (:(::), :b, (:curly, :Array, :UInt8, 1))), (:block,
        (:line, 688, :none),
        (:(=), :c, (:ccall, (:quote, #QuoteNode
              :memcmp
            ), :Int32, (:tuple, (:curly, :Ptr, :UInt8), (:curly, :Ptr, :UInt8), :UInt), :a, :b, (:call, :min, (:call, :length, :a), (:call, :length, :b)))),
        (:line, 690, :none),
        (:return, (:if, (:call, :<, :c, 0), -1, (:if, (:call, :>, :c, 0), 1, (:call, :cmp, (:call, :length, :a), (:call, :length, :b)))))
      )),
    (:line, 693, :none),
    (:function, (:call, :reverse, (:(::), :A, :AbstractVector), (:kw, :s, 1), (:kw, :n, (:call, :length, :A))), (:block,
        (:line, 694, :none),
        (:(=), :B, (:call, :similar, :A)),
        (:line, 695, :none),
        (:for, (:(=), :i, (:(:), 1, (:call, :-, :s, 1))), (:block,
            (:line, 696, :none),
            (:(=), (:ref, :B, :i), (:ref, :A, :i))
          )),
        (:line, 698, :none),
        (:for, (:(=), :i, (:(:), :s, :n)), (:block,
            (:line, 699, :none),
            (:(=), (:ref, :B, :i), (:ref, :A, (:call, :-, (:call, :+, :n, :s), :i)))
          )),
        (:line, 701, :none),
        (:for, (:(=), :i, (:(:), (:call, :+, :n, 1), (:call, :length, :A))), (:block,
            (:line, 702, :none),
            (:(=), (:ref, :B, :i), (:ref, :A, :i))
          )),
        (:line, 704, :none),
        (:return, :B)
      )),
    (:line, 706, :none),
    (:(=), (:call, :reverseind, (:(::), :a, :AbstractVector), (:(::), :i, :Integer)), (:block,
        (:line, 706, :none),
        (:call, :-, (:call, :+, (:call, :length, :a), 1), :i)
      )),
    (:line, 708, :none),
    (:function, (:call, :reverse!, (:(::), :v, :AbstractVector), (:kw, :s, 1), (:kw, :n, (:call, :length, :v))), (:block,
        (:line, 709, :none),
        (:if, (:call, :(<=), :n, :s), (:block,), (:block,
            (:line, 710, :none),
            (:if, (:call, :!, (:comparison, 1, :≤, :s, :≤, (:call, :endof, :v))), (:block,
                (:line, 711, :none),
                (:call, :throw, (:call, :BoundsError, :v, :s))
              ), (:block,
                (:line, 712, :none),
                (:if, (:call, :!, (:comparison, 1, :≤, :n, :≤, (:call, :endof, :v))), (:block,
                    (:line, 713, :none),
                    (:call, :throw, (:call, :BoundsError, :v, :n))
                  ))
              ))
          )),
        (:line, 715, :none),
        (:(=), :r, :n),
        (:line, 716, :none),
        (:macrocall, Symbol("@inbounds"), (:for, (:(=), :i, (:(:), :s, (:call, :div, (:call, :-, (:call, :+, :s, :n), 1), 2))), (:block,
              (:line, 717, :none),
              (:(=), (:tuple, (:ref, :v, :i), (:ref, :v, :r)), (:tuple, (:ref, :v, :r), (:ref, :v, :i))),
              (:line, 718, :none),
              (:-=, :r, 1)
            ))),
        (:line, 720, :none),
        (:return, :v)
      )),
    (:line, 725, :none),
    (:(=), (:call, (:curly, :vcat, :T), (:..., (:(::), :A, (:curly, :Union, (:curly, :Vector, :T), (:curly, :Matrix, :T))))), (:block,
        (:line, 725, :none),
        (:call, :typed_vcat, :T, (:..., :A))
      )),
    (:line, 726, :none),
    (:(=), (:call, :vcat, (:..., (:(::), :A, (:curly, :Union, :Vector, :Matrix)))), (:block,
        (:line, 726, :none),
        (:call, :typed_vcat, (:call, :promote_eltype, (:..., :A)), (:..., :A))
      )),
    (:line, 727, :none),
    (:(=), (:call, (:curly, :hcat, :T), (:..., (:(::), :A, (:curly, :Union, (:curly, :Vector, :T), (:curly, :Matrix, :T))))), (:block,
        (:line, 727, :none),
        (:call, :typed_hcat, :T, (:..., :A))
      )),
    (:line, 728, :none),
    (:(=), (:call, :hcat, (:..., (:(::), :A, (:curly, :Union, :Vector, :Matrix)))), (:block,
        (:line, 728, :none),
        (:call, :typed_hcat, (:call, :promote_eltype, (:..., :A)), (:..., :A))
      )),
    (:line, 729, :none),
    (:(=), (:call, (:curly, :hvcat, :T), (:(::), :rows, (:curly, :Tuple, (:curly, :Vararg, :Int))), (:..., (:(::), :xs, (:curly, :Union, (:curly, :Vector, :T), (:curly, :Matrix, :T))))), (:block,
        (:line, 729, :none),
        (:call, :typed_hvcat, :T, :rows, (:..., :xs))
      )),
    (:line, 730, :none),
    (:(=), (:call, :hvcat, (:(::), :rows, (:curly, :Tuple, (:curly, :Vararg, :Int))), (:..., (:(::), :xs, (:curly, :Union, :Vector, :Matrix)))), (:block,
        (:line, 730, :none),
        (:call, :typed_hvcat, (:call, :promote_eltype, (:..., :xs)), :rows, (:..., :xs))
      )),
    (:line, 731, :none),
    (:(=), (:call, (:curly, :cat, :T), :catdims, (:..., (:(::), :xs, (:curly, :Union, (:curly, :Vector, :T), (:curly, :Matrix, :T))))), (:block,
        (:line, 731, :none),
        (:call, (:., :Base, (:quote, #QuoteNode
              :cat_t
            )), :catdims, :T, (:..., :xs))
      )),
    (:line, 732, :none),
    (:(=), (:call, :cat, :catdims, (:..., (:(::), :xs, (:curly, :Union, :Vector, :Matrix)))), (:block,
        (:line, 732, :none),
        (:call, (:., :Base, (:quote, #QuoteNode
              :cat_t
            )), :catdims, (:call, :promote_eltype, (:..., :xs)), (:..., :xs))
      )),
    (:line, 734, :none),
    (:function, (:call, (:curly, :hcat, :T), (:..., (:(::), :V, (:curly, :Vector, :T)))), (:block,
        (:line, 735, :none),
        (:(=), :height, (:call, :length, (:ref, :V, 1))),
        (:line, 736, :none),
        (:for, (:(=), :j, (:(:), 2, (:call, :length, :V))), (:block,
            (:line, 737, :none),
            (:if, (:call, :(!=), (:call, :length, (:ref, :V, :j)), :height), (:block,
                (:line, 738, :none),
                (:call, :throw, (:call, :DimensionMismatch, "vectors must have same lengths"))
              ))
          )),
        (:line, 741, :none),
        (:return, (:comprehension, (:generator, (:(::), (:ref, (:ref, :V, :j), :i), :T), (:(=), :i, (:(:), 1, (:call, :length, (:ref, :V, 1)))), (:(=), :j, (:(:), 1, (:call, :length, :V))))))
      )),
    (:line, 744, :none),
    (:function, (:call, (:curly, :vcat, :T), (:..., (:(::), :arrays, (:curly, :Vector, :T)))), (:block,
        (:line, 745, :none),
        (:(=), :n, 0),
        (:line, 746, :none),
        (:for, (:(=), :a, :arrays), (:block,
            (:line, 747, :none),
            (:+=, :n, (:call, :length, :a))
          )),
        (:line, 749, :none),
        (:(=), :arr, (:call, (:curly, :Array, :T, 1), :n)),
        (:line, 750, :none),
        (:(=), :ptr, (:call, :pointer, :arr)),
        (:line, 751, :none),
        (:if, (:call, :isbits, :T), (:block,
            (:line, 752, :none),
            (:(=), :elsz, (:call, (:., :Core, (:quote, #QuoteNode
                    :sizeof
                  )), :T))
          ), (:block,
            (:line, 754, :none),
            (:(=), :elsz, (:call, (:., :Core, (:quote, #QuoteNode
                    :sizeof
                  )), (:curly, :Ptr, :Void)))
          )),
        (:line, 756, :none),
        (:for, (:(=), :a, :arrays), (:block,
            (:line, 757, :none),
            (:(=), :na, (:call, :length, :a)),
            (:line, 758, :none),
            (:(=), :nba, (:call, :*, :na, :elsz)),
            (:line, 759, :none),
            (:if, (:call, :isbits, :T), (:block,
                (:line, 760, :none),
                (:ccall, (:quote, #QuoteNode
                    :memcpy
                  ), (:curly, :Ptr, :Void), (:tuple, (:curly, :Ptr, :Void), (:curly, :Ptr, :Void), :UInt), :ptr, :a, :nba)
              ), (:block,
                (:line, 763, :none),
                (:ccall, (:quote, #QuoteNode
                    :jl_array_ptr_copy
                  ), :Void, (:tuple, :Any, (:curly, :Ptr, :Void), :Any, (:curly, :Ptr, :Void), :Int), :arr, :ptr, :a, (:call, :pointer, :a), :na)
              )),
            (:line, 766, :none),
            (:+=, :ptr, :nba)
          )),
        (:line, 768, :none),
        (:return, :arr)
      )),
    (:line, 774, :none),
    "    findnext(A, i::Integer)\n\nFind the next linear index >= `i` of a non-zero element of `A`, or `0` if not found.\n\n```jldoctest\njulia> A = [0 0; 1 0]\n2×2 Array{Int64,2}:\n 0  0\n 1  0\n\njulia> findnext(A,1)\n2\n\njulia> findnext(A,3)\n0\n```\n",
    (:line, 792, :none),
    (:function, (:call, :findnext, :A, (:(::), :start, :Integer)), (:block,
        (:line, 793, :none),
        (:for, (:(=), :i, (:(:), :start, (:call, :length, :A))), (:block,
            (:line, 794, :none),
            (:if, (:call, :(!=), (:ref, :A, :i), 0), (:block,
                (:line, 795, :none),
                (:return, :i)
              ))
          )),
        (:line, 798, :none),
        (:return, 0)
      )),
    (:line, 801, :none),
    "    findfirst(A)\n\nReturn the linear index of the first non-zero value in `A` (determined by `A[i]!=0`).\nReturns `0` if no such value is found.\n\n```jldoctest\njulia> A = [0 0; 1 0]\n2×2 Array{Int64,2}:\n 0  0\n 1  0\n\njulia> findfirst(A)\n2\n```\n",
    (:line, 817, :none),
    (:(=), (:call, :findfirst, :A), (:block,
        (:line, 817, :none),
        (:call, :findnext, :A, 1)
      )),
    (:line, 819, :none),
    "    findnext(A, v, i::Integer)\n\nFind the next linear index >= `i` of an element of `A` equal to `v` (using `==`), or `0` if not found.\n\n```jldoctest\njulia> A = [1 4; 2 2]\n2×2 Array{Int64,2}:\n 1  4\n 2  2\n\njulia> findnext(A,4,4)\n0\n\njulia> findnext(A,4,3)\n3\n```\n",
    (:line, 837, :none),
    (:function, (:call, :findnext, :A, :v, (:(::), :start, :Integer)), (:block,
        (:line, 838, :none),
        (:for, (:(=), :i, (:(:), :start, (:call, :length, :A))), (:block,
            (:line, 839, :none),
            (:if, (:call, :(==), (:ref, :A, :i), :v), (:block,
                (:line, 840, :none),
                (:return, :i)
              ))
          )),
        (:line, 843, :none),
        (:return, 0)
      )),
    (:line, 845, :none),
    "    findfirst(A, v)\n\nReturn the linear index of the first element equal to `v` in `A`.\nReturns `0` if `v` is not found.\n\n```jldoctest\njulia> A = [4 6; 2 2]\n2×2 Array{Int64,2}:\n 4  6\n 2  2\n\njulia> findfirst(A,2)\n2\n\njulia> findfirst(A,3)\n0\n```\n",
    (:line, 864, :none),
    (:(=), (:call, :findfirst, :A, :v), (:block,
        (:line, 864, :none),
        (:call, :findnext, :A, :v, 1)
      )),
    (:line, 866, :none),
    "    findnext(predicate::Function, A, i::Integer)\n\nFind the next linear index >= `i` of an element of `A` for which `predicate` returns `true`, or `0` if not found.\n\n```jldoctest\njulia> A = [1 4; 2 2]\n2×2 Array{Int64,2}:\n 1  4\n 2  2\n\njulia> findnext(isodd, A, 1)\n1\n\njulia> findnext(isodd, A, 2)\n0\n```\n",
    (:line, 884, :none),
    (:function, (:call, :findnext, (:(::), :testf, :Function), :A, (:(::), :start, :Integer)), (:block,
        (:line, 885, :none),
        (:for, (:(=), :i, (:(:), :start, (:call, :length, :A))), (:block,
            (:line, 886, :none),
            (:if, (:call, :testf, (:ref, :A, :i)), (:block,
                (:line, 887, :none),
                (:return, :i)
              ))
          )),
        (:line, 890, :none),
        (:return, 0)
      )),
    (:line, 893, :none),
    "    findfirst(predicate::Function, A)\n\nReturn the linear index of the first element of `A` for which `predicate` returns `true`.\nReturns `0` if there is no such element.\n\n```jldoctest\njulia> A = [1 4; 2 2]\n2×2 Array{Int64,2}:\n 1  4\n 2  2\n\njulia> findfirst(iseven, A)\n2\n\njulia> findfirst(x -> x>10, A)\n0\n```\n",
    (:line, 912, :none),
    (:(=), (:call, :findfirst, (:(::), :testf, :Function), :A), (:block,
        (:line, 912, :none),
        (:call, :findnext, :testf, :A, 1)
      )),
    (:line, 914, :none),
    "    findprev(A, i::Integer)\n\nFind the previous linear index <= `i` of a non-zero element of `A`, or `0` if not found.\n\n```jldoctest\njulia> A = [0 0; 1 2]\n2×2 Array{Int64,2}:\n 0  0\n 1  2\n\njulia> findprev(A,2)\n2\n\njulia> findprev(A,1)\n0\n```\n",
    (:line, 932, :none),
    (:function, (:call, :findprev, :A, (:(::), :start, :Integer)), (:block,
        (:line, 933, :none),
        (:for, (:(=), :i, (:(:), :start, -1, 1)), (:block,
            (:line, 934, :none),
            (:&&, (:call, :(!=), (:ref, :A, :i), 0), (:return, :i))
          )),
        (:line, 936, :none),
        (:return, 0)
      )),
    (:line, 939, :none),
    "    findlast(A)\n\nReturn the linear index of the last non-zero value in `A` (determined by `A[i]!=0`).\nReturns `0` if there is no non-zero value in `A`.\n\n```jldoctest\njulia> A = [1 0; 1 0]\n2×2 Array{Int64,2}:\n 1  0\n 1  0\n\njulia> findlast(A)\n2\n\njulia> A = zeros(2,2)\n2×2 Array{Float64,2}:\n 0.0  0.0\n 0.0  0.0\n\njulia> findlast(A)\n0\n```\n",
    (:line, 963, :none),
    (:(=), (:call, :findlast, :A), (:block,
        (:line, 963, :none),
        (:call, :findprev, :A, (:call, :length, :A))
      )),
    (:line, 965, :none),
    "    findprev(A, v, i::Integer)\n\nFind the previous linear index <= `i` of an element of `A` equal to `v` (using `==`), or `0` if not found.\n\n```jldoctest\njulia> A = [0 0; 1 2]\n2×2 Array{Int64,2}:\n 0  0\n 1  2\n\njulia> findprev(A, 1, 4)\n2\n\njulia> findprev(A, 1, 1)\n0\n```\n",
    (:line, 983, :none),
    (:function, (:call, :findprev, :A, :v, (:(::), :start, :Integer)), (:block,
        (:line, 984, :none),
        (:for, (:(=), :i, (:(:), :start, -1, 1)), (:block,
            (:line, 985, :none),
            (:&&, (:call, :(==), (:ref, :A, :i), :v), (:return, :i))
          )),
        (:line, 987, :none),
        (:return, 0)
      )),
    (:line, 990, :none),
    "    findlast(A, v)\n\nReturn the linear index of the last element equal to `v` in `A`.\nReturns `0` if there is no element of `A` equal to `v`.\n\n```jldoctest\njulia> A = [1 2; 2 1]\n2×2 Array{Int64,2}:\n 1  2\n 2  1\n\njulia> findlast(A,1)\n4\n\njulia> findlast(A,2)\n3\n\njulia> findlast(A,3)\n0\n```\n",
    (:line, 1012, :none),
    (:(=), (:call, :findlast, :A, :v), (:block,
        (:line, 1012, :none),
        (:call, :findprev, :A, :v, (:call, :length, :A))
      )),
    (:line, 1014, :none),
    "    findprev(predicate::Function, A, i::Integer)\n\nFind the previous linear index <= `i` of an element of `A` for which `predicate` returns `true`, or\n`0` if not found.\n\n```jldoctest\njulia> A = [4 6; 1 2]\n2×2 Array{Int64,2}:\n 4  6\n 1  2\n\njulia> findprev(isodd, A, 1)\n0\n\njulia> findprev(isodd, A, 3)\n2\n```\n",
    (:line, 1033, :none),
    (:function, (:call, :findprev, (:(::), :testf, :Function), :A, (:(::), :start, :Integer)), (:block,
        (:line, 1034, :none),
        (:for, (:(=), :i, (:(:), :start, -1, 1)), (:block,
            (:line, 1035, :none),
            (:&&, (:call, :testf, (:ref, :A, :i)), (:return, :i))
          )),
        (:line, 1037, :none),
        (:return, 0)
      )),
    (:line, 1040, :none),
    "    findlast(predicate::Function, A)\n\nReturn the linear index of the last element of `A` for which `predicate` returns `true`.\nReturns `0` if there is no such element.\n\n```jldoctest\njulia> A = [1 2; 3 4]\n2×2 Array{Int64,2}:\n 1  2\n 3  4\n\njulia> findlast(isodd, A)\n2\n\njulia> findlast(x -> x > 5, A)\n0\n```\n",
    (:line, 1059, :none),
    (:(=), (:call, :findlast, (:(::), :testf, :Function), :A), (:block,
        (:line, 1059, :none),
        (:call, :findprev, :testf, :A, (:call, :length, :A))
      )),
    (:line, 1061, :none),
    "    find(f::Function, A)\n\nReturn a vector `I` of the linear indexes of `A` where `f(A[I])` returns `true`.\nIf there are no such elements of `A`, find returns an empty array.\n\n```jldoctest\njulia> A = [1 2; 3 4]\n2×2 Array{Int64,2}:\n 1  2\n 3  4\n\njulia> find(isodd,A)\n2-element Array{Int64,1}:\n 1\n 2\n```\n",
    (:line, 1079, :none),
    (:function, (:call, :find, (:(::), :testf, :Function), :A), (:block,
        (:line, 1082, :none),
        (:(=), :tmpI, (:call, (:curly, :Array, :Int, 1), 0)),
        (:line, 1083, :none),
        (:(=), :inds, (:call, :_index_remapper, :A)),
        (:line, 1084, :none),
        (:for, (:(=), (:tuple, :i, :a), (:call, :enumerate, :A)), (:block,
            (:line, 1085, :none),
            (:if, (:call, :testf, :a), (:block,
                (:line, 1086, :none),
                (:call, :push!, :tmpI, (:ref, :inds, :i))
              ))
          )),
        (:line, 1089, :none),
        (:(=), :I, (:call, (:curly, :Array, :Int, 1), (:call, :length, :tmpI))),
        (:line, 1090, :none),
        (:call, :copy!, :I, :tmpI),
        (:line, 1091, :none),
        (:return, :I)
      )),
    (:line, 1093, :none),
    (:(=), (:call, :_index_remapper, (:(::), :A, :AbstractArray)), (:block,
        (:line, 1093, :none),
        (:call, :linearindices, :A)
      )),
    (:line, 1094, :none),
    (:(=), (:call, :_index_remapper, :iter), (:block,
        (:line, 1094, :none),
        (:call, :Colon)
      )),
    (:line, 1096, :none),
    "    find(A)\n\nReturn a vector of the linear indexes of the non-zeros in `A` (determined by `A[i]!=0`). A\ncommon use of this is to convert a boolean array to an array of indexes of the `true`\nelements. If there are no non-zero elements of `A`, `find` returns an empty array.\n\n```jldoctest\njulia> A = [true false; false true]\n2×2 Array{Bool,2}:\n  true  false\n false   true\n\njulia> find(A)\n2-element Array{Int64,1}:\n 1\n 4\n```\n",
    (:line, 1115, :none),
    (:function, (:call, :find, :A), (:block,
        (:line, 1116, :none),
        (:(=), :nnzA, (:call, :countnz, :A)),
        (:line, 1117, :none),
        (:(=), :I, (:call, (:curly, :Vector, :Int), :nnzA)),
        (:line, 1118, :none),
        (:(=), :count, 1),
        (:line, 1119, :none),
        (:(=), :inds, (:call, :_index_remapper, :A)),
        (:line, 1120, :none),
        (:for, (:(=), (:tuple, :i, :a), (:call, :enumerate, :A)), (:block,
            (:line, 1121, :none),
            (:if, (:call, :(!=), :a, 0), (:block,
                (:line, 1122, :none),
                (:(=), (:ref, :I, :count), (:ref, :inds, :i)),
                (:line, 1123, :none),
                (:+=, :count, 1)
              ))
          )),
        (:line, 1126, :none),
        (:return, :I)
      )),
    (:line, 1129, :none),
    (:(=), (:call, :find, (:(::), :x, :Number)), (:block,
        (:line, 1129, :none),
        (:if, (:call, :(==), :x, 0), (:call, (:curly, :Array, :Int, 1), 0), (:vect, 1))
      )),
    (:line, 1130, :none),
    (:(=), (:call, :find, (:(::), :testf, :Function), (:(::), :x, :Number)), (:block,
        (:line, 1130, :none),
        (:if, (:call, :!, (:call, :testf, :x)), (:call, (:curly, :Array, :Int, 1), 0), (:vect, 1))
      )),
    (:line, 1132, :none),
    (:(=), (:call, :findn, (:(::), :A, :AbstractVector)), (:block,
        (:line, 1132, :none),
        (:call, :find, :A)
      )),
    (:line, 1134, :none),
    "    findn(A)\n\nReturn a vector of indexes for each dimension giving the locations of the non-zeros in `A`\n(determined by `A[i]!=0`).\nIf there are no non-zero elements of `A`, `findn` returns a 2-tuple of empty arrays.\n\n```jldoctest\njulia> A = [1 2 0; 0 0 3; 0 4 0]\n3×3 Array{Int64,2}:\n 1  2  0\n 0  0  3\n 0  4  0\n\njulia> findn(A)\n([1,1,3,2],[1,2,2,3])\n\njulia> A = zeros(2,2)\n2×2 Array{Float64,2}:\n 0.0  0.0\n 0.0  0.0\n\njulia> findn(A)\n(Int64[],Int64[])\n```\n",
    (:line, 1160, :none),
    (:function, (:call, :findn, (:(::), :A, :AbstractMatrix)), (:block,
        (:line, 1161, :none),
        (:(=), :nnzA, (:call, :countnz, :A)),
        (:line, 1162, :none),
        (:(=), :I, (:call, :similar, :A, :Int, :nnzA)),
        (:line, 1163, :none),
        (:(=), :J, (:call, :similar, :A, :Int, :nnzA)),
        (:line, 1164, :none),
        (:(=), :count, 1),
        (:line, 1165, :none),
        (:for, (:block,
            (:(=), :j, (:call, :indices, :A, 2)),
            (:(=), :i, (:call, :indices, :A, 1))
          ), (:block,
            (:line, 1166, :none),
            (:if, (:call, :(!=), (:ref, :A, :i, :j), 0), (:block,
                (:line, 1167, :none),
                (:(=), (:ref, :I, :count), :i),
                (:line, 1168, :none),
                (:(=), (:ref, :J, :count), :j),
                (:line, 1169, :none),
                (:+=, :count, 1)
              ))
          )),
        (:line, 1172, :none),
        (:return, (:tuple, :I, :J))
      )),
    (:line, 1175, :none),
    "    findnz(A)\n\nReturn a tuple `(I, J, V)` where `I` and `J` are the row and column indexes of the non-zero\nvalues in matrix `A`, and `V` is a vector of the non-zero values.\n\n```jldoctest\njulia> A = [1 2 0; 0 0 3; 0 4 0]\n3×3 Array{Int64,2}:\n 1  2  0\n 0  0  3\n 0  4  0\n\njulia> findnz(A)\n([1,1,3,2],[1,2,2,3],[1,2,4,3])\n```\n",
    (:line, 1192, :none),
    (:function, (:call, (:curly, :findnz, :T), (:(::), :A, (:curly, :AbstractMatrix, :T))), (:block,
        (:line, 1193, :none),
        (:(=), :nnzA, (:call, :countnz, :A)),
        (:line, 1194, :none),
        (:(=), :I, (:call, :zeros, :Int, :nnzA)),
        (:line, 1195, :none),
        (:(=), :J, (:call, :zeros, :Int, :nnzA)),
        (:line, 1196, :none),
        (:(=), :NZs, (:call, (:curly, :Array, :T, 1), :nnzA)),
        (:line, 1197, :none),
        (:(=), :count, 1),
        (:line, 1198, :none),
        (:if, (:call, :>, :nnzA, 0), (:block,
            (:line, 1199, :none),
            (:for, (:block,
                (:(=), :j, (:call, :indices, :A, 2)),
                (:(=), :i, (:call, :indices, :A, 1))
              ), (:block,
                (:line, 1200, :none),
                (:(=), :Aij, (:ref, :A, :i, :j)),
                (:line, 1201, :none),
                (:if, (:call, :(!=), :Aij, 0), (:block,
                    (:line, 1202, :none),
                    (:(=), (:ref, :I, :count), :i),
                    (:line, 1203, :none),
                    (:(=), (:ref, :J, :count), :j),
                    (:line, 1204, :none),
                    (:(=), (:ref, :NZs, :count), :Aij),
                    (:line, 1205, :none),
                    (:+=, :count, 1)
                  ))
              ))
          )),
        (:line, 1209, :none),
        (:return, (:tuple, :I, :J, :NZs))
      )),
    (:line, 1212, :none),
    "    findmax(itr) -> (x, index)\n\nReturns the maximum element and its index.\nThe collection must not be empty.\n\n```jldoctest\njulia> findmax([8,0.1,-9,pi])\n(8.0,1)\n```\n",
    (:line, 1223, :none),
    (:function, (:call, :findmax, :a), (:block,
        (:line, 1224, :none),
        (:if, (:call, :isempty, :a), (:block,
            (:line, 1225, :none),
            (:call, :throw, (:call, :ArgumentError, "collection must be non-empty"))
          )),
        (:line, 1227, :none),
        (:(=), :s, (:call, :start, :a)),
        (:line, 1228, :none),
        (:(=), :mi, (:(=), :i, 1)),
        (:line, 1229, :none),
        (:(=), (:tuple, :m, :s), (:call, :next, :a, :s)),
        (:line, 1230, :none),
        (:while, (:call, :!, (:call, :done, :a, :s)), (:block,
            (:line, 1231, :none),
            (:(=), (:tuple, :ai, :s), (:call, :next, :a, :s)),
            (:line, 1232, :none),
            (:+=, :i, 1),
            (:line, 1233, :none),
            (:if, (:||, (:call, :>, :ai, :m), (:call, :(!=), :m, :m)), (:block,
                (:line, 1234, :none),
                (:(=), :m, :ai),
                (:line, 1235, :none),
                (:(=), :mi, :i)
              ))
          )),
        (:line, 1238, :none),
        (:return, (:tuple, :m, :mi))
      )),
    (:line, 1241, :none),
    "    findmin(itr) -> (x, index)\n\nReturns the minimum element and its index.\nThe collection must not be empty.\n\n```jldoctest\njulia> findmin([8,0.1,-9,pi])\n(-9.0,3)\n```\n",
    (:line, 1252, :none),
    (:function, (:call, :findmin, :a), (:block,
        (:line, 1253, :none),
        (:if, (:call, :isempty, :a), (:block,
            (:line, 1254, :none),
            (:call, :throw, (:call, :ArgumentError, "collection must be non-empty"))
          )),
        (:line, 1256, :none),
        (:(=), :s, (:call, :start, :a)),
        (:line, 1257, :none),
        (:(=), :mi, (:(=), :i, 1)),
        (:line, 1258, :none),
        (:(=), (:tuple, :m, :s), (:call, :next, :a, :s)),
        (:line, 1259, :none),
        (:while, (:call, :!, (:call, :done, :a, :s)), (:block,
            (:line, 1260, :none),
            (:(=), (:tuple, :ai, :s), (:call, :next, :a, :s)),
            (:line, 1261, :none),
            (:+=, :i, 1),
            (:line, 1262, :none),
            (:if, (:||, (:call, :<, :ai, :m), (:call, :(!=), :m, :m)), (:block,
                (:line, 1263, :none),
                (:(=), :m, :ai),
                (:line, 1264, :none),
                (:(=), :mi, :i)
              ))
          )),
        (:line, 1267, :none),
        (:return, (:tuple, :m, :mi))
      )),
    (:line, 1270, :none),
    "    indmax(itr) -> Integer\n\nReturns the index of the maximum element in a collection.\nThe collection must not be empty.\n\n```jldoctest\njulia> indmax([8,0.1,-9,pi])\n1\n```\n",
    (:line, 1281, :none),
    (:(=), (:call, :indmax, :a), (:block,
        (:line, 1281, :none),
        (:ref, (:call, :findmax, :a), 2)
      )),
    (:line, 1283, :none),
    "    indmin(itr) -> Integer\n\nReturns the index of the minimum element in a collection.\nThe collection must not be empty.\n\n```jldoctest\njulia> indmin([8,0.1,-9,pi])\n3\n```\n",
    (:line, 1294, :none),
    (:(=), (:call, :indmin, :a), (:block,
        (:line, 1294, :none),
        (:ref, (:call, :findmin, :a), 2)
      )),
    (:line, 1297, :none),
    "    indexin(a, b)\n\nReturns a vector containing the highest index in `b` for\neach value in `a` that is a member of `b` . The output\nvector contains 0 wherever `a` is not a member of `b`.\n\n```jldoctest\njulia> a = ['a', 'b', 'c', 'b', 'd', 'a'];\n\njulia> b = ['a','b','c'];\n\njulia> indexin(a,b)\n6-element Array{Int64,1}:\n 1\n 2\n 3\n 2\n 0\n 1\n\njulia> indexin(b,a)\n3-element Array{Int64,1}:\n 6\n 4\n 3\n```\n",
    (:line, 1325, :none),
    (:function, (:call, :indexin, (:(::), :a, :AbstractArray), (:(::), :b, :AbstractArray)), (:block,
        (:line, 1326, :none),
        (:(=), :bdict, (:call, :Dict, (:call, :zip, :b, (:(:), 1, (:call, :length, :b))))),
        (:line, 1327, :none),
        (:comprehension, (:generator, (:call, :get, :bdict, :i, 0), (:(=), :i, :a)))
      )),
    (:line, 1330, :none),
    "    findin(a, b)\n\nReturns the indices of elements in collection `a` that appear in collection `b`.\n\n```jldoctest\njulia> a = collect(1:3:15)\n5-element Array{Int64,1}:\n  1\n  4\n  7\n 10\n 13\n\njulia> b = collect(2:4:10)\n3-element Array{Int64,1}:\n  2\n  6\n 10\n\njulia> findin(a,b) # 10 is the only common element\n1-element Array{Int64,1}:\n 4\n```\n",
    (:line, 1355, :none),
    (:function, (:call, :findin, :a, :b), (:block,
        (:line, 1356, :none),
        (:(=), :ind, (:call, (:curly, :Array, :Int, 1), 0)),
        (:line, 1357, :none),
        (:(=), :bset, (:call, :Set, :b)),
        (:line, 1358, :none),
        (:macrocall, Symbol("@inbounds"), (:for, (:(=), (:tuple, :i, :ai), (:call, :enumerate, :a)), (:block,
              (:line, 1359, :none),
              (:&&, (:call, :in, :ai, :bset), (:call, :push!, :ind, :i))
            ))),
        (:line, 1361, :none),
        :ind
      )),
    (:line, 1366, :none),
    (:function, (:call, :indcopy, (:(::), :sz, :Dims), (:(::), :I, :Vector)), (:block,
        (:line, 1367, :none),
        (:(=), :n, (:call, :length, :I)),
        (:line, 1368, :none),
        (:(=), :s, (:ref, :sz, :n)),
        (:line, 1369, :none),
        (:for, (:(=), :i, (:(:), (:call, :+, :n, 1), (:call, :length, :sz))), (:block,
            (:line, 1370, :none),
            (:*=, :s, (:ref, :sz, :i))
          )),
        (:line, 1372, :none),
        (:(=), :dst, (:typed_comprehension, (:call, :eltype, :I), (:generator, (:call, :findin, (:ref, :I, :i), (:if, (:call, :<, :i, :n), (:(:), 1, (:ref, :sz, :i)), (:(:), 1, :s))), (:(=), :i, (:(:), 1, :n))))),
        (:line, 1373, :none),
        (:(=), :src, (:typed_comprehension, (:call, :eltype, :I), (:generator, (:ref, (:ref, :I, :i), (:call, :findin, (:ref, :I, :i), (:if, (:call, :<, :i, :n), (:(:), 1, (:ref, :sz, :i)), (:(:), 1, :s)))), (:(=), :i, (:(:), 1, :n))))),
        (:line, 1374, :none),
        (:tuple, :dst, :src)
      )),
    (:line, 1377, :none),
    (:function, (:call, :indcopy, (:(::), :sz, :Dims), (:(::), :I, (:curly, :Tuple, (:curly, :Vararg, :RangeIndex)))), (:block,
        (:line, 1378, :none),
        (:(=), :n, (:call, :length, :I)),
        (:line, 1379, :none),
        (:(=), :s, (:ref, :sz, :n)),
        (:line, 1380, :none),
        (:for, (:(=), :i, (:(:), (:call, :+, :n, 1), (:call, :length, :sz))), (:block,
            (:line, 1381, :none),
            (:*=, :s, (:ref, :sz, :i))
          )),
        (:line, 1383, :none),
        (:(=), (:(::), :dst, (:call, :typeof, :I)), (:(::), (:call, :ntuple, (:->, :i, (:block,
                  (:line, 1383, :none),
                  (:call, :findin, (:ref, :I, :i), (:if, (:call, :<, :i, :n), (:(:), 1, (:ref, :sz, :i)), (:(:), 1, :s)))
                )), :n), (:call, :typeof, :I))),
        (:line, 1384, :none),
        (:(=), (:(::), :src, (:call, :typeof, :I)), (:(::), (:call, :ntuple, (:->, :i, (:block,
                  (:line, 1384, :none),
                  (:ref, (:ref, :I, :i), (:call, :findin, (:ref, :I, :i), (:if, (:call, :<, :i, :n), (:(:), 1, (:ref, :sz, :i)), (:(:), 1, :s))))
                )), :n), (:call, :typeof, :I))),
        (:line, 1385, :none),
        (:tuple, :dst, :src)
      )),
    (:line, 1391, :none),
    (:(=), (:call, :filter, :f, (:(::), :As, :AbstractArray)), (:block,
        (:line, 1391, :none),
        (:ref, :As, (:(::), (:call, :map, :f, :As), (:curly, :AbstractArray, :Bool)))
      )),
    (:line, 1393, :none),
    (:function, (:call, :filter!, :f, (:(::), :a, :Vector)), (:block,
        (:line, 1394, :none),
        (:(=), :insrt, 1),
        (:line, 1395, :none),
        (:for, (:(=), :acurr, :a), (:block,
            (:line, 1396, :none),
            (:if, (:call, :f, :acurr), (:block,
                (:line, 1397, :none),
                (:(=), (:ref, :a, :insrt), :acurr),
                (:line, 1398, :none),
                (:+=, :insrt, 1)
              ))
          )),
        (:line, 1401, :none),
        (:call, :deleteat!, :a, (:(:), :insrt, (:call, :length, :a))),
        (:line, 1402, :none),
        (:return, :a)
      )),
    (:line, 1405, :none),
    (:function, (:call, :filter, :f, (:(::), :a, :Vector)), (:block,
        (:line, 1406, :none),
        (:(=), :r, (:call, (:curly, :Array, (:call, :eltype, :a)), 0)),
        (:line, 1407, :none),
        (:for, (:(=), :ai, :a), (:block,
            (:line, 1408, :none),
            (:if, (:call, :f, :ai), (:block,
                (:line, 1409, :none),
                (:call, :push!, :r, :ai)
              ))
          )),
        (:line, 1412, :none),
        (:return, :r)
      )),
    (:line, 1418, :none),
    (:function, (:call, :intersect, :v1, (:..., :vs)), (:block,
        (:line, 1419, :none),
        (:(=), :ret, (:call, (:curly, :Array, (:call, :promote_eltype, :v1, (:..., :vs))), 0)),
        (:line, 1420, :none),
        (:for, (:(=), :v_elem, :v1), (:block,
            (:line, 1421, :none),
            (:(=), :inall, true),
            (:line, 1422, :none),
            (:for, (:(=), :vsi, :vs), (:block,
                (:line, 1423, :none),
                (:if, (:call, :!, (:call, :in, :v_elem, :vsi)), (:block,
                    (:line, 1424, :none),
                    (:(=), :inall, false),
                    (:line, 1424, :none),
                    (:break,)
                  ))
              )),
            (:line, 1427, :none),
            (:if, :inall, (:block,
                (:line, 1428, :none),
                (:call, :push!, :ret, :v_elem)
              ))
          )),
        (:line, 1431, :none),
        :ret
      )),
    (:line, 1434, :none),
    (:function, (:call, :union, (:..., :vs)), (:block,
        (:line, 1435, :none),
        (:(=), :ret, (:call, (:curly, :Array, (:call, :promote_eltype, (:..., :vs))), 0)),
        (:line, 1436, :none),
        (:(=), :seen, (:call, :Set)),
        (:line, 1437, :none),
        (:for, (:(=), :v, :vs), (:block,
            (:line, 1438, :none),
            (:for, (:(=), :v_elem, :v), (:block,
                (:line, 1439, :none),
                (:if, (:call, :!, (:call, :in, :v_elem, :seen)), (:block,
                    (:line, 1440, :none),
                    (:call, :push!, :ret, :v_elem),
                    (:line, 1441, :none),
                    (:call, :push!, :seen, :v_elem)
                  ))
              ))
          )),
        (:line, 1445, :none),
        :ret
      )),
    (:line, 1449, :none),
    "    setdiff(a, b)\n\nConstruct the set of elements in `a` but not `b`. Maintains order with arrays. Note that\nboth arguments must be collections, and both will be iterated over. In particular,\n`setdiff(set,element)` where `element` is a potential member of `set`, will not work in\ngeneral.\n\n```jldoctest\njulia> setdiff([1,2,3],[3,4,5])\n2-element Array{Int64,1}:\n 1\n 2\n```\n",
    (:line, 1464, :none),
    (:function, (:call, :setdiff, :a, :b), (:block,
        (:line, 1465, :none),
        (:(=), :args_type, (:call, :promote_type, (:call, :eltype, :a), (:call, :eltype, :b))),
        (:line, 1466, :none),
        (:(=), :bset, (:call, :Set, :b)),
        (:line, 1467, :none),
        (:(=), :ret, (:call, (:curly, :Array, :args_type, 1), 0)),
        (:line, 1468, :none),
        (:(=), :seen, (:call, (:curly, :Set, (:call, :eltype, :a)))),
        (:line, 1469, :none),
        (:for, (:(=), :a_elem, :a), (:block,
            (:line, 1470, :none),
            (:if, (:&&, (:call, :!, (:call, :in, :a_elem, :seen)), (:call, :!, (:call, :in, :a_elem, :bset))), (:block,
                (:line, 1471, :none),
                (:call, :push!, :ret, :a_elem),
                (:line, 1472, :none),
                (:call, :push!, :seen, :a_elem)
              ))
          )),
        (:line, 1475, :none),
        :ret
      )),
    (:line, 1482, :none),
    (:(=), (:call, :symdiff, :a), (:block,
        (:line, 1482, :none),
        :a
      )),
    (:line, 1483, :none),
    (:(=), (:call, :symdiff, :a, :b), (:block,
        (:line, 1483, :none),
        (:call, :union, (:call, :setdiff, :a, :b), (:call, :setdiff, :b, :a))
      )),
    (:line, 1484, :none),
    "    symdiff(a, b, rest...)\n\nConstruct the symmetric difference of elements in the passed in sets or arrays.\nMaintains order with arrays.\n\n```jldoctest\njulia> symdiff([1,2,3],[3,4,5],[4,5,6])\n3-element Array{Int64,1}:\n 1\n 2\n 6\n```\n",
    (:line, 1498, :none),
    (:(=), (:call, :symdiff, :a, :b, (:..., :rest)), (:block,
        (:line, 1498, :none),
        (:call, :symdiff, :a, (:call, :symdiff, :b, (:..., :rest)))
      ))
  ))