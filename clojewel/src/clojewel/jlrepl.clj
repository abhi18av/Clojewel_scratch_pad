(ns clojewel.jlrepl
  (:gen-class))

(require '[clojewel.utils :as utils])

;; TODO Prefer the let form and move the variables closer to where they are used.


;;;; SCRATCH RELATED FUNCTIONS

(defn shell-save-to-scratch
  "This function saves the julia expression to the scratch file"
  [julia-expression]
  (let [scratch-jl "./src/clojewel/scratch.jl"]
    (utils/shell-save-to-file scratch-jl julia-expression)))

(defn julia-create-scratch-jlir
  "Convert the scratch file to it's JLIR version and show"
  []
  (let [driver-file  "./src/clojewel/file_to_jlir.jl"
        source-file  "./src/clojewel/scratch.jl"
        output-file  "./src/clojewel/scratch.jlir"]
    (do
      (utils/julia-eval-file-with-driver driver-file source-file output-file))))

(defn shell-show-scratch
  "Show the \"normal julia syntax\" contents of scratch.jl file"
  []
  (let [file "./src/clojewel/scratch.jl"]
    (utils/shell-show-file-content file)))

(defn shell-show-scratch-jlir
  "Show the \"JLIR\" contents of scratch.jlir file"
  []
  (let [file "./src/clojewel/scratch.jlir"]
    (utils/shell-show-file-content file)))

(defn julia-eval-scratch
  "This function evaluates the scratch file using << julia scratch.jl >>"
  []
  (let [scratch-jl "./src/clojewel/scratch.jl"]
    (utils/julia-eval-file scratch-jl)))


;;;; IN MEMORY RELATED EXPRESSIONS

(defn shell-create-jl-from-jlir
"This function takes in the julia JLIR form and uses a driver script to print out the JL "
  [julia-expression]

  )
