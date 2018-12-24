;; Rotate Sequence - Medium
;; Write a function which can rotate a sequence in either direction.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p44
  (:use clojure.test))

(def __

  (fn [n coll]
    (cond
      ; n pos and less than (count coll)
      (and (< 0 n) (<= n (count coll))) (flatten (reverse (split-at n coll)))
      ; n negative and greater than (count coll)
      (and (< n 0) (> (* -1 n) (count coll))) (flatten (reverse (split-at (+ (count coll) (quot n (count coll))) coll)))
      ; n negative and less than (count coll)
      (< n 0) (flatten (reverse (split-at (+ (count coll) n) coll)))
      ; n pos and greater than (count coll)
      (> n (count coll)) (flatten (reverse (split-at (- n (count coll)) coll)))
      )
    )
  )

(deftest main-test []
  (are [soln] soln
    (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
    (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
    (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
    (= (__ 1 '(:a :b :c)) '(:b :c :a))
    (= (__ -4 '(:a :b :c)) '(:c :a :b))
    ))