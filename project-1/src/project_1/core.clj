(ns project-1.core
;  (:require '[[clojure.java.shell :only [sh]]])
  (:gen-class))

;(use '[clojure.java.shell :only [sh]])

; This command is there to change the repl :ns
;  (ns project-1.core)


;(def julia-exec " /Applications/JuliaPro-0.5.2.1.app/Contents/Resources/julia/Contents/Resources/julia/bin/julia ")
;(sh julia-exec " -e  \" println(1 + 1) \" ")
;(def julia-eval " /Applications/JuliaPro-0.5.2.1.app/Contents/Resources/julia/Contents/Resources/julia/bin/julia -e \"println(1 + 1)\"")



(use '[me.raynes.conch :refer [programs with-programs let-programs] :as sh])

(sh/programs julia )
;(julia "--help" {:seq true})
(julia "-e" "println(1+1)")

;(julia "-e" "eval(Expr(:call, :println, (:call, :+, 1, 1)))")

; Clearly this can be converted into a Julia expression symbolically.
(def expr "eval(Expr(:call, :print, Expr(:call, :+, 1, 1)))")

(julia "-e" expr)





(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "ClojureJL"))
