;; Intro to Maps - Elementary
;; Maps store key-value pairs.  Both maps and keywords can be used as lookup functions. Commas can be used to make maps more readable, but they are not required.
;; tags -
;; restricted -
(ns offline-4clojure.p10
  (:use clojure.test))

(def __
  20
)

(deftest main-test []
  (are [soln] soln
(= __ ((hash-map :a 10, :b 20, :c 30) :b))
(= __ (:b {:a 10, :b 20, :c 30}))
))

