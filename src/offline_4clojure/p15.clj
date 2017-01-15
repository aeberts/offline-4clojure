;; Double Down - Elementary
;; Write a function which doubles a number.
;; tags - 
;; restricted - 
(ns offline-4clojure.p15
  (:use clojure.test))

(def __
(fn [x]
  (* 2 x))
)

(deftest main-test []
  (are [soln] soln
(= (__ 2) 4)
(= (__ 3) 6)
(= (__ 11) 22)
(= (__ 7) 14)
))
