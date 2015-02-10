;; Filter Perfect Squares - Medium
;; Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the numbers which are perfect squares.
;; tags - 
;; restricted - 
(ns offline-4clojure.p74
  (:use clojure.test)
  (:use clojure.tools.trace))

(defmacro dbg[x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))

(defmacro dlet [bindings & body]
  `(let [~@(mapcat (fn [[n v]]
                     (if (or (vector? n) (map? n))
                       [n v]
                       [n v '_ `(println (name '~n) ":" ~v)]))
                   (partition 2 bindings))]
     ~@body))

(def __
  ;; Translate strings to seq ints
  ;; filter perfect squares
  ;; translate back to ints

  (fn [s]
    (let [split-string (clojure.string/split s #",")
          strToint (map #(Integer/valueOf %) split-string)
          root #(Math/sqrt %)
          perfect-root? (fn [i] (= i (int (Math/pow (int (+ 0.5 (root i))) 2 ))))]
      (->> strToint
        (filter perfect-root?)
        (map str)
        (interpose ",")
        (apply str))
      )
     )

)

(deftest main-test []
  (are [soln] soln
(= (__ "4,5,6,7,8,9") "4,9")
(= (__ "15,16,25,36,37") "16,25,36")
))
