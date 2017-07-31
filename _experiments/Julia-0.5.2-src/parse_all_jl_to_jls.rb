files = Dir['*.jl']

for f in files

	oldFile = f.split(".")[0]
	newFile = oldFile + ".jls"

	jl_exec = "/Applications/JuliaPro-0.5.2.1.app/Contents/Resources/julia/Contents/Resources/julia/bin/julia "
	cmd = jl_exec + " jl_file_to_s_expr.jl " + f + " > " + newFile
	system(cmd)

end
