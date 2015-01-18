;; Partition a Sequence - Medium
;; Write a function which returns a sequence of lists of x items each.  Lists of less than x items should not be returned.
;; tags - seqs:core-functions
;; restricted - partition:partition-all
(ns offline-4clojure.p54
  (:use clojure.test))

(def __

  (fn [c coll]
    (loop [a (list (take c coll)) rem (drop c coll)]
      (if (< (count rem) c )
        a
        (recur (concat a (list (take c rem))) (drop c rem)))))

)

(deftest main-test []
  (are [soln] soln
(= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
(= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
(= (__ 3 (range 8)) '((0 1 2) (3 4 5)))
))
