;; To Tree, or not to Tree - Easy
;; Write a predicate which checks whether or not a given sequence represents a <a href="http://en.wikipedia.org/wiki/Binary_tree">binary tree</a>.  Each node in the tree must have a value, a left child, and a right child.
;; tags - trees
;; restricted - 
(ns offline-4clojure.p95
  (:use clojure.test)
  (:use clojure.tools.trace)
  (:use clojure.walk))

(deftrace __

  (fn is-btree? [coll]
    (let [is-tree-or-nil? #(or (nil? %) (= 3 (count %)))
          node (first coll)
          subtl (first (rest coll))
          subtr (rest (rest coll))
          result true]
      (if (and (not (nil? node))
               (is-tree-or-nil? subtl)
               (is-tree-or-nil? subtr)))
      )
    )
)


(deftrace __

          (fn is-tree? [coll]
            (let [value (first coll)
                  left (first (rest coll))
                  right (rest (rest coll))
                  is-leaf? #((and (not (nil? value))
                                  (not (seq? value))
                                  (nil? right) (nil? left)))]
              (if (is-leaf? coll) true
                (do
                  (if (and (seq? left) (not (nil? left))) (is-tree? left) false)
                  (if (and (seq? right) (not (nil? right))) (is-tree? left) false)))))


          )


(deftest main-test []
  (are [soln] soln
(= (__ '(:a (:b nil nil) nil))
   true)
(= (__ '(:a (:b nil nil)))
   false)
(= (__ [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)
(= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)
(= (__ [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)
(= (__ [1 [2 [3 [4 false nil] nil] nil] nil])
   false)
(= (__ '(:a nil ()))
   false)

))

(def tree [1 [2 [4 [7]] [5]] [3 [6 [8] [9]]]])
(def t1true '(:a (:b nil nil)))
(def t2true [1 nil [2 [3 nil nil] [4 nil nil]]])
(def t3false [1 [2 nil nil] [3 nil nil] [4 nil nil]])
(def t4false [1 [2 [3 [4 false nil] nil] nil] nil])
(def t5false [2 [3 [4 false nil] nil] nil])
(def t1 [3 nil nil])

(deftrace valid-node? [n]
          (cond
            (nil? n) true
            (and (sequential? n)
                 (and
                   (= 3 (count n))
                   (not-any? false? n)
                   (not (nil? (first n)))
                   (or (nil? (first (rest n))) (sequential? (first (rest n))))
                   (or (nil? (first (rest (rest n)))) (sequential? (first (rest (rest n))))))
                 ) true
            :else false)
          )

(trace-forms (clojure.walk/prewalk next t4false))

(trace-forms (clojure.walk/prewalk #(and (valid-node? %)) t4false))

;(deftrace is-tree? [t]
;          (let [value (first t)
;                left (first (rest t))
;                right (rest (rest t))]
;            (cond
;              (and (nil? right) (nil? left)) true
;              ((not (nil? left)) (is-tree? left)
;                (is-tree? right))
;              )
;            )
;          )

(comment (is-tree? t2true)
         (is-tree? t3false)
         (is-tree? t4false)
         (is-tree? t5false)
         )

(defn vec-to-tree [t]
  (if (vector? t)
    (let [[val left right] t]
      {:val val
       :left (vec-to-tree left)
       :right (vec-to-tree right)})
    t))

;(map first (tree-seq next rest t2true))
;(map first (tree-seq next rest t3false))