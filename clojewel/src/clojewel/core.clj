(ns clojewel.core
  (:gen-class))

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
  (println "Hello, World!"))
