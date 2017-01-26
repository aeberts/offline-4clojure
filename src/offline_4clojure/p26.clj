;; Fibonacci Sequence - Easy
;; Write a function which returns the first X fibonacci numbers.
;; tags - Fibonacci:seqs
;; restricted - 
(ns offline-4clojure.p26
  (:use clojure.test))

;(def __
;  (fn [n]
;    (map first
;      (take n
;        (iterate
;          (fn fib [coll]
;            [(last coll) (+ (first coll) (last coll))]) '(1 1))))))

(def __
  (fn [n]
    (let [lazyfib (iterate (fn [[a b]] [b (+ a b)]) '(1 1))
          vecseq (take n lazyfib)]
      (map first vecseq))))

(deftest main-test []
  (are [soln] soln
    (= (__ 3) '(1 1 2))
    (= (__ 6) '(1 1 2 3 5 8))
    (= (__ 8) '(1 1 2 3 5 8 13 21))
    ))
