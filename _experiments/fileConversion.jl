
#println(ARGS[1])
fileName = ARGS[1]


function convertFile(fileName::String)
f = open(fileName,"r")
content = readstring(f)
close(f)

quoted_content = "quote " * content * " end"
expr = parse(quoted_content)

Meta.show_sexpr(expr)


end


#eval(eval(parse(quoted_content)))


convertFile(fileName)




#f = open("LearnJuliaTest.jl","r")
#content = readstring(f)
#close(f)



#f = open("test1.jl","r")
#content = readstring(f)
#close(f)

