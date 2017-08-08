(ns clojewel.core
  (:gen-class))

;(require '[clojewel.utils :as utils])

(require '[clojewel.jlrepl :as jlrepl])


(jlrepl/jl-eval-scratch)

(jlrepl/jl-scratch-jlir)

(jlrepl/sh-file-content scratch-jlir)

(jlrepl/sh-open-scratch-files-in-sublime)

(jlrepl/jl-eval-string "eval(Expr(:call, :print, Expr(:call, :+, 1, 1)))")

(jlrepl/jl-show-s-expr "println(\"Hello, Julia! \") ")

(jlrepl/jl-show-s-expr "function add9( x) x + 9 end ")

(jlrepl/jl-eval-expr "Expr(:call, :+, 1, 1)")

(jlrepl/jl-eval-expr "function add9(x) x + 9 end ; add9(9)")

(jlrepl/jl-from-s-expr "(:call, :+, 1, 1)")



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Clojewel - CLJ!"))
