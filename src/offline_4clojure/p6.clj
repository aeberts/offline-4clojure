;; Intro to Vectors - Elementary
;; Vectors can be constructed several ways.  You can compare them with lists.
;; tags -
;; restricted -
(ns offline-4clojure.p6
  (:use clojure.test))

(def __
;; your solution here
)

(deftest main-test []
  (are [soln] soln
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
))
