;; DONE : Need to understand how to get the classpath right.

(ns clojewel.core
  (:gen-class))
;  (require '[me.raynes.conch :refer [programs with-programs let-programs] :as sh]))


(use '[me.raynes.conch :refer [programs with-programs let-programs] :as sh])
(use '[me.raynes.conch.low-level :as sh-ll])



;; Import and Check the julia version

(defn init-shell-functions []
  (do
    (sh/programs cat)
    (sh/programs echo)
    (sh/programs subl)
    (sh/programs julia)
;    (julia "--version" {:seq true})
    (sh/programs ls)))

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
(def file-to-jlir "./src/clojewel/file_to_jlir.jl")

(defn jl-save-string-to-scratch [julia-expression]
  (spit scratch-jl julia-expression))

(jl-save-string-to-scratch  "println(1+1)" )

;(def expr "eval(Expr(:call, :print, Expr(:call, :+, 1, 1)))")
;(jl-save-string-to-scratch expr)


(defn sh-file-content [file]
  (cat file))

(sh-file-content scratch-jl)


(defn jl-eval-scratch []
  (julia scratch-jl {:seq false}))

; DONE How to eval a julia source file from within clojure using the sh functionality
;(julia {:in scratch :seq true :verbose true})
;(julia scratch {:seq true})

(jl-eval-scratch)

; DONE How to execute ` julia file_to_jlir.jl scratch.jl > scratch.jlir`
;(julia {:in [file-to-jlir scratch-jl] :out (java.io.File. scratch-jlir) :verbose false})
; (sh-ll/proc "julia")

;(julia file-to-jlir scratch-jl {:out (java.io.File. scratch-jlir)})

;(echo "foo" {:out (java.io.File. "conch")})


(defn jl-scratch-jlir []
; (julia {:in (str "./src/clojewel/file_to_jlir.jl" " " scratch-jl ) :seq true :verbose true}))
  (julia file-to-jlir scratch-jl {:out (java.io.File. scratch-jlir)}))


(jl-scratch-jlir)

(sh-file-content scratch-jlir)


;(subl "--version")

(defn sh-open-scratch-files-in-sublime []
  (subl scratch-jlir scratch-jl))



(sh-open-scratch-files-in-sublime)



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
