(ns clojewel.jlrepl
  (:gen-class))

(require '[clojewel.utils :as utils])


(defn julia-eval-string [julia-expression]
  (utils/julia-eval-cli julia-expression))



(defn julia-eval-scratch
  [])


;; Prefer the let form and move the variables closer to where they are used.

(defn julia-save-string-to-scratch [julia-expression])

(defn julia-show-s-expr
  "This function saves the julia expression to a file and then evals the file using the file convertor script and yields the s-expr"
  [julia-expression])

(defn julia-eval-expr
  "This function saves the julia expression to a file and then evals the file using the file convertor script and yields the evaluated form."
  [expr])

(defn julia-from-s-expr
  "This function saves the s-expression to a file and then evals the file using the script and yields the julia-expression."
  [expr])


(defn jl-scratch-jlir
; (julia {:in (str "./src/clojewel/file_to_jlir.jl" " " scratch-jl ) :seq true :verbose true}))
 [])

(defn shell-open-scratch-files-in-sublime [])

