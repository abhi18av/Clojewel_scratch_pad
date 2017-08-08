(ns clojewel.jlrepl
  (:gen-class))

(require '[clojewel.utils :as utils])


;; TODO Prefer the let form and move the variables closer to where they are used.

(defn julia-eval-scratch
  "This function evaluates the scratch file using << julia scratch.jl >>"
  []
  (utils/julia-eval-file "./src/clojewel/scratch.jl"))


; EXAMPLE
;(clojewel.utils/shell-show-file-content "./src/clojewel/scratch.jl")
(defn julia-save-string-to-scratch
  "This function saves the julia expressoin to the scratch file"
  [julia-expression]
  (utils/shell-save-to-file "./src/clojewel/scratch.jl" julia-expression))

(defn julia-show-s-expr
  "This function saves the julia expression to a file and then evals the file using the file convertor script and yields the s-expr"
  [julia-expression]
  (do
    (julia-save-string-to-scratch julia-expression)
    (utils/julia-eval-file-with-driver "./src/clojewel/file_to_jlir.jl" "./src/clojewel/scratch.jl" "./src/clojewel/scratch.jlir")
    (utils/shell-show-file-content "./src/clojewel/scratch.jlir")))

(defn julia-from-s-expr
  "This function saves the s-expression to a file and then evals the file using the script and yields the julia-expression."
  [expr])


(defn jl-scratch-jlir
; (julia {:in (str "./src/clojewel/file_to_jlir.jl" " " scratch-jl ) :seq true :verbose true}))
 [])

(defn shell-open-scratch-files-in-sublime
  [])

