;; Intro to Destructuring 2 - Easy
;; Sequential destructuring allows you to bind symbols to parts of sequential things (vectors, lists, seqs, etc.): <a href="http://clojure.org/special_forms#Special Forms--(let [bindings* ] exprs*)">(let [bindings* ] exprs*)</a>
;;
;;Complete the bindings so all let-parts evaluate to 3.
;; tags - Destructuring
;; restricted - 
(ns offline-4clojure.p173
  (:use clojure.test))

(def __
;; your solution here

  )

;"op arg" (or similar) is the answer - it just doesn't work with the tests.

(deftest main-test []
  (are [soln] soln
(= 3
  (let [[__] [+ (range 3)]] (apply __))
  (let [[[__] b] [[+ 1] 2]] (__ b))
  (let [[__] [inc 2]] (__)))
))


;Binding Forms (Destructuring)
;Clojure supports abstract structural binding, often called destructuring, in let binding lists, fn parameter lists, and any macro that expands into a let or fn. The basic idea is that a binding-form can be a data structure literal containing symbols that get bound to the respective parts of the init-expr. The binding is abstract in that a vector literal can bind to anything that is sequential, while a map literal can bind to anything that is associative.
;Vector binding destructuring
;
;Vector binding-exprs allow you to bind names to parts of sequential things (not just vectors), like vectors, lists, seqs, strings, arrays, and anything that supports nth. The basic sequential form is a vector of binding-forms, which will be bound to successive elements from the init-expr, looked up via nth. In addition, and optionally, & followed by a binding-forms will cause that binding-form to be bound to the remainder of the sequence, i.e. that part not yet bound, looked up via nthnext.
;
; Finally, also optional, :as followed by a symbol will cause that symbol to be bound to the entire init-expr:
; (let [[a b c & d :as e] [1 2 3 4 5 6 7]]
;  [a b c d e])
