;; DONE : Need to understand how to get the classpath right.

(ns clojewel.core
  (:gen-class))
;  (require '[me.raynes.conch :refer [programs with-programs let-programs] :as sh]))


(use '[me.raynes.conch :refer [programs with-programs let-programs] :as sh])

;; Import and Check the julia version

(defn init-shell-functions []
  (do
    (sh/programs cat)
    (sh/programs julia)
    (julia "--version" {:seq true})))

(init-shell-functions)

; Clearly this can be converted into a Julia expression symbolically.

;;  (julia "-e" "println(1+1)")
;;  (def expr "eval(Expr(:call, :print, Expr(:call, :+, 1, 1)))")
;;  (julia "-e" expr)

(defn sh-julia-eval-string [julia-expression]
  (julia "-e" julia-expression))

;(sh-julia-eval-string "println(1+1)")
;(sh-julia-eval-string "eval(Expr(:call, :print, Expr(:call, :+, 1, 1)))")


;; Create a function that dumps the julia-string-expression into a julia_file and runs it with julia

(def scratch-jl "./src/clojewel/scratch.jl")
(def scratch-jlir "./src/clojewel/scratch.jlir")

(defn jl-save-string-to-scratch [julia-expression]
  (spit scratch-jl julia-expression))

;(jl-save-string-to-scratch  "println(1+1)" )

;(def expr "eval(Expr(:call, :print, Expr(:call, :+, 1, 1)))")
;(jl-save-string-to-scratch expr)


(defn sh-scratch-content []
  (cat scratch-jl))

(sh-scratch-content)

(defn jl-eval-scratch []
  (julia scratch-jl {:seq false}))

; DONE How to eval a julia source file from within clojure using the sh functionality
;(julia {:in scratch :seq true :verbose true})
;(julia scratch {:seq true})

(jl-eval-scratch)

(defn jl-scratch-jlir []
; (julia {:in (str "./src/clojewel/file_to_jlir.jl" " " scratch-jl ) :seq true :verbose true}))
  (julia {:in scratch-jl :out scratch-jlir :seq true :verbose false}))

(jl-scratch-jlir)





(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
