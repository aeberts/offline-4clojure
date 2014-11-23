;; Re-implement Map - Easy
;; <p>Map is one of the core elements of a functional programming language. Given a function <code>f</code> and an input sequence <code>s</code>, return a lazy sequence of <code>(f x)</code> for each element <code>x</code> in <code>s</code>.
;; tags - core-seqs
;; restricted - map:map-indexed:mapcat:for
(ns offline-4clojure.p118
  (:use clojure.test)
  (:use clojure.tools.trace))

(def __
(fn [fun coll]
  (let [step (fn [f c]
               (when-let [s (seq c)]
                 (cons (f (first s)) (mapz f (rest s)))))]
    (lazy-seq (step fun coll))))

)
; dwelte's solution
;(fn nmap [f xs]
;  (if (empty? xs)
;    '()
;    (lazy-seq (cons (f (first xs)) (nmap f (rest xs))))))


;; My working solution on 4clojure (inspired by filter

;(fn mapz [fun coll]
;  (let [step (fn [f c]
;               (when-let [s (seq c)]
;                 (cons (f (first s)) (mapz f (rest s)))))]
;    (lazy-seq (step fun coll))))


(defn mapz
  "Applies func to each item in coll. Aka map"
  [fun coll]
  (let [step (fn [f c]
               (when-let [s (seq c)]
                 (cons (f (first s)) (mapz f (rest s)))))]
    (lazy-seq (step fun coll))))

(mapz inc [2 3 4 5 6])

(deftest main-test []
  (are [soln] soln
(= [3 4 5 6 7]
   (__ inc [2 3 4 5 6]))
(= (repeat 10 nil)
   (__ (fn [_] nil) (range 10)))
(= [1000000 1000001]
   (->> (__ inc (range))
        (drop (dec 1000000))
        (take 2)))
))
