;; Sequence Reductions - Medium
;; Write a function which behaves like reduce, but returns each intermediate value of the reduction.  Your function must accept either two or three arguments, and the return sequence must be lazy.
;; tags - seqs:core-functions
;; restricted - reductions
(ns offline-4clojure.p60
  (:use clojure.test)
  (:require [clojure.tools.trace :as t]))

;(def __ [f a b]
;  ;; First figure out how to implement reduce
;  ;; Next figure out how to conj intermediate values
;
;
;)


(t/deftrace new__
  ([f coll] (__ f [(first coll)] (rest coll)))
  ([f val coll]
   (let [_ (println val)
         ;; Takes care of case where val is not a collection
         result (if (coll? val) val (conj [] val))]
     (if (empty? coll)
       result
     (__ f (conj result (f (last result) (first coll))) (rest coll))))))


;(deftest main-test []
;  (are [soln] soln
;(= (take 5 (__ + (range))) [0 1 3 6 10])
;(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
;(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
;))


(fn __
  ([f coll]
   (lazy-seq
     (if-let [s (seq coll)]
       (__ f (first s) (rest s))
       (list (f)))))
  ([f init coll]
   (cons init
         (lazy-seq
           (when-let [s (seq coll)]
             (__ f (f init (first s)) (rest s)))))))

(defn __2
  ([f coll]
   (lazy-seq
     (if-let [s (seq coll)]
       (__ f (first s) (rest s))
       (list (f)))))
  ([f init coll]
   (cons init
         (lazy-seq
           (when-let [s (seq coll)]
             (__ f (f init (first s)) (rest s)))))))

(defn ^:dynamic clreductions
  "Returns a lazy seq of the intermediate values of the reduction (as
  per reduce) of coll by f, starting with init."
  ([f coll]
   (lazy-seq
     (if-let [s (seq coll)]
       (clreductions f (first s) (rest s))
       (list (f)))))
  ([f init coll]
   (if (reduced? init)
     (list @init)
     (cons init
           (lazy-seq
             (when-let [s (seq coll)]
               (clreductions f (f init (first s)) (rest s))))))))

;(cons 2 (cons 6 (cons 24 (reds * 120 ()))))
;
;(cons 2 (cons 6 (cons 24 '(120))))


(defn ^:dynamic fib [n]
  (if (< n 2)
    n
    (+ (fib (- n 1)) (fib (- n 2)))))

(comment
  (t/dotrace [clreductions] (clreductions * 2 [3 4 5]))
  )


(defn zred
  ([f coll]
   (lazy-seq
     (if-let [s (seq coll)]
       (zred f (first s) (rest s))
       (list (f)))))
  ([f val coll]
   (loop [f1 f
          c1 coll
          result (vector val)]
     (if (empty? c1)
       result
       (recur f1 (rest c1) (conj result (f1 (last result) (first c1))))))))

(defn zreduce
  ([f coll] (zreduce f (first coll) (rest coll)))
  ([f result coll]
   (let [_ (println result)]
     (if (empty? coll)
       result
       (zreduce f (f result (first coll)) (rest coll) )))))

(defn zreductions
  ([f coll] (zreductions f [(first coll)] (rest coll)))
  ([f result coll]
   (let [_ (println result)]
     (if (empty? coll)
       result
       (zreductions f (conj result (f (last result) (first coll))) (rest coll))))))


#_(def __ clreductions)

(deftest main-test []
                   (are [soln] soln
                               (= (take 5 (__ + (range))) [0 1 3 6 10])
                               (= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
                               (= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
                               ))