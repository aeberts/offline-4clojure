;; Word Sorting - Medium
;; Write a function that splits a sentence up into a sorted list of words.  Capitalization should not affect sort order and punctuation should be ignored.
;; tags - sorting
;; restricted - 
(ns offline-4clojure.p70
  (:use clojure.test))

(def __

  (fn [s]
    (let [ws (sort-by clojure.string/upper-case (clojure.string/split s #"\s"))
          cws (map (fn [w] (apply str (remove #(not (Character/isLetter %)) w ))) ws )]
      (vec cws)))

)

; jbear's solution:
; #(->> % (re-seq #"[A-Za-z]+") (sort-by (fn [s] (.toLowerCase s))))

(deftest main-test []
  (are [soln] soln
(= (__  "Have a nice day.")
   ["a" "day" "Have" "nice"])
(= (__  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])
(= (__  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])
))
