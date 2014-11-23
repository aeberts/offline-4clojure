;; Duplicate a Sequence - Easy
;; Write a function which duplicates each element of a sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p32
  (:use clojure.test))

(def __
;; your solution here

  (fn [c] (mapcat #(list % %) c ))
)

(def a [1 2 3 4 5])

(deftest main-test []
  (are [soln] soln
(= (__ [1 2 3]) '(1 1 2 2 3 3))
(= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
))

(def a {:1 "Learn React" :2 "Create To Do List App" :3 "Profit"})


