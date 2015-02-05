;; Prime Numbers - Medium
;; Write a function which returns the first x
;;number of prime numbers.
;; tags - primes
;; restricted - 
(ns offline-4clojure.p67
  (:use clojure.test))


(def __

  (fn [x]
    (let [prime? (fn [n]
                   (let [div? (fn [div] (zero? (rem n div)))]
                     (cond (<= n 3) (>= n 2) (or (div? 2) (div? 3)) false
                           :else (loop [i 5]
                                   (cond (> (* i i) n) true
                                         (or (div? i) (div? (+ i 2))) false
                                         :else (recur (+ i 6)))))))]
      (loop [result [2 3] lst 4]
        (if (= x (count result))
          result
          (if (prime? lst)
            (recur (conj result lst) (inc lst))
            (recur result (inc lst))))
        )
      )
    )
  )

(deftest main-test []
  (are [soln] soln
(= (__ 2) [2 3])
(= (__ 5) [2 3 5 7 11])
(= (last (__ 100)) 541)
))


(def __2

  (fn [x]
    (let [prime? (fn [n]
                   (let [div? (fn [div] (zero? (rem n div)))]
                     (cond (<= n 3) (>= n 2) (or (div? 2) (div? 3)) false
                           :else (loop [i 5]
                                   (cond (> (* i i) n) true
                                         (or (div? i) (div? (+ i 2))) false
                                         :else (recur (+ i 6)))))))
          s (range 2 (+ 2 x))]
      (filter #(prime? %) s )
      )
    )

  )

;; From Clojure-docs reduce
;; Calculate primes until 1000

;(reduce
;  (fn [primes number]
;    (if (some zero? (map (partial mod number) primes))
;      primes
;      (conj primes number)))
;  [2]
;  (take 1000 (iterate inc 3)))

;jimm's solution:
;
;(fn [num]
;  (letfn [(prime? [n]
;                  (cond (< n 2) false
;                        (== n 2) true
;                        (even? n) false
;                        :else (let [max-divisor-check (/ (- (int (Math/sqrt n)) 2) 2)] ; subtract 2 because we start iterating at 3
;                                (not-any? #(zero? (unchecked-remainder n %)) (take max-divisor-check (iterate #(+ % 2) 3))))))]
;    (take num (filter prime? (range)))))
