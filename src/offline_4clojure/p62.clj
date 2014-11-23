;; Re-implement Iterate - Easy
;; Given a side-effect free function f and an initial value x write a function which returns an infinite lazy sequence of x, (f x), (f (f x)), (f (f (f x))), etc.
;; tags - seqs:core-functions
;; restricted - iterate
(ns offline-4clojure.p62
  (:use clojure.test))

(def __
  ;; your solution here
  (fn reiter [f a]
    (cons a (lazy-seq (reiter f (f a))))))

;(defn iterate
;  "Returns a lazy sequence of x, (f x), (f (f x)) etc. f must be free of side-effects"
;  {:added "1.0"
;   :static true}
;  [f x] (cons x (lazy-seq (iterate f (f x)))))

;; Why is cons a necessary?? -> unroll this one.

(deftest main-test []
  (are [soln] soln
(= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])
(= (take 100 (__ inc 0)) (take 100 (range)))
(= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))
))