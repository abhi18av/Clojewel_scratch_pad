
f = open("LearnJuliaTest.jl","r")
content = readstring(f)
close(f)

f = open("test1.jl","r")
content = readstring(f)
close(f)


quoted_content = "quote " * content * " end"

eval(eval(parse(quoted_content)))


