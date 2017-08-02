# project-1

The purpose of this sample project is to

- [x] have julia repl evaluate simple "-e" scripts.
- [] connect to Julia repl using network connection
- [] pass the forms constructed in Clojure repl to julia for evaluation 

```clojure
(jl/eval "(:call , :+ , 1, 1)")

;; => 2

```


- [] create simple JLIR expressions from clojure.

The following clojure code get transformed into Julia code.

```clojure

(jl println "Clojure!")

```



```julia
println("Clojure")

```

## Installation

Download from http://example.com/FIXME.

## Usage

FIXME: explanation

Run the project directly:

    $ boot run

Run the project's tests (they'll fail until you edit them):

    $ boot test

Build an uberjar from the project:

    $ boot build

Run the uberjar:

    $ java -jar target/project-1-0.1.0-SNAPSHOT-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
