(:quote, (:block,
    (:line, 5, :none),
    (:(=), (:call, :lock, (:(::), :IO)), (:block,
        (:line, 5, :none),
        :nothing
      )),
    (:line, 6, :none),
    (:(=), (:call, :unlock, (:(::), :IO)), (:block,
        (:line, 6, :none),
        :nothing
      )),
    (:line, 7, :none),
    (:(=), (:call, :reseteof, (:(::), :x, :IO)), (:block,
        (:line, 7, :none),
        :nothing
      )),
    (:line, 9, :none),
    (:const, (:(=), :SZ_UNBUFFERED_IO, 65536)),
    (:line, 10, :none),
    (:(=), (:call, :buffer_writes, (:(::), :x, :IO), (:kw, :bufsize, :SZ_UNBUFFERED_IO)), (:block,
        (:line, 10, :none),
        :nothing
      )),
    (:line, 12, :none),
    (:function, :isopen),
    (:line, 13, :none),
    (:function, :close),
    (:line, 14, :none),
    (:function, :flush),
    (:line, 15, :none),
    (:function, :wait_connected),
    (:line, 16, :none),
    (:function, :wait_readnb),
    (:line, 17, :none),
    (:function, :wait_readbyte),
    (:line, 18, :none),
    (:function, :wait_close),
    (:line, 19, :none),
    (:function, :nb_available),
    (:line, 20, :none),
    (:function, :readavailable),
    (:line, 21, :none),
    (:function, :isreadable),
    (:line, 22, :none),
    (:function, :iswritable),
    (:line, 23, :none),
    (:function, :copy),
    (:line, 24, :none),
    (:function, :eof),
    (:line, 26, :none),
    "    write(stream::IO, x)\n    write(filename::AbstractString, x)\n\nWrite the canonical binary representation of a value to the given I/O stream or file.\nReturns the number of bytes written into the stream.\n\nYou can write multiple values with the same `write` call. i.e. the following are equivalent:\n\n    write(stream, x, y...)\n    write(stream, x) + write(stream, y...)\n",
    (:line, 38, :none),
    (:function, :write),
    (:line, 40, :none),
    (:(=), (:call, :read, (:(::), :s, :IO), (:(::), (:curly, :Type, :UInt8))), (:block,
        (:line, 40, :none),
        (:call, :error, (:call, :typeof, :s), " does not support byte I/O")
      )),
    (:line, 41, :none),
    (:(=), (:call, :write, (:(::), :s, :IO), (:(::), :x, :UInt8)), (:block,
        (:line, 41, :none),
        (:call, :error, (:call, :typeof, :s), " does not support byte I/O")
      )),
    (:line, 43, :none),
    "    unsafe_write(io, ref, nbytes)\n\nCopy nbytes from ref (converted to a pointer) into the IO stream object.\n\nIt is recommended that subtypes `T<:IO` override the following method signature\nto provide more efficient implementations:\n`unsafe_write(s::T, p::Ptr{UInt8}, n::UInt)`\n",
    (:line, 52, :none),
    (:function, (:call, :unsafe_write, (:(::), :s, :IO), (:(::), :p, (:curly, :Ptr, :UInt8)), (:(::), :n, :UInt)), (:block,
        (:line, 53, :none),
        (:local, (:(=), (:(::), :written, :Int), 0)),
        (:line, 54, :none),
        (:for, (:(=), :i, (:(:), 1, :n)), (:block,
            (:line, 55, :none),
            (:+=, :written, (:call, :write, :s, (:call, :unsafe_load, :p, :i)))
          )),
        (:line, 57, :none),
        (:return, :written)
      )),
    (:line, 60, :none),
    "    unsafe_read(io, ref, nbytes)\n\nCopy nbytes from the IO stream object into ref (converted to a pointer).\n\nIt is recommended that subtypes `T<:IO` override the following method signature\nto provide more efficient implementations:\n`unsafe_read(s::T, p::Ptr{UInt8}, n::UInt)`\n",
    (:line, 69, :none),
    (:function, (:call, :unsafe_read, (:(::), :s, :IO), (:(::), :p, (:curly, :Ptr, :UInt8)), (:(::), :n, :UInt)), (:block,
        (:line, 70, :none),
        (:for, (:(=), :i, (:(:), 1, :n)), (:block,
            (:line, 71, :none),
            (:call, :unsafe_store!, :p, (:(::), (:call, :read, :s, :UInt8), :UInt8), :i)
          )),
        (:line, 73, :none),
        :nothing
      )),
    (:line, 78, :none),
    (:abstract, (:<:, :AbstractPipe, :IO)),
    (:line, 79, :none),
    (:function, :pipe_reader),
    (:line, 80, :none),
    (:function, :pipe_writer),
    (:line, 82, :none),
    (:(=), (:call, :write, (:(::), :io, :AbstractPipe), (:(::), :byte, :UInt8)), (:block,
        (:line, 82, :none),
        (:call, :write, (:call, :pipe_writer, :io), :byte)
      )),
    (:line, 83, :none),
    (:(=), (:call, :unsafe_write, (:(::), :io, :AbstractPipe), (:(::), :p, (:curly, :Ptr, :UInt8)), (:(::), :nb, :UInt)), (:block,
        (:line, 83, :none),
        (:call, :unsafe_write, (:call, :pipe_writer, :io), :p, :nb)
      )),
    (:line, 84, :none),
    (:(=), (:call, :buffer_writes, (:(::), :io, :AbstractPipe), (:..., :args)), (:block,
        (:line, 84, :none),
        (:call, :buffer_writes, (:call, :pipe_writer, :io), (:..., :args))
      )),
    (:line, 85, :none),
    (:(=), (:call, :flush, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 85, :none),
        (:call, :flush, (:call, :pipe_writer, :io))
      )),
    (:line, 87, :none),
    (:(=), (:call, :read, (:(::), :io, :AbstractPipe), (:(::), :byte, (:curly, :Type, :UInt8))), (:block,
        (:line, 87, :none),
        (:call, :read, (:call, :pipe_reader, :io), :byte)
      )),
    (:line, 88, :none),
    (:(=), (:call, :unsafe_read, (:(::), :io, :AbstractPipe), (:(::), :p, (:curly, :Ptr, :UInt8)), (:(::), :nb, :UInt)), (:block,
        (:line, 88, :none),
        (:call, :unsafe_read, (:call, :pipe_reader, :io), :p, :nb)
      )),
    (:line, 89, :none),
    (:(=), (:call, :read, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 89, :none),
        (:call, :read, (:call, :pipe_reader, :io))
      )),
    (:line, 90, :none),
    (:(=), (:call, (:curly, :readuntil, (:<:, :T, :AbstractPipe)), (:(::), :io, :T), (:..., :args)), (:block,
        (:line, 90, :none),
        (:call, :readuntil, (:call, :pipe_reader, :io), (:..., :args))
      )),
    (:line, 91, :none),
    (:(=), (:call, :readavailable, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 91, :none),
        (:call, :readavailable, (:call, :pipe_reader, :io))
      )),
    (:line, 93, :none),
    (:(=), (:call, :isreadable, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 93, :none),
        (:call, :isreadable, (:call, :pipe_reader, :io))
      )),
    (:line, 94, :none),
    (:(=), (:call, :iswritable, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 94, :none),
        (:call, :iswritable, (:call, :pipe_writer, :io))
      )),
    (:line, 95, :none),
    (:(=), (:call, :isopen, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 95, :none),
        (:||, (:call, :isopen, (:call, :pipe_writer, :io)), (:call, :isopen, (:call, :pipe_reader, :io)))
      )),
    (:line, 96, :none),
    (:(=), (:call, :close, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 96, :none),
        (:block,
          (:call, :close, (:call, :pipe_writer, :io)),
          (:call, :close, (:call, :pipe_reader, :io))
        )
      )),
    (:line, 97, :none),
    (:(=), (:call, :wait_readnb, (:(::), :io, :AbstractPipe), (:(::), :nb, :Int)), (:block,
        (:line, 97, :none),
        (:call, :wait_readnb, (:call, :pipe_reader, :io), :nb)
      )),
    (:line, 98, :none),
    (:(=), (:call, :wait_readbyte, (:(::), :io, :AbstractPipe), (:(::), :byte, :UInt8)), (:block,
        (:line, 98, :none),
        (:call, :wait_readbyte, (:call, :pipe_reader, :io), :byte)
      )),
    (:line, 99, :none),
    (:(=), (:call, :wait_close, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 99, :none),
        (:block,
          (:call, :wait_close, (:call, :pipe_writer, :io)),
          (:call, :wait_close, (:call, :pipe_reader, :io))
        )
      )),
    (:line, 100, :none),
    (:(=), (:call, :nb_available, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 100, :none),
        (:call, :nb_available, (:call, :pipe_reader, :io))
      )),
    (:line, 101, :none),
    (:(=), (:call, :eof, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 101, :none),
        (:call, :eof, (:call, :pipe_reader, :io))
      )),
    (:line, 102, :none),
    (:(=), (:call, :reseteof, (:(::), :io, :AbstractPipe)), (:block,
        (:line, 102, :none),
        (:call, :reseteof, (:call, :pipe_reader, :io))
      )),
    (:line, 107, :none),
    (:(=), (:call, :write, (:(::), :filename, :AbstractString), (:..., :args)), (:block,
        (:line, 107, :none),
        (:call, :open, (:->, :io, (:block,
              (:line, 107, :none),
              (:call, :write, :io, (:..., :args))
            )), :filename, "w")
      )),
    (:line, 109, :none),
    (:(=), (:call, :read, (:(::), :filename, :AbstractString), (:..., :args)), (:block,
        (:line, 109, :none),
        (:call, :open, (:->, :io, (:block,
              (:line, 109, :none),
              (:call, :read, :io, (:..., :args))
            )), :filename)
      )),
    (:line, 110, :none),
    (:(=), (:call, :read!, (:(::), :filename, :AbstractString), :a), (:block,
        (:line, 110, :none),
        (:call, :open, (:->, :io, (:block,
              (:line, 110, :none),
              (:call, :read!, :io, :a)
            )), :filename)
      )),
    (:line, 111, :none),
    (:(=), (:call, :readstring, (:(::), :filename, :AbstractString)), (:block,
        (:line, 111, :none),
        (:call, :open, :readstring, :filename)
      )),
    (:line, 112, :none),
    (:(=), (:call, :readuntil, (:(::), :filename, :AbstractString), (:..., :args)), (:block,
        (:line, 112, :none),
        (:call, :open, (:->, :io, (:block,
              (:line, 112, :none),
              (:call, :readuntil, :io, (:..., :args))
            )), :filename)
      )),
    (:line, 113, :none),
    (:(=), (:call, :readline, (:(::), :filename, :AbstractString)), (:block,
        (:line, 113, :none),
        (:call, :open, :readline, :filename)
      )),
    (:line, 114, :none),
    (:(=), (:call, :readlines, (:(::), :filename, :AbstractString)), (:block,
        (:line, 114, :none),
        (:call, :open, :readlines, :filename)
      )),
    (:line, 119, :none),
    "    ENDIAN_BOM\n\nThe 32-bit byte-order-mark indicates the native byte order of the host machine.\nLittle-endian machines will contain the value `0x04030201`. Big-endian machines will contain\nthe value `0x01020304`.\n",
    (:line, 126, :none),
    (:const, (:(=), :ENDIAN_BOM, (:ref, (:call, :reinterpret, :UInt32, (:typed_vcat, :UInt8, (:(:), 1, 4))), 1))),
    (:line, 128, :none),
    (:if, (:call, :(==), :ENDIAN_BOM, 0x01020304), (:block,
        (:line, 129, :none),
        (:(=), (:call, :ntoh, :x), (:block,
            (:line, 129, :none),
            :x
          )),
        (:line, 130, :none),
        (:(=), (:call, :hton, :x), (:block,
            (:line, 130, :none),
            :x
          )),
        (:line, 131, :none),
        (:(=), (:call, :ltoh, :x), (:block,
            (:line, 131, :none),
            (:call, :bswap, :x)
          )),
        (:line, 132, :none),
        (:(=), (:call, :htol, :x), (:block,
            (:line, 132, :none),
            (:call, :bswap, :x)
          ))
      ), (:block,
        (:line, 133, :none),
        (:if, (:call, :(==), :ENDIAN_BOM, 0x04030201), (:block,
            (:line, 134, :none),
            (:(=), (:call, :ntoh, :x), (:block,
                (:line, 134, :none),
                (:call, :bswap, :x)
              )),
            (:line, 135, :none),
            (:(=), (:call, :hton, :x), (:block,
                (:line, 135, :none),
                (:call, :bswap, :x)
              )),
            (:line, 136, :none),
            (:(=), (:call, :ltoh, :x), (:block,
                (:line, 136, :none),
                :x
              )),
            (:line, 137, :none),
            (:(=), (:call, :htol, :x), (:block,
                (:line, 137, :none),
                :x
              ))
          ), (:block,
            (:line, 139, :none),
            (:call, :error, "seriously? what is this machine?")
          ))
      )),
    (:line, 142, :none),
    (:(=), (:call, :isreadonly, :s), (:block,
        (:line, 142, :none),
        (:&&, (:call, :isreadable, :s), (:call, :!, (:call, :iswritable, :s)))
      )),
    (:line, 146, :none),
    (:(=), (:call, :write, (:(::), :io, :IO), :x), (:block,
        (:line, 146, :none),
        (:call, :throw, (:call, :MethodError, :write, (:tuple, :io, :x)))
      )),
    (:line, 147, :none),
    (:function, (:call, :write, (:(::), :io, :IO), (:..., :xs)), (:block,
        (:line, 148, :none),
        (:local, (:(=), (:(::), :written, :Int), 0)),
        (:line, 149, :none),
        (:for, (:(=), :x, :xs), (:block,
            (:line, 150, :none),
            (:+=, :written, (:call, :write, :io, :x))
          )),
        (:line, 152, :none),
        (:return, :written)
      )),
    (:line, 155, :none),
    (:macrocall, Symbol("@noinline"), (:(=), (:call, (:curly, :unsafe_write, :T), (:(::), :s, :IO), (:(::), :p, (:curly, :Ref, :T)), (:(::), :n, :Integer)), (:block,
          (:line, 155, :none),
          (:call, :unsafe_write, :s, (:(::), (:call, :unsafe_convert, (:curly, :Ref, :T), :p), :Ptr), :n)
        ))),
    (:line, 156, :none),
    (:(=), (:call, :unsafe_write, (:(::), :s, :IO), (:(::), :p, :Ptr), (:(::), :n, :Integer)), (:block,
        (:line, 156, :none),
        (:call, :unsafe_write, :s, (:call, :convert, (:curly, :Ptr, :UInt8), :p), (:call, :convert, :UInt, :n))
      )),
    (:line, 157, :none),
    (:(=), (:call, (:curly, :write, :T), (:(::), :s, :IO), (:(::), :x, (:curly, :Ref, :T))), (:block,
        (:line, 157, :none),
        (:call, :unsafe_write, :s, :x, (:call, (:., :Core, (:quote, #QuoteNode
                :sizeof
              )), :T))
      )),
    (:line, 158, :none),
    (:(=), (:call, :write, (:(::), :s, :IO), (:(::), :x, :Int8)), (:block,
        (:line, 158, :none),
        (:call, :write, :s, (:call, :reinterpret, :UInt8, :x))
      )),
    (:line, 159, :none),
    (:function, (:call, :write, (:(::), :s, :IO), (:(::), :x, (:curly, :Union, :Int16, :UInt16, :Int32, :UInt32, :Int64, :UInt64, :Int128, :UInt128, :Float16, :Float32, :Float64))), (:block,
        (:line, 160, :none),
        (:return, (:call, :write, :s, (:call, :Ref, :x)))
      )),
    (:line, 163, :none),
    (:(=), (:call, :write, (:(::), :s, :IO), (:(::), :x, :Bool)), (:block,
        (:line, 163, :none),
        (:call, :write, :s, (:call, :UInt8, :x))
      )),
    (:line, 164, :none),
    (:(=), (:call, :write, (:(::), :to, :IO), (:(::), :p, :Ptr)), (:block,
        (:line, 164, :none),
        (:call, :write, :to, (:call, :convert, :UInt, :p))
      )),
    (:line, 166, :none),
    (:function, (:call, :write, (:(::), :s, :IO), (:(::), :A, :AbstractArray)), (:block,
        (:line, 167, :none),
        (:(=), :nb, 0),
        (:line, 168, :none),
        (:for, (:(=), :a, :A), (:block,
            (:line, 169, :none),
            (:+=, :nb, (:call, :write, :s, :a))
          )),
        (:line, 171, :none),
        (:return, :nb)
      )),
    (:line, 174, :none),
    (:macrocall, Symbol("@noinline"), (:function, (:call, :write, (:(::), :s, :IO), (:(::), :a, (:curly, :Array, :UInt8))), (:block,
          (:line, 175, :none),
          (:return, (:call, :unsafe_write, :s, (:call, :pointer, :a), (:call, :sizeof, :a)))
        ))),
    (:line, 178, :none),
    (:macrocall, Symbol("@noinline"), (:function, (:call, (:curly, :write, :T), (:(::), :s, :IO), (:(::), :a, (:curly, :Array, :T))), (:block,
          (:line, 179, :none),
          (:if, (:call, :isbits, :T), (:block,
              (:line, 180, :none),
              (:return, (:call, :unsafe_write, :s, (:call, :pointer, :a), (:call, :sizeof, :a)))
            ), (:block,
              (:line, 182, :none),
              (:(=), :nb, 0),
              (:line, 183, :none),
              (:for, (:(=), :b, :a), (:block,
                  (:line, 184, :none),
                  (:+=, :nb, (:call, :write, :s, :b))
                )),
              (:line, 186, :none),
              (:return, :nb)
            ))
        ))),
    (:line, 191, :none),
    (:function, (:call, :write, (:(::), :s, :IO), (:(::), :ch, :Char)), (:block,
        (:line, 192, :none),
        (:(=), :c, (:call, :reinterpret, :UInt32, :ch)),
        (:line, 193, :none),
        (:if, (:call, :<, :c, 0x80), (:block,
            (:line, 194, :none),
            (:return, (:call, :write, :s, (:call, :%, :c, :UInt8)))
          ), (:block,
            (:line, 195, :none),
            (:if, (:call, :<, :c, 0x0800), (:block,
                (:line, 196, :none),
                (:return, (:call, :+, (:call, :write, :s, (:call, :%, (:call, :|, (:call, :>>, :c, 6), 0xc0), :UInt8)), (:call, :write, :s, (:call, :%, (:call, :|, (:call, :&, :c, 0x3f), 0x80), :UInt8))))
              ), (:block,
                (:line, 198, :none),
                (:if, (:call, :<, :c, 0x00010000), (:block,
                    (:line, 199, :none),
                    (:return, (:call, :+, (:call, :write, :s, (:call, :%, (:call, :|, (:call, :>>, :c, 12), 0xe0), :UInt8)), (:call, :write, :s, (:call, :%, (:call, :|, (:call, :&, (:call, :>>, :c, 6), 0x3f), 0x80), :UInt8)), (:call, :write, :s, (:call, :%, (:call, :|, (:call, :&, :c, 0x3f), 0x80), :UInt8))))
                  ), (:block,
                    (:line, 202, :none),
                    (:if, (:call, :<, :c, 0x00110000), (:block,
                        (:line, 203, :none),
                        (:return, (:call, :+, (:call, :write, :s, (:call, :%, (:call, :|, (:call, :>>, :c, 18), 0xf0), :UInt8)), (:call, :write, :s, (:call, :%, (:call, :|, (:call, :&, (:call, :>>, :c, 12), 0x3f), 0x80), :UInt8)), (:call, :write, :s, (:call, :%, (:call, :|, (:call, :&, (:call, :>>, :c, 6), 0x3f), 0x80), :UInt8)), (:call, :write, :s, (:call, :%, (:call, :|, (:call, :&, :c, 0x3f), 0x80), :UInt8))))
                      ), (:block,
                        (:line, 208, :none),
                        (:return, (:call, :write, :s, '�'))
                      ))
                  ))
              ))
          ))
      )),
    (:line, 212, :none),
    (:function, (:call, :write, (:(::), :io, :IO), (:(::), :s, :Symbol)), (:block,
        (:line, 213, :none),
        (:(=), :pname, (:call, :unsafe_convert, (:curly, :Ptr, :UInt8), :s)),
        (:line, 214, :none),
        (:return, (:call, :unsafe_write, :io, :pname, (:call, :Int, (:ccall, (:quote, #QuoteNode
                  :strlen
                ), :Csize_t, (:tuple, :Cstring), :pname))))
      )),
    (:line, 217, :none),
    (:function, (:call, :write, (:(::), :to, :IO), (:(::), :from, :IO)), (:block,
        (:line, 218, :none),
        (:while, (:call, :!, (:call, :eof, :from)), (:block,
            (:line, 219, :none),
            (:call, :write, :to, (:call, :readavailable, :from))
          ))
      )),
    (:line, 223, :none),
    (:macrocall, Symbol("@noinline"), (:(=), (:call, (:curly, :unsafe_read, :T), (:(::), :s, :IO), (:(::), :p, (:curly, :Ref, :T)), (:(::), :n, :Integer)), (:block,
          (:line, 223, :none),
          (:call, :unsafe_read, :s, (:(::), (:call, :unsafe_convert, (:curly, :Ref, :T), :p), :Ptr), :n)
        ))),
    (:line, 224, :none),
    (:(=), (:call, :unsafe_read, (:(::), :s, :IO), (:(::), :p, :Ptr), (:(::), :n, :Integer)), (:block,
        (:line, 224, :none),
        (:call, :unsafe_read, :s, (:call, :convert, (:curly, :Ptr, :UInt8), :p), (:call, :convert, :UInt, :n))
      )),
    (:line, 225, :none),
    (:(=), (:call, (:curly, :read, :T), (:(::), :s, :IO), (:(::), :x, (:curly, :Ref, :T))), (:block,
        (:line, 225, :none),
        (:block,
          (:call, :unsafe_read, :s, :x, (:call, (:., :Core, (:quote, #QuoteNode
                  :sizeof
                )), :T)),
          :x
        )
      )),
    (:line, 227, :none),
    (:(=), (:call, :read, (:(::), :s, :IO), (:(::), (:curly, :Type, :Int8))), (:block,
        (:line, 227, :none),
        (:call, :reinterpret, :Int8, (:call, :read, :s, :UInt8))
      )),
    (:line, 228, :none),
    (:function, (:call, :read, (:(::), :s, :IO), (:(::), :T, (:curly, :Union, (:curly, :Type, :Int16), (:curly, :Type, :UInt16), (:curly, :Type, :Int32), (:curly, :Type, :UInt32), (:curly, :Type, :Int64), (:curly, :Type, :UInt64), (:curly, :Type, :Int128), (:curly, :Type, :UInt128), (:curly, :Type, :Float16), (:curly, :Type, :Float32), (:curly, :Type, :Float64)))), (:block,
        (:line, 229, :none),
        (:return, (:(::), (:ref, (:call, :read, :s, (:call, (:curly, :Ref, :T), 0))), :T))
      )),
    (:line, 232, :none),
    (:(=), (:call, :read, (:(::), :s, :IO), (:(::), (:curly, :Type, :Bool))), (:block,
        (:line, 232, :none),
        (:call, :(!=), (:call, :read, :s, :UInt8), 0)
      )),
    (:line, 233, :none),
    (:(=), (:call, (:curly, :read, :T), (:(::), :s, :IO), (:(::), (:curly, :Type, (:curly, :Ptr, :T)))), (:block,
        (:line, 233, :none),
        (:call, :convert, (:curly, :Ptr, :T), (:call, :read, :s, :UInt))
      )),
    (:line, 235, :none),
    (:(=), (:call, (:curly, :read, :T), (:(::), :s, :IO), (:(::), :t, (:curly, :Type, :T)), (:(::), :d1, :Int), (:..., (:(::), :dims, :Int))), (:block,
        (:line, 235, :none),
        (:call, :read, :s, :t, (:call, :tuple, :d1, (:..., :dims)))
      )),
    (:line, 236, :none),
    (:(=), (:call, (:curly, :read, :T), (:(::), :s, :IO), (:(::), :t, (:curly, :Type, :T)), (:(::), :d1, :Integer), (:..., (:(::), :dims, :Integer))), (:block,
        (:line, 236, :none),
        (:call, :read, :s, :t, (:call, :convert, (:curly, :Tuple, (:curly, :Vararg, :Int)), (:call, :tuple, :d1, (:..., :dims))))
      )),
    (:line, 239, :none),
    (:(=), (:call, (:curly, :read, :T), (:(::), :s, :IO), (:(::), (:curly, :Type, :T)), (:(::), :dims, :Dims)), (:block,
        (:line, 239, :none),
        (:call, :read!, :s, (:call, (:curly, :Array, :T), :dims))
      )),
    (:line, 241, :none),
    (:macrocall, Symbol("@noinline"), (:function, (:call, :read!, (:(::), :s, :IO), (:(::), :a, (:curly, :Array, :UInt8))), (:block,
          (:line, 242, :none),
          (:call, :unsafe_read, :s, (:call, :pointer, :a), (:call, :sizeof, :a)),
          (:line, 243, :none),
          (:return, :a)
        ))),
    (:line, 246, :none),
    (:macrocall, Symbol("@noinline"), (:function, (:call, (:curly, :read!, :T), (:(::), :s, :IO), (:(::), :a, (:curly, :Array, :T))), (:block,
          (:line, 247, :none),
          (:if, (:call, :isbits, :T), (:block,
              (:line, 248, :none),
              (:call, :unsafe_read, :s, (:call, :pointer, :a), (:call, :sizeof, :a))
            ), (:block,
              (:line, 250, :none),
              (:for, (:(=), :i, (:call, :eachindex, :a)), (:block,
                  (:line, 251, :none),
                  (:(=), (:ref, :a, :i), (:call, :read, :s, :T))
                ))
            )),
          (:line, 254, :none),
          (:return, :a)
        ))),
    (:line, 257, :none),
    (:function, (:call, :read, (:(::), :s, :IO), (:(::), (:curly, :Type, :Char))), (:block,
        (:line, 258, :none),
        (:(=), :ch, (:call, :read, :s, :UInt8)),
        (:line, 259, :none),
        (:if, (:call, :<, :ch, 0x80), (:block,
            (:line, 260, :none),
            (:return, (:call, :Char, :ch))
          )),
        (:line, 264, :none),
        (:(=), :trailing, (:ref, (:., :Base, (:quote, #QuoteNode
                :utf8_trailing
              )), (:call, :+, :ch, 1))),
        (:line, 265, :none),
        (:(=), (:(::), :c, :UInt32), 0),
        (:line, 266, :none),
        (:for, (:(=), :j, (:(:), 1, :trailing)), (:block,
            (:line, 267, :none),
            (:+=, :c, :ch),
            (:line, 268, :none),
            (:<<=, :c, 6),
            (:line, 269, :none),
            (:(=), :ch, (:call, :read, :s, :UInt8))
          )),
        (:line, 271, :none),
        (:+=, :c, :ch),
        (:line, 272, :none),
        (:-=, :c, (:ref, (:., :Base, (:quote, #QuoteNode
                :utf8_offset
              )), (:call, :+, :trailing, 1))),
        (:line, 273, :none),
        (:return, (:call, :Char, :c))
      )),
    (:line, 276, :none),
    (:function, (:call, :readuntil, (:(::), :s, :IO), (:(::), :delim, :Char)), (:block,
        (:line, 277, :none),
        (:if, (:call, :<, :delim, (:call, :Char, 0x80)), (:block,
            (:line, 278, :none),
            (:return, (:call, :String, (:call, :readuntil, :s, (:call, :%, :delim, :UInt8))))
          )),
        (:line, 280, :none),
        (:(=), :out, (:call, :IOBuffer)),
        (:line, 281, :none),
        (:while, (:call, :!, (:call, :eof, :s)), (:block,
            (:line, 282, :none),
            (:(=), :c, (:call, :read, :s, :Char)),
            (:line, 283, :none),
            (:call, :write, :out, :c),
            (:line, 284, :none),
            (:if, (:call, :(==), :c, :delim), (:block,
                (:line, 285, :none),
                (:break,)
              ))
          )),
        (:line, 288, :none),
        (:return, (:call, :takebuf_string, :out))
      )),
    (:line, 291, :none),
    (:function, (:call, (:curly, :readuntil, :T), (:(::), :s, :IO), (:(::), :delim, :T)), (:block,
        (:line, 292, :none),
        (:(=), :out, (:ref, :T)),
        (:line, 293, :none),
        (:while, (:call, :!, (:call, :eof, :s)), (:block,
            (:line, 294, :none),
            (:(=), :c, (:call, :read, :s, :T)),
            (:line, 295, :none),
            (:call, :push!, :out, :c),
            (:line, 296, :none),
            (:if, (:call, :(==), :c, :delim), (:block,
                (:line, 297, :none),
                (:break,)
              ))
          )),
        (:line, 300, :none),
        (:return, :out)
      )),
    (:line, 304, :none),
    (:function, (:call, :readuntil, (:(::), :s, :IO), (:(::), :t, :AbstractString)), (:block,
        (:line, 305, :none),
        (:(=), :l, (:call, :length, :t)),
        (:line, 306, :none),
        (:if, (:call, :(==), :l, 0), (:block,
            (:line, 307, :none),
            (:return, "")
          )),
        (:line, 309, :none),
        (:if, (:call, :>, :l, 40), (:block,
            (:line, 310, :none),
            (:call, :warn, "readuntil(IO,AbstractString) will perform poorly with a long string")
          )),
        (:line, 312, :none),
        (:(=), :out, (:call, :IOBuffer)),
        (:line, 313, :none),
        (:(=), :m, (:call, (:curly, :Array, :Char), :l)),
        (:line, 314, :none),
        (:(=), :t, (:call, :collect, :t)),
        (:line, 315, :none),
        (:(=), :i, 0),
        (:line, 316, :none),
        (:while, (:call, :!, (:call, :eof, :s)), (:block,
            (:line, 317, :none),
            (:+=, :i, 1),
            (:line, 318, :none),
            (:(=), :c, (:call, :read, :s, :Char)),
            (:line, 319, :none),
            (:call, :write, :out, :c),
            (:line, 320, :none),
            (:if, (:call, :(<=), :i, :l), (:block,
                (:line, 321, :none),
                (:(=), (:ref, :m, :i), :c)
              ), (:block,
                (:line, 324, :none),
                (:for, (:(=), :j, (:(:), 2, :l)), (:block,
                    (:line, 325, :none),
                    (:(=), (:ref, :m, (:call, :-, :j, 1)), (:ref, :m, :j))
                  )),
                (:line, 327, :none),
                (:(=), (:ref, :m, :l), :c)
              )),
            (:line, 329, :none),
            (:if, (:&&, (:call, :(>=), :i, :l), (:call, :(==), :m, :t)), (:block,
                (:line, 330, :none),
                (:break,)
              ))
          )),
        (:line, 333, :none),
        (:return, (:call, :takebuf_string, :out))
      )),
    (:line, 336, :none),
    (:(=), (:call, :readline), (:block,
        (:line, 336, :none),
        (:call, :readline, :STDIN)
      )),
    (:line, 337, :none),
    (:(=), (:call, :readline, (:(::), :s, :IO)), (:block,
        (:line, 337, :none),
        (:call, :readuntil, :s, '\n')
      )),
    (:line, 338, :none),
    (:(=), (:call, :readchomp, :x), (:block,
        (:line, 338, :none),
        (:call, :chomp!, (:call, :readstring, :x))
      )),
    (:line, 341, :none),
    (:function, (:call, :readbytes!, (:(::), :s, :IO), (:(::), :b, (:curly, :AbstractArray, :UInt8)), (:kw, :nb, (:call, :length, :b))), (:block,
        (:line, 342, :none),
        (:(=), :olb, (:(=), :lb, (:call, :length, :b))),
        (:line, 343, :none),
        (:(=), :nr, 0),
        (:line, 344, :none),
        (:while, (:&&, (:call, :<, :nr, :nb), (:call, :!, (:call, :eof, :s))), (:block,
            (:line, 345, :none),
            (:(=), :a, (:call, :read, :s, :UInt8)),
            (:line, 346, :none),
            (:+=, :nr, 1),
            (:line, 347, :none),
            (:if, (:call, :>, :nr, :lb), (:block,
                (:line, 348, :none),
                (:(=), :lb, (:call, :*, :nr, 2)),
                (:line, 349, :none),
                (:call, :resize!, :b, :lb)
              )),
            (:line, 351, :none),
            (:(=), (:ref, :b, :nr), :a)
          )),
        (:line, 353, :none),
        (:if, (:call, :>, :lb, :olb), (:block,
            (:line, 354, :none),
            (:call, :resize!, :b, :nr)
          )),
        (:line, 356, :none),
        (:return, :nr)
      )),
    (:line, 359, :none),
    "    read(s::IO, nb=typemax(Int))\n\nRead at most `nb` bytes from `s`, returning a `Vector{UInt8}` of the bytes read.\n",
    (:line, 364, :none),
    (:function, (:call, :read, (:(::), :s, :IO), (:kw, :nb, (:call, :typemax, :Int))), (:block,
        (:line, 367, :none),
        (:(=), :b, (:call, (:curly, :Array, :UInt8), (:if, (:call, :(==), :nb, (:call, :typemax, :Int)), 1024, :nb))),
        (:line, 368, :none),
        (:(=), :nr, (:call, :readbytes!, :s, :b, :nb)),
        (:line, 369, :none),
        (:return, (:call, :resize!, :b, :nr))
      )),
    (:line, 372, :none),
    (:(=), (:call, :readstring, (:(::), :s, :IO)), (:block,
        (:line, 372, :none),
        (:call, :String, (:call, :read, :s))
      )),
    (:line, 376, :none),
    (:type, true, :EachLine, (:block,
        (:line, 377, :none),
        (:(::), :stream, :IO),
        (:line, 378, :none),
        (:(::), :ondone, :Function),
        (:line, 379, :none),
        (:(=), (:call, :EachLine, :stream), (:block,
            (:line, 379, :none),
            (:call, :EachLine, :stream, (:->, (:tuple,), (:block,
                  (:line, 379, :none),
                  :nothing
                )))
          )),
        (:line, 380, :none),
        (:(=), (:call, :EachLine, :stream, :ondone), (:block,
            (:line, 380, :none),
            (:call, :new, :stream, :ondone)
          ))
      )),
    (:line, 382, :none),
    (:(=), (:call, :eachline, (:(::), :stream, :IO)), (:block,
        (:line, 382, :none),
        (:call, :EachLine, :stream)
      )),
    (:line, 383, :none),
    (:function, (:call, :eachline, (:(::), :filename, :AbstractString)), (:block,
        (:line, 384, :none),
        (:(=), :s, (:call, :open, :filename)),
        (:line, 385, :none),
        (:call, :EachLine, :s, (:->, (:tuple,), (:block,
              (:line, 385, :none),
              (:call, :close, :s)
            )))
      )),
    (:line, 388, :none),
    (:(=), (:call, :start, (:(::), :itr, :EachLine)), (:block,
        (:line, 388, :none),
        :nothing
      )),
    (:line, 389, :none),
    (:function, (:call, :done, (:(::), :itr, :EachLine), :nada), (:block,
        (:line, 390, :none),
        (:if, (:call, :!, (:call, :eof, (:., :itr, (:quote, #QuoteNode
                  :stream
                )))), (:block,
            (:line, 391, :none),
            (:return, false)
          )),
        (:line, 393, :none),
        (:call, (:., :itr, (:quote, #QuoteNode
              :ondone
            ))),
        (:line, 394, :none),
        true
      )),
    (:line, 396, :none),
    (:(=), (:call, :next, (:(::), :itr, :EachLine), :nada), (:block,
        (:line, 396, :none),
        (:tuple, (:call, :readline, (:., :itr, (:quote, #QuoteNode
                :stream
              ))), :nothing)
      )),
    (:line, 397, :none),
    (:(=), (:call, :eltype, (:(::), (:curly, :Type, :EachLine))), (:block,
        (:line, 397, :none),
        :String
      )),
    (:line, 399, :none),
    (:(=), (:call, :readlines, (:kw, :s, :STDIN)), (:block,
        (:line, 399, :none),
        (:call, :collect, (:call, :eachline, :s))
      )),
    (:line, 401, :none),
    (:(=), (:call, :iteratorsize, (:(::), (:curly, :Type, :EachLine))), (:block,
        (:line, 401, :none),
        (:call, :SizeUnknown)
      )),
    (:line, 408, :none),
    (:function, (:call, :mark, (:(::), :io, :IO)), (:block,
        (:line, 409, :none),
        (:(=), (:., :io, (:quote, #QuoteNode
              :mark
            )), (:call, :position, :io))
      )),
    (:line, 412, :none),
    (:function, (:call, :unmark, (:(::), :io, :IO)), (:block,
        (:line, 413, :none),
        (:&&, (:call, :!, (:call, :ismarked, :io)), (:return, false)),
        (:line, 414, :none),
        (:(=), (:., :io, (:quote, #QuoteNode
              :mark
            )), -1),
        (:line, 415, :none),
        (:return, true)
      )),
    (:line, 418, :none),
    (:function, (:call, (:curly, :reset, (:<:, :T, :IO)), (:(::), :io, :T)), (:block,
        (:line, 419, :none),
        (:||, (:call, :ismarked, :io), (:call, :throw, (:call, :ArgumentError, (:string, :T, " not marked")))),
        (:line, 420, :none),
        (:(=), :m, (:., :io, (:quote, #QuoteNode
              :mark
            ))),
        (:line, 421, :none),
        (:call, :seek, :io, :m),
        (:line, 422, :none),
        (:(=), (:., :io, (:quote, #QuoteNode
              :mark
            )), -1),
        (:line, 423, :none),
        (:return, :m)
      )),
    (:line, 426, :none),
    (:(=), (:call, :ismarked, (:(::), :io, :IO)), (:block,
        (:line, 426, :none),
        (:call, :(>=), (:., :io, (:quote, #QuoteNode
              :mark
            )), 0)
      )),
    (:line, 430, :none),
    (:(=), (:call, :flush, (:(::), :io, :IO)), (:block,
        (:line, 430, :none),
        :nothing
      ))
  ))