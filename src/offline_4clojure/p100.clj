;; Least Common Multiple - Easy
;; Write a function which calculates the <a href="http://en.wikipedia.org/wiki/Least_common_multiple">least common multiple</a>.  Your function should accept a variable number of positive integers or ratios. 
;; tags - math
;; restricted - 
(ns offline-4clojure.p100
  (:use clojure.test))

(defn gcd
  [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn lcm
  [a b]
  (/ (* a b) (gcd a b)))

(defn prime-factors
  ([n] (prime-factors n 2))
  ([n pos]
    (cond (<= n 1) ()
          (zero? (rem n pos)) (cons pos (lazy-seq (prime-factors (/ n pos) pos)))
          :else (recur n (inc pos)))))


(lcm 3/5 (lcm 2 (lcm 7 5/7)))

(reduce lcm [7 5/7 2 3/5])

(def __

  (fn [& args]
    (let [gcd (fn [a b] (if (zero? b) a
                          (recur b (mod a b))))
          lcm (fn [a b] (/ (* a b) (gcd a b)))]
      (reduce lcm args)))

)


(deftest main-test []
  (are [soln] soln
(== (__ 2 3) 6)
(== (__ 5 3 7) 105)
(== (__ 1/3 2/5) 2)
(== (__ 3/4 1/6) 3/2)
(== (__ 7 5/7 2 3/5) 210)
))
