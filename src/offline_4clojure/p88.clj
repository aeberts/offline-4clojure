;; Symmetric Difference - Easy
;; Write a function which returns the symmetric difference of two sets.  The symmetric difference is the set of items belonging to one but not both of the two sets.
;; tags - set-theory
;; restricted - 
(ns offline-4clojure.p88
  (:use clojure.test))

(def __
;; your solution here
  (fn [s1 s2]
    (->>
      (-> []
        (into s1)
        (into s2)
        (frequencies))
      (filter #( = 1 (val %))  )
      (keys)
      (sort)
      (set))
   )
)
; amcnamara's solution:
; #(into (clojure.set/difference % %2)
;       (clojure.set/difference %2 %))

(deftest main-test []
  (are [soln] soln
(= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
(= (__ #{:a :b :c} #{}) #{:a :b :c})
(= (__ #{} #{4 5 6}) #{4 5 6})
(= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})
))

(def s1 #{1 3 5 7})
(def s2 #{1 2 3 4 5 6})
