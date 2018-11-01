;; Drop Every Nth Item - Easy
;; Write a function which drops every Nth item from a sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p41
  (:use clojure.test))

; Solution using "traditional" keep-indexed (could also use map-indexed)

(comment
  (def __
    (fn [coll n]
      (keep-indexed
        (fn [idx itm]
          (if (not (= 0 (mod (inc idx) n)))
            itm))
        coll))))

; Sexier solution using partition-all:

(def __
  (fn [coll n]
    (apply concat (partition-all (dec n) n coll))))

(deftest main-test []
  (are [soln] soln
    (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
    (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
    (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])
    ))
