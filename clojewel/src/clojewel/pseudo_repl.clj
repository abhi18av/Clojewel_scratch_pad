(ns clojewel.pseudo_repl
  (:gen-class))
                                        ;
                                        ;(require '[me.raynes.conch :refer [programs with-programs let-programs] :as sh]))


(use '[me.raynes.conch :refer [programs with-programs let-programs] :as sh])
                                        ;(use '[me.raynes.conch.low-level :as sh-ll])


;; Use this to actually move to the file's namespace
                                        ;  (ns clojewel.core)


;; Import and Check the julia version

(defn init-shell-functions []
  (do
    (sh/programs cat)
    (sh/programs echo)
    (sh/programs subl)
    (sh/programs julia)
                                        ;    (julia "--version" {:seq true})
    (sh/programs ls)))

