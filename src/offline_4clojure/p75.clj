;; Euler's Totient Function - Medium
;; Two numbers are coprime if their greatest common divisor equals 1.  Euler's totient function f(x) is defined as the number of positive integers less than x which are coprime to x.  The special case f(1) equals 1.  Write a function which calculates Euler's totient function.
;; tags - 
;; restricted - 
(ns offline-4clojure.p75
  (:use clojure.test)
  (:require [clojure.math.combinatorics :as combo]))

(def all-coprimes

  (fn [n]
    (if (= 1 n)
      1
      (letfn [(gdc [a b] (if (zero? b) a (recur b (mod a b))))
              (all-pairs [coll] (when-let [s (next coll)]
                      (lazy-cat (for [y s] [(first coll) y])
                                (all-pairs s))))]
        (->> (all-pairs (range 2 (inc n)))
            (filter #(= 1 (gdc (first %) (second %))) )
             ))))
)

(defn all-pairs [coll]
  (when-let [s (next coll)]
    (lazy-cat (for [y s] [(first coll) y])
                              (all-pairs s))))

(def __
  ;; my solution
  (fn [n]
    (if (= 1 n)
      1
      (letfn [(gdc [a b] (if (zero? b) a (recur b (mod a b))))]
       (count
         (for [x (range 1 n)
             y [n]
             :when (= 1 (gdc x n))]
         [x n]))))))

;; AustinTaylor's solution

(defn toitent [x]
  (if (= 1 x) 1
            (letfn [(gcd [a b] (last (filter #(and (zero? (mod a %)) (zero? (mod b %))) (range 1 (max a b)))))
                    (coprime? [a b] (= 1 (gcd a b)))]
              (count (filter (partial coprime? x) (range 1 x))))))


;; Dwelt's solution
(fn [x]
  (if (= x 1)
    1
    (let [gcd (fn gcd [a b] (if (= b 0) a (gcd b (mod a b))))]
      (count (filter #(= (gcd % x) 1) (range 1 x))))))

(deftest main-test []
  (are [soln] soln
(= (__ 1) 1)
(= (__ 10) (count '(1 3 7 9)) 4)
(= (__ 40) 16)
(= (__ 99) 60)
))
