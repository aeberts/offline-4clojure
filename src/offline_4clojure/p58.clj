;; Function Composition - Medium
;; Write a function which allows you to create function compositions.  The parameter list should take a variable number of functions, and create a function applies them from right-to-left.
;; tags - higher-order-functions:core-functions
;; restricted - comp
(ns offline-4clojure.p58
  (:use clojure.test)
  (:use clojure.tools.trace))

(defmacro dbg [body]
  `(let [x# ~body]
     (println "dbg:" '~body "=" x#)
     x#))

(defmacro dlet [bindings & body]
  `(let [~@(mapcat (fn [[n v]]
                     (if (or (vector? n) (map? n))
                       [n v]
                       [n v '_ `(println (name '~n) ":" ~v)]))
                   (partition 2 bindings))]
     ~@body))

(def __

  (fn [& fargs]
    (let [fns (vec (reverse fargs))]
      (fn [& args]
        (loop [fs (next fns) acc (apply (first fns) args)]
          (if fs
            (recur (next fs) ((first fs) acc))
            acc)))))

  )


(deftest main-test []
  (are [soln] soln
(= [3 2 1] ((__ rest reverse) [1 2 3 4]))
(= 5 ((__ (partial + 3) second) [1 2 3 4]))
(= true ((__ zero? #(mod % 8) +) 3 5 7 9))
(= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
))


;(fn [& args]
;  (let [fns (vec (reverse args))]
;    (fn [arg]
;      (loop [fs fns a arg]
;        (if (empty? fs)
;          a
;          (recur (rest fs) ((first fn) a))
;          )
;        )
;      )
;    )
;  )