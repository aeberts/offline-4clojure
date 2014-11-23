;; Greatest Common Divisor - Easy
;; Given two integers, write a function which
;;returns the greatest common divisor.
;; tags - 
;; restricted - 
(ns offline-4clojure.p66
  (:use clojure.test))

;Euclid's algorithm starts with a pair of positive integers, and forms a new pair that consists of the smaller number and the difference between the larger and smaller numbers. The process repeats until the numbers in the pair are equal. That number then is the greatest common divisor of the original pair of integers.

;; 10 15
;; 10 (15 - 10) -> 10 5
;; 5 (10 - 5) -> 5 5 => GDC

(def __

  (fn [x y]
    (loop [a x b y]
      (if (zero? b) a,
        (recur b (mod a b)))))

  )

(deftest main-test []
  (are [soln] soln
    (= (__ 2 4) 2)
    (= (__ 10 5) 5)
    (= (__ 5 7) 1)
    (= (__ 1023 858) 33)
    ))
