(def project 'clojewel)
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          :source-paths   #{"test"}
          :dependencies   '[[org.clojure/clojure "1.9.0-alpha17"]
                            [adzerk/boot-test "RELEASE" :scope "test"]
                            ;; Matrix stuff
                            [net.mikera/core.matrix "0.60.3"]
                            [net.mikera/vectorz-clj "0.47.0"]

                            ;; Asynchronous stuff
                            [org.clojure/core.async "0.3.443"]

                            ;; Pattern matching in clojure
                            [org.clojure/core.match "0.3.0-alpha5"]



                            ;; Typed clojure
                            ;; TODO Creates an issue with cider's nrepl - probably transitive dependency
                            ;[org.clojure/core.typed "0.4.0"]

                            ;; TODO Middleware - might help to mitigate the cider error caused by core.typed
                            ;[org.clojure/tools.nrepl "0.2.12" :scope "test"]

                            ; Quickcheck
                            [org.clojure/test.check "0.10.0-alpha2"]

                            ;; MiniKanren
                            [org.clojure/core.logic "0.8.11"]

                            ;; Clojure reader in clojure
                            [org.clojure/tools.reader "1.0.5"]

                            ;; CLI functionality for clojure
                            [org.clojure/tools.cli "0.3.5"]

                            ;; Namespace resolution functionality in clojure
                            [org.clojure/tools.namespace "0.2.11"]

                            ;; Clojure AST to EDn
                            [org.clojure/tools.analyzer "0.6.9"]


                            ;; Combinatorics library
                            [org.clojure/math.combinatorics "0.1.4"]

                            ;; Dependency resolution
                            [org.clojure/tools.deps.alpha "0.1.29"]


                            ;; Shell library
                            [me.raynes/conch "0.8.0"]])

(task-options!
 aot {:namespace   #{'clojewel.core}}
 pom {:project     project
      :version     version
      :description "FIXME: write description"
      :url         "http://example/FIXME"
      :scm         {:url "https://github.com/yourname/clojewel"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}}
 jar {:main        'clojewel.core
      :file        (str "clojewel-" version "-standalone.jar")})

(deftask build
  "Build the project locally as a JAR."
  [d dir PATH #{str} "the set of directories to write to (target)."]
  (let [dir (if (seq dir) dir #{"target"})]
    (comp (aot) (pom) (uber) (jar) (target :dir dir))))

(deftask run
  "Run the project."
  [a args ARG [str] "the arguments for the application."]
  (require '[clojewel.core :as app])
  (apply (resolve 'app/-main) args))

(require '[adzerk.boot-test :refer [test]])
