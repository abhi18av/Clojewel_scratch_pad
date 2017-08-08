(ns clojewel.utils
  (:gen-class))

(use '[me.raynes.conch :refer [programs with-programs let-programs] :as sh])

(use '[me.raynes.conch.low-level :as sh-ll])

;; Import and Check the julia version

(defn init-shell-functions []
  (do
    (sh/programs cat)
    (sh/programs echo)
    (sh/programs subl)
    (sh/programs julia)
    (sh/programs ls)))

(init-shell-functions)

(defn julia-eval-cli [julia-expression]
  (julia "-e" julia-expression))

(defn julia-eval-file [julia-file-name]
  (julia julia-file-name))


; EXAMPLE
;(clojewel.utils/julia-eval-file-with-driver "./src/clojewel/file_to_jlir.jl" "./src/clojewel/scratch.jl" "./src/clojewel/scratch.jlir")
(defn julia-eval-file-with-driver
  "This function executes the cli of the form => julia driver.jl source.jl output.jl"
  [driver-file source-file output-file]
  (julia driver-file source-file {:out (java.io.File. output-file)}))

; EXAMPLE
;(clojewel.utils/julia-eval-file-with-driver "./src/clojewel/eval_expr.jl" julia-expression)
(defn julia-eval-expr-and-print-cli
  "This function executes the cli of the form => julia driver.jl source.jl output.jl"
  [driver-file source-file julia-expression]
  (julia driver-file source-file julia-expression {:out true}))



(defn shell-save-to-file [file-name julia-expression]
  (spit file-name julia-expression))

(defn shell-show-file-content [file-name]
  (cat file-name))

(defn shell-open-file-in-sublime [file-name]
  (subl file-name))

