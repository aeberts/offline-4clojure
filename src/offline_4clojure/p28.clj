;; Flatten a Sequence - Easy
;; Write a function which flattens a sequence.
;; tags - seqs:core-functions
;; restricted - flatten
(ns offline-4clojure.p28
  (:use clojure.test))

(def __
  (fn [coll]
    (filter (complement sequential?)
            (tree-seq sequential? seq coll))))

(deftest main-test []
  (are [soln] soln
    (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
    (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
    (= (__ '((((:a))))) '(:a))
    ))
