;; Analyze a Tic-Tac-Toe Board - Hard
;; A <a href="http://en.wikipedia.org/wiki/Tic-tac-toe">tic-tac-toe</a> board is represented by a two dimensional vector. X is represented by :x, O is represented by :o, and empty is represented by :e.  A player wins by placing three Xs or three Os in a horizontal, vertical, or diagonal row.  Write a function which analyzes a tic-tac-toe board and returns :x if X has won, :o if O has won, and nil if neither player has won.
;; tags - game
;; restricted - 
(ns offline-4clojure.p73
  (:use clojure.test))

(def __

  (fn [v]
    (let [r0 (v 0)
          r1 (v 1)
          r2 (v 2)
          c0 (vector (r0 0) (r1 0) (r2 0))
          c1 (vector (r0 1) (r1 1) (r2 1))
          c2 (vector (r0 2) (r1 2) (r2 2))
          d1 (vector (r0 0) (r1 1) (r2 2))
          d2 (vector (r2 0) (r1 1) (r0 2))
          ev [r0 r1 r2 c0 c1 c2 d1 d2]
          all-same? (fn [v] (apply = v))
          all-empty? (fn [v] (every? (fn [i] (= :e i)) v))
          fv (filter (fn [v] (and (all-same? v) (not (all-empty? v)))) ev)
          ]
      (first (first (seq fv)))
      )
    )

)


(deftest main-test []
  (are [soln] soln
(= nil (__ [[:e :e :e]
            [:e :e :e]
            [:e :e :e]]))
(= :x (__ [[:x :e :o]
           [:x :e :e]
           [:x :e :o]]))
(= :o (__ [[:e :x :e]
           [:o :o :o]
           [:x :e :x]]))
(= nil (__ [[:x :e :o]
            [:x :x :e]
            [:o :x :o]]))
(= :x (__ [[:x :e :e]
           [:o :x :e]
           [:o :e :x]]))
(= :o (__ [[:x :e :o]
           [:x :o :e]
           [:o :e :x]]))
(= nil (__ [[:x :o :x]
            [:x :o :x]
            [:o :x :o]]))
))
