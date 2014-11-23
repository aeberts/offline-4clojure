;; Infix Calculator - Easy
;; Your friend Joe is always whining about Lisps using the prefix notation for math. Show him how you could easily write a function that does math using the infix notation. Is your favorite language that flexible, Joe?
;;
;;Write a function that accepts a variable length mathematical expression consisting of numbers and the operations +, -, *, and /. Assume a simple calculator that does not do precedence and instead just calculates left to right.
;; tags - higher-order-functions:math
;; restricted - 
(ns offline-4clojure.p135
  (:use clojure.test clojure.tools.trace))

(defmacro d[x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))

(def __
  (fn [& args]
    (loop [col (rest args) result (first args)]
      (if (seq col)
        (recur (rest (rest col)) ((first col) result (first (rest col))))
        result)
      )
    )
  )

; jbear's solution
; (fn calc [init & exp]
;  (reduce #(let [[f n] %2] (f %1 n)) init (partition 2 exp)))

(deftest main-test []
  (are [soln] soln
(= 7  (__ 2 + 5))
(= 42 (__ 38 + 48 - 2 / 2))
(= 8  (__ 10 / 2 - 1 * 2))
(= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))
))
