;; Set Intersection - Easy
;; Write a function which returns the intersection of two sets.  The intersection is the sub-set of items that each set has in common.
;; tags - set-theory
;; restricted - intersection
(ns offline-4clojure.p81
  (:use clojure.test))

(def __
  ;; your solution here

  (fn [s1 s2]
    (->> (into [] (concat s1 s2))
         (frequencies)
         (filter #(= 2 (last %)))
         (map #(first %))
         (into #{})
         ))
  )

;; silvero's solution:
;; #(set (filter % %2))
;;
;; wow!
;Sets are functions which means given:
;
;(def a #{0 1 2 3})
;(def b #{2 3 4 5})
;
;(a 1) => 1
;(a 2) => 2
;(a 5) => nil
;i.e. The set a will return the arg if the arg is contained in the set
;
;This is very useful with higher order fns:
;In the example below a is acting as the predicate function to filter.
;For each item in "b" return the item if it's in "a" -> the intersection of the two sets.
;
;(filter a b)
;=> (3 2)
;



(deftest main-test []
  (are [soln] soln
    (= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})
    (= (__ #{0 1 2} #{3 4 5}) #{})
    (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})
    ))


