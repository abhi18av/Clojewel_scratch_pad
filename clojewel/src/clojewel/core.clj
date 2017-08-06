;; TODO : Need to understand how to get the classpath right.

(ns clojewel.core
  (:gen-class))
;  (require '[me.raynes.conch :refer [programs with-programs let-programs] :as sh]))
;(use '[me.raynes.conch :refer [programs with-programs let-programs] :as sh])


;; Import and Check the julia version

(do
  (sh/programs julia)
  (julia "--version" {:seq true}))

; Clearly this can be converted into a Julia expression symbolically.

;;  (julia "-e" "println(1+1)")
;;  (def expr "eval(Expr(:call, :print, Expr(:call, :+, 1, 1)))")
;;  (julia "-e" expr)

(defn sh-julia-eval-string [julia-expression]
  (julia "-e" julia-expression))
(sh-julia-eval-string "println(1+1)")
(sh-julia-eval-string "eval(Expr(:call, :print, Expr(:call, :+, 1, 1)))")


;; Create a function that dumps the julia-string-expression into a julia_file and runs it with julia


(spit "./src/clojewel/scratch.jl" "Hello, Julia")



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
