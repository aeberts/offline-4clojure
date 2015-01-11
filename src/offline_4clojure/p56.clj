;; Find Distinct Items - Medium
;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
;; tags - seqs:core-functions
;; restricted - distinct
(ns offline-4clojure.p56
  (:use clojure.test)
  (:use clojure.tools.trace))

(defmacro dbg[x] `(let [x# ~x] (println '~x "=" x#) x#))

(def __

(fn [coll]
  (loop [c coll seen []]
    (if (empty? c)
      seen
      (if (some #{(first c)} seen)
        (recur (rest c) seen)
        (recur (rest c) (conj seen (first c)))))
    )
  )
)
;
;(defn foo [coll]
;  (loop [c coll seen []]
;    (if (empty? c)
;      seen
;      (if (contains? seen (first c))
;        (recur (rest c) seen)
;        (recur (rest c) (conj seen (first c)))))
;    )
;  )


;(def try2
;  (fn [coll]
;    (->> coll
;         (into #{})
;         (sort)
;         (vec))
;    )
;  )

;(__ [1 2 1 3 1 2 4])

(deftest main-test []
  (are [soln] soln
(= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
(= (__ [:a :a :b :b :c :c]) [:a :b :c])
(= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
(= (__ (range 50)) (range 50))
))
