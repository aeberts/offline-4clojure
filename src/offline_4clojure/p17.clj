;; Sequences: map - Elementary
;; The map function takes two arguments: a function (f) and a sequence (s).  Map returns a new sequence consisting of the result of applying f to each item of s.  Do not confuse the map function with the map data structure.
;; tags - 
;; restricted - 
(ns offline-4clojure.p17
  (:use clojure.test))

(def __
  '(6 7 8)
  )

(deftest main-test []
                   (are [soln] soln
                               (= __ (map #(+ % 5) '(1 2 3)))
                               ))
