;; Intro to Sequences - Elementary
;; All Clojure collections support sequencing.  You can operate on sequences with functions like first, second, and last.
;; tags -
;; restricted -
(ns offline-4clojure.p12
  (:use clojure.test))

(def __
 3
)

(deftest main-test []
  (are [soln] soln
(= __ (first '(3 2 1)))
(= __ (second [2 3 4]))
(= __ (last (list 1 2 3)))
))
