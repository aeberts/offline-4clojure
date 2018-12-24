;; Factorial Fun - Easy
;; Write a function which calculates factorials.
;; tags - math
;; restricted - 
(ns offline-4clojure.p42
  (:use clojure.test))

(def __

  (fn [x]
    (reduce * (range 1 (+ 1 x)))
    )
)

(deftest main-test []
  (are [soln] soln
(= (__ 1) 1)
(= (__ 3) 6)
(= (__ 5) 120)
(= (__ 8) 40320)
))
