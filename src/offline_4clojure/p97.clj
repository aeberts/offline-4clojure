;; Pascal's Triangle - Easy
;; <a href="http://en.wikipedia.org/wiki/Pascal%27s_triangle">Pascal's triangle</a> is a triangle of numbers computed using the following rules:<br/></br>- The first row is 1.</br>- Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.<br/><br/>Write a function which returns the nth row of Pascal's Triangle.
;;
;;
;;
;; tags - 
;; restricted - 
(ns offline-4clojure.p97
  (:use [clojure.test]
        [clojure.tools.trace]))

(defn pasc [lastr num k]
  (let [n (- (dec num) k)
        d (inc k)]
    (* lastr (/ n d))))

(defn __ [num]
  (let [pasc (fn [lastr num k]
               (let [n (- (dec num) k)
                     d (inc k)]
                 (* lastr (/ n d))))]
    (loop [result [1] k 0]
      (if (or
            (= num 1)
            (= k (dec num)))
        result
        (recur (conj result (pasc (last result) num k)) (inc k))
        )
      )
    )
  )

(defn -main []
  (are [soln] soln
(= (__ 1) [1])
(= (map __ (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])
(= (__ 11)
   [1 10 45 120 210 252 210 120 45 10 1])
))

(defn breakpoint [in]
  (println in))

; _pcl's solution:
;(fn [i]
;  (reduce
;    #(conj %1 (* (last %1) (/ (- i %2) %2)))
;    [1] (range 1 i)))

;; C(n,0) = 1
;; C(n,k+1) = C(n,k) * (n - k) / (k + 1)

