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
  (julia julia-file-name) )




; DONE How to execute ` julia file_to_jlir.jl scratch.jl > scratch.jlir`
;(julia {:in [file-to-jlir scratch-jl] :out (java.io.File. scratch-jlir) :verbose false})
; (sh-ll/proc "julia")
;(julia file-to-jlir scratch-jl {:out (java.io.File. scratch-jlir)})
;(echo "foo" {:out (java.io.File. "conch")})


;(defn jl-scratch-jlir []
;; (julia {:in (str "./src/clojewel/file_to_jlir.jl" " " scratch-jl ) :seq true :verbose true}))
;  (julia file-to-jlir-script scratch-jl {:out (java.io.File. scratch-jlir)}))




;(clojewel.utils/julia-eval-file-with-driver "./src/clojewel/file_to_jlir.jl" "./src/clojewel/scratch.jl" "./src/clojewel/scratch.jlir")
(defn julia-eval-file-with-driver
 "This function executes the form of >> julia driver.jl source.jl output.jl"
  [driver-file source-file output-file]
  (julia driver-file source-file {:out (java.io.File. output-file)}))



(defn save-to-file [file-name julia-expression]
  (spit file-name julia-expression))


(defn show-file-content [file-name]
  (cat file-name))


(defn sh-open-file-in-sublime [ file-name]
  (subl file-name))


