;; Power Set - Medium
;; Write a function which generates the <a href="http://en.wikipedia.org/wiki/Power_set">power set</a> of a given set.  The power set of a set x is the set of all subsets of x, including the empty set and x itself.
;; tags - set-theory
;; restricted - 
(ns offline-4clojure.p85
  (:use clojure.test)
  (:require [clojure.math.combinatorics]
            [clojure.set]
            [clojure.tools.trace :as trace]))

;; Hints if necessary: http://stackoverflow.com/questions/20914026/all-subsets-of-a-set-in-clojure

;; From jafingerhut on 4Clojure
;; If we have determined the power set p for a set s so far, and we
;; now want to calculate the power set for a set containing s and one
;; more element x, then:

;; 1. every set in p is in that power set (none of them contain
;; element x), and

;; 2. every one of those sets with element x added to it are also in
;; the power set.

(defn jafingerhut [s]
  (reduce (fn [power-set x]
            (into power-set (map #(conj % x) power-set)))
          #{#{}} s))


(defn powerset [s]
  (clojure.math.combinatorics/subsets s)
  )

(trace/deftrace tcomb [k l]
  (if (= 1 k) (map vector l)
              (apply concat
                     (map-indexed
                       #(map (fn [x] (conj x %2))
                             (tcomb (dec k) (drop (inc %1) l)))
                       l))))

(trace/deftrace tcomb1 [k l]
                (if (= 1 k) (map vector l)
                            (map-indexed
                              #(map (fn [x] (conj x %2))
                                    (tcomb1 (dec k) (drop (inc %1) l)))
                              l)))

(defn comb [k l]
  (if (= 1 k) (map vector l)
              (apply concat
                     (map-indexed
                       #(map (fn [x] (conj x %2))
                             (comb (dec k) (drop (inc %1) l)))
                       l))))

(tcomb1 2 [:a :b :c])

(tcomb1 3 [:A :B :C :D])

(comb 3 [:A :B :C :D :E :F])

(defn self [x y]
  [x y])

(def for1
  (for [c3 [:D :C :B :A]
      c2 [:E :D :C]
      c1 [:F :E]]
  [c3 c2 c1]))

(def for2
  (for [c3 [:D :C :B :A]
      c2 [:E :D :C]
      c1 [:F :E]]
  [c1 c2 c3]))

(defn for3
  [items]
  (for [i items
        j items
        :when (< i j)]
    [i j]))

(for3 [1 2 3 4])


;Doesn't compile
;(trace/deftrace zcomb1 [k l]
;  (for [r (reverse l)
;        c3 (drop (- k 1) r)
;        c2 (drop 1 c3)
;        :while (< (.indexOf c2) (- 1 (.indexOf c3)))
;        c1 r
;        :while (< (.indexOf c1) (- 1 (.indexOf c2)))
;        ]
;    [c3 c2 c1]))
;
;(zcomb1 2 [:A :B :C :D])

(trace/deftrace zcomb [k l]
  (for [c l
        cnext (if (= 1 k) (map vector l)
                          (zcomb (dec k) (rest l)))]
    [c cnext]))


(defn all-subsets [s]
  (letfn [(comb [k l]
            (if (= 1 k) (map vector l)
                        (apply concat
                               (map-indexed
                                 #(map (fn [x] (conj x %2))
                                       (comb (dec k) (drop (inc %1) l)))
                                 l)))) ]
    (apply concat
         (for [x (range (inc (count s)))]
           (map #(into #{} %) (comb x s))))))

(all-subsets #{1 :a})


(defn all-subsets2 [s]
  (letfn [(comb [k l]
            (if (= 1 k) (map vector l)
                        (apply concat
                               (map-indexed
                                 #(map (fn [x] (conj x %2))
                                       (comb (dec k) (drop (inc %1) l)))
                                 l))))]
    (apply concat
           (for [x (range (inc (count s)))]
             (map #(into #{} %) (comb x s))))))


(into (set (all-subsets2 #{1 2 3})) #{})
(all-subsets #{})

(defn all-subsets3 [s]
  (letfn [(comb [k l]
            (if (= 1 k) (map vector l)
                        (apply concat
                               (map-indexed
                                 #(map (fn [x] (conj x %2))
                                       (comb (dec k) (drop (inc %1) l)))
                                 l))))]
    (conj #{#{}}
          (apply concat
                 (for [x (range (inc (count s)))]
                   (map #(into #{} %) (comb x s)))))))


;; The most elegant solution
;;

(defn power [s]
  (loop [[f & r] (seq s)
         p '(())]
    (if f
      (recur r (concat p (map (partial cons f) p)))
      p)))

(defn power-set [s] (set (map set (power s))))

;; Solution I posted to 4Clojure:

(defn __ [s]
  (letfn [(pow [s]
            (loop [[f & r] (seq s)
                   p '(())]
              (if f
                (recur r (concat p (map (partial cons f) p)))
                p)))]
    (set (map set (pow s)))))

(power #{:a :b :c})

;; Works here but not on 4Clojure
;; Question is: how to implmentent subsets?

;(fn [s]
;  (set (map set (clojure.math.combinatorics/subsets s))))

(set (map set (clojure.math.combinatorics/subsets #{1 2 3})))

(deftest main-test []
  (are [soln] soln
(= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
(= (__ #{}) #{#{}})
(= (__ #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
(= (count (__ (into #{} (range 10)))) 1024)
))
