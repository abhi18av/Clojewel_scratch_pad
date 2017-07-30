
f = open("LearnJuliaTest.jl","r")
content = readstring(f)
close(f)



f = open("test1.jl","r")
content = readstring(f)
close(f)



f = open("array.jl","r")
content = readstring(f)
close(f)

quoted_content = "quote " * content * " end"
expr = parse(quoted_content)

Meta.show_sexpr(expr)

#eval(eval(parse(quoted_content)))


