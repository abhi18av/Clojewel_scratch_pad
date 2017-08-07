(ns clojewel.core
  (:gen-class))

(require '[clojewel.pseudo_repl :as pseudo])


(def jl-source-file "./src/clojewel/learnJuliaTest.jl")
;; Read julia source file as a string
(def jl-source-file-content (slurp jl-source-file) )


(pseudo/sh-julia-eval-string "println(1+1)")

(pseudo/sh-julia-eval-string "eval(Expr(:call, :print, Expr(:call, :+, 1, 1)))")

(pseudo/jl-show-s-expr "println(\"Hello, Julia! \") ")

(pseudo/jl-show-s-expr "function add9( x) x + 9 end ")

(pseudo/jl-eval-expr "Expr(:call, :+, 1, 1)")

(pseudo/jl-eval-expr "function add9( x) x + 9 end ; add9(9)")

(pseudo/jl-from-s-expr "(:call, :+, 1, 1)")

(pseudo/jl-from-s-expr "(:call, :+, 1, 1)")

;(pseudo/jl-expr-from-s-expr "(:call, :(==), \"1 + 2 = 3\", (:string, \"1 + 2 = \", (:call, :+, 1, 2)))" )

(pseudo/jl-eval-scratch)

(pseudo/jl-scratch-jlir)

(pseudo/sh-file-content scratch-jlir)

(pseudo/sh-open-scratch-files-in-sublime)



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
