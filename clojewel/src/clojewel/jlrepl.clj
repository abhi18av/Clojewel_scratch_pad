(ns clojewel.jlrepl
  (:gen-class))
;  (require '[me.raynes.conch :refer [programs with-programs let-programs] :as sh]))

(require '[clojewel.utils :as utils])

(use '[me.raynes.conch :refer [programs with-programs let-programs] :as sh])

(defn jl-eval-string [julia-expression]
  (utils/julia-e julia-expression))




                                        ; DONE How to execute ` julia file_to_jlir.jl scratch.jl > scratch.jlir`
                                        ;(julia {:in [file-to-jlir scratch-jl] :out (java.io.File. scratch-jlir) :verbose false})
                                        ; (sh-ll/proc "julia")

                                        ;(julia file-to-jlir scratch-jl {:out (java.io.File. scratch-jlir)})

                                        ;(echo "foo" {:out (java.io.File. "conch")})


(defn jl-scratch-jlir []
                                        ; (julia {:in (str "./src/clojewel/file_to_jlir.jl" " " scratch-jl ) :seq true :verbose true}))
  (julia file-to-jlir-script scratch-jl {:out (java.io.File. scratch-jlir)}))


(defn jl-eval-scratch []
  )


;; Prefer the let form and move the variables closer to where they are used.

(defn jl-save-string-to-scratch [julia-expression])

(defn jl-show-s-expr
  "This function saves the julia expression to a file and then evals the file using the file convertor script and yields the s-expr"
  [julia-expression])

(defn jl-eval-expr
  "This function saves the julia expression to a file and then evals the file using the file convertor script and yields the evaluated form."
  [expr])

(defn jl-from-s-expr
  "This function saves the s-expression to a file and then evals the file using the script and yields the julia-expression."
  [expr])


;(defn jl-scratch-jlir []
;; (julia {:in (str "./src/clojewel/file_to_jlir.jl" " " scratch-jl ) :seq true :verbose true}))
;  (julia file-to-jlir-script scratch-jl {:out (java.io.File. scratch-jlir)}))

(defn sh-open-scratch-files-in-sublime [])

