


function convertFile(input_file_name::String)
f = open(input_file_name,"r")
content = readstring(f)
close(f)

quoted_content = "quote " * content * " end"
expr = parse(quoted_content)


#Meta.show_sexpr(expr)

#string(Meta.show_sexpr(expr))

#return expr
return Meta.show_sexpr(expr)

end


#eval(eval(parse(quoted_content)))

#println(ARGS[1])

input_file_name = ARGS[1]
convertFile(input_file_name)

#convertFile("io.jl")

#output_expr = convertFile(input_file_name)

#output_str = string(output_expr)


#output_file_name = split(input_file_name, ".")[1] * ".jls"
#write(output_file_name, output_expr)



#f = open("LearnJuliaTest.jl","r")
#content = readstring(f)
#close(f)



#f = open("test1.jl","r")
#content = readstring(f)
#close(f)

