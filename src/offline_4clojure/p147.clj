;; Pascal's Trapezoid - Easy
;; <p>Write a function that, for any given input vector of numbers, returns an infinite lazy sequence of vectors, where each next one is constructed from the previous following the rules used in <a href="http://en.wikipedia.org/wiki/Pascal's_triangle">Pascal's Triangle</a>. For example, for [3 1 2], the next row is [3 4 3 2].</p>
;;<p>Beware of arithmetic overflow! In clojure (since version 1.3 in 2011), if you use an arithmetic operator like + and the result is too large to fit into a 64-bit integer, an exception is thrown. You can use +' to indicate that you would rather overflow into Clojure's slower, arbitrary-precision bigint.</p>
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p147
  (:use clojure.test)
  (:use clojure.tools.trace))

; Basic solution:
;(map #( + (first %1) (second %1) ) (partition 2 1 [1 2 1]))

(def __                                                   ;Works on only (as->)

  (fn [v]
    (iterate
      (fn [coll]
        (let [pasc (fn [c] (->> c
                                (partition 2 1 )
                                (map #(+' (first %1) (second %1)))))]
          (conj (vec (conj (pasc coll) (first coll))) (last coll))
          ))
      v))
  )

;; dwelte's solutions
(fn [i]
  (iterate
    (fn [v]
      (let [v1 (concat v [0])
            v2 (concat [0] v)]
        (map + v1 v2))) i))

;; jbear's solution
;
; iterate #(concat [(first %)] (map +' % (rest %)) [(last %)])


(def B
  (fn [coll]
    (letfn [(pasc [c] (as-> coll c
                            (partition 2 1 c)
                            (map #( +' (first %1) (second %1)) c )
                            (conj c (first coll))
                            (conj (vec c) (last coll))))]
      (pasc coll)
      )))

;(take 5 (iterate A [1]))
(take 5 (__ [2 3 2]))
(take 5 (B [1]))

(take 5 (iterate #(conj % (inc (last %))) [1]))


(deftest main-test []
  (are [soln] soln
(= (second (__ [2 3 2])) [2 5 5 2])
(= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
(= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]])
(= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2]))))
))
