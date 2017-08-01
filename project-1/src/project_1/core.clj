(ns project-1.core
  (:gen-class))

(use '[clojure.java.shell :only [sh]])



(def julia-exec "/Applications/JuliaPro-0.5.2.1.app/Contents/Resources/julia/Contents/Resources/julia/bin/julia ")


;(sh "julia --help")

;(sh julia-exec "-e  \" println(1 + 1) \" ")


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
