;; Intro to Functions - Elementary
;; Clojure has many different ways to create functions.
;; tags - 
;; restricted - 
(ns offline-4clojure.p14
  (:use clojure.test))

(def __

8

)

(deftest main-test []
  (are [soln] soln
(= __ ((fn add-five [x] (+ x 5)) 3))
(= __ ((fn [x] (+ x 5)) 3))
(= __ (#(+ % 5) 3))
(= __ ((partial + 5) 3))
))
