;; Juxtaposition - Medium
;; Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence containing the result of applying each function left-to-right to the argument list.
;; tags - higher-order-functions:core-functions
;; restricted - juxt
(ns offline-4clojure.p59
  (:use clojure.test))

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

(defn foo [& x]
  {:x x :type (type (list x))}
  )

;amcnamara's solution:
;
;(fn [& f]
;  (fn [& a]
;    (map #(apply % a) f)))




(def __

(fn [& fns]
  (let [fs (list* fns)]
    (fn [& args]
      (reduce #(conj %1 (apply %2 args)) [] fs))))

  )

;(fn [& fargs]
;  (let [fns fargs]
;    (fn [& args]
;      (loop [fs (rest fns) acc (dbg (into [] (apply (first fns) args)))]
;        (if fs
;          (recur (dbg (rest fs)) (dbg (conj acc (apply (first fs) args))))
;          acc)))))


(deftest main-test []
  (are [soln] soln
(= [21 6 1] ((__ + max min) 2 3 5 1 6 4))
(= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))
(= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))
))

;dbg: ((__ + max min) 2 3 5 1 6 4 )
;dbg: fns = (+ max min)
;dbg: fs = '(+ max min)
;dbg: args = 2 3 5 1 6 4
