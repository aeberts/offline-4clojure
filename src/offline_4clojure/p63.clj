;; Group a Sequence - Easy
;; Given a function f and a sequence s, write a function which returns a map.  The keys should be the values of f applied to each item in s.  The value at each key should be a vector of corresponding items in the order they appear in s.
;; tags - core-functions
;; restricted - group-by
(ns offline-4clojure.p63
  (:use clojure.test))

(def __

  (fn [f coll]
    (let [ordered-set (map vector (map f coll) coll)
          unique-keys (into #{} (map first ordered-set))
          values-for-key (fn [k coll] (map last (filter #(= (first %) k ) coll )))]
      (into {}
        (for [i unique-keys]
          [i (values-for-key i ordered-set)])
      )
    )
  )
)

; silverio's solution
; fn is %
; coll is %2
; #(->> %2
;      (sort-by %)
;      (partition-by %)
;      (mapcat (fn [v] [(% (first v)) v]))
;      (apply assoc {}))

( #(->> %2
        (sort-by %))
  #(> % 5) [3 1 6 8])

(deftest main-test []
  (are [soln] soln
    (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
    (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
       {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
    (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
       {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
    ))


(defn values-for-key [k coll]
  (map last (filter #(= (first %) k ) coll )))

;(t2 #(> % 5) [1 3 6 8])
; (into {} '(i (values-for-key i ordered-set)))
; [i (values-for-key i ordered-set)]
; [i (values-for-key i ordered-set)]

;
; ordered-set
; (map vector (map f coll) coll) =>
;[[false 1] [false 3] [true 6] [true 8]]
;
;(values-for-key false #{[false 1] [false 3] [true 6] [true 8]})
; => (1, 3)
;

;([false (1 3)] [true (6 8)])
;{false [1 3], true [6 8]}
