lport = listen(11000)

while true
    aport = accept(lport)
    let aport=aport
        @schedule begin
            try
                println("Got a new connection")
                print(aport, "HTTP/1.1 200 OK\r\n\r\n")
                while true
                    println(aport, "Hello ", time())
                    println("Sent data")
                    sleep(1.0)
                end
            catch e
                println(e)
            end
        end
    end
end


"""
## Type this in a different repl

client = connect("localhost", 11000)

"""