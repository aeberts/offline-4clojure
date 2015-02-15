;; Anagram Finder - Medium
;; Write a function which finds all the anagrams in a vector of words.  A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y.  Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other.  Each sub-set should have at least two words.  Words without any anagrams should not be included in the result.
;; tags - 
;; restricted - 
(ns offline-4clojure.p77
  (:use clojure.test))

(defmacro dlet [bindings & body]
  `(let [~@(mapcat (fn [[n v]]
                     (if (or (vector? n) (map? n))
                       [n v]
                       [n v '_ `(println (name '~n) ":" ~v)]))
                   (partition 2 bindings))]
     ~@body))

(def __
;; Create a "normalized reference" of the word (i.e. word with letters ordered alphabetically)
;; Compare normalized reference with other normalized reference and keep ones that match in a set
  (fn [coll]
    (let [nr (fn [s] (->> s (seq) (sort)))
          nl (->> coll (map nr) (distinct))
          anagram? (fn [w1 w2] (and (not= w1 w2) (= (nr w1) (nr w2))))
          anagrams-for (fn [potentials word] (filter (partial anagram? word) potentials))
          sets (filter #(> (count %) 1) (map (partial anagrams-for coll) nl))]
      (into #{} (map set sets))))

)

(def __2

  (fn [w]
    (->> w
         (group-by sort)
         vals
         (filter #(> (count %) 1))
         (map set)
         set))

  )

(__2 ["meat" "mat" "team" "mate" "eat"])

(deftest main-test []
  (are [soln] soln
(= (__ ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})
(= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})
))


;all (for [x nl y coll :when (anagrams-for x y)] [x y])
;dedupe (->> all (map sort) (distinct))
;sets (map set dedupe)
;uni #{(apply clojure.set/union sets)}
;unique (->> all (map sort) (apply concat) (distinct))
;combine #((if (empty? (clojure.set/intersection % %2)) (vector % %2) (vector (clojure.set/intersection % %2))))