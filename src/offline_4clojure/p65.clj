;; Black Box Testing - Medium
;; Clojure has many sequence types, which act in subtly different ways. The core functions typically convert them into a uniform "sequence" type and work with them that way, but it can be important to understand the behavioral and performance differences so that you know which kind is appropriate for your application.<br /><br />Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it was given.<br />You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand their behavior.
;; tags - seqs:testing
;; restricted - class:type:Class:vector?:sequential?:list?:seq?:map?:set?:instance?:getClass
(ns offline-4clojure.p65
  (:use clojure.test))


;; conj adds elements to the front of lists
;; into adds elements to the front of lists
;; conj and into add elements to the back of vectors
;; peek gives the first item in a list
;; peek gives the last item in a vector
;; associative? is true for maps and vectors (false for everything else)
;; subvec works for vectors but throws exception for maps
;;
;; Sets also act as functions. e.g. #{\a \e \i \o \u}
;; read as: "the function that tests if it's argument is a vowel".
;; For example, to take all the characters in a string up to the first vowel, use this:
;; (take-while (complement #{\a\e\i\o\u}) "the-quick-brown-fox")
;; -> (\t \h)
;; Maps must have an even number of elements
;; If you try to add an item to a set that already contains the item the set will stay the same length
;; Can use "satisfies?"

(def __

  (fn [coll]
    (cond
      ;; Associative is true for vectors and maps, false for list and set
      ;; reversible? is true for vectors but false for maps
      (associative? coll) (if (reversible? coll) :vector :map)
      (= 2 (count (conj (conj (empty coll) :x ) :x))) :list
      :else :set
      )
    )
  )


(def __2

  (fn [coll]
    (cond
      ;; Associative is true for vectors and maps, false for list and set
      ;; reversible? is true for vectors but false for maps
      ;; contains? returns an exception for lists but not for sets
      (associative? coll) (if (reversible? coll) :vector :map)
      (try (contains? coll :foo)
           (catch Exception e (str (.getMessage e)))) :list
      :else :set
      )
    )
)

;; dwelte's solution
(def __3

  (fn [c]
  (cond
    (= (:d (conj c [:d :e])) :e) :map
    (= (:d (conj c :d)) :d) :set
    (= (last (into c [:d :e])) :e) :vector
    :else :list))
)
(deftest main-test []
  (are [soln] soln
(= :map (__ {:a 1, :b 2}))
(= :list (__ (range (rand-int 20))))
(= :vector (__ [1 2 3 4 5 6]))
(= :set (__ #{10 (rand-int 5)}))
(= [:map :set :vector :list] (map __ [{} #{} [] ()]))
))
