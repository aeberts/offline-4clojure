;; Beauty is Symmetry - Easy
;; Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right half of the tree.  Write a predicate to determine whether or not a given binary tree is symmetric. (see <a href='/problem/95'>To Tree, or not to Tree</a> for a reminder on the tree representation we're using).
;; tags - trees
;; restricted - 
(ns offline-4clojure.p96
  (:use clojure.test)
  (:use clojure.tools.trace)
  (:use clojure.walk))


;; Approach: invert the right branch of the tree and compare left and right branches with =. If inverted left and right trees are =, the tree is symmetrical.
;; to invert a tree: swap the left and right branches of the tree and descend into the sub branches.

(def __

  )


(defn invert-bad [c]
  (if (sequential? c)
    (cons (first c) (conj
                      (invert (nth 2 c))
                      (invert (nth 1 c))) )
  c))

(defn ^:dynamic seq-reverse [coll]
  (loop [[r & more :as all] (seq coll)
         acc '()]
    (if all
      (do
        (println "r:" r)
        (println "all:" all)
        (println "more:" more)
        (println "acc:" acc)
        (recur more (cons r acc)))
      acc)))

(def ss1 (seq [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]))

(defn dRev [lst]
  (clojure.walk/postwalk #(if (seq? %) (reverse %) %) lst))

(defn invert [coll]
  (clojure.walk/postwalk #(if (seq? %)
                           (cons (first %) (conj (nth 2 %) (nth 1 %))) %) coll))

(invert ss1)

(defn ^:dynamic basic [coll]
  (loop [[r & more :as all] (seq coll)
         acc '()]
    (if all
      (do
        ;(println "r:" r)
        ;(println "more:" more)
        ;(println "all:" all)
        ;(println "acc:" acc)
        (recur more (cons r acc)))
      acc)))

(basic ss1)

;(fn tree? [x]
;  (or
;    (nil? x)
;    (and
;      (sequential? x)
;      (= 3 (count x))
;      (not (sequential? (first x)))
;      (= (tree? (second x))
;         (tree? (nth x 2))
;         )
;      )))

;(fn tree? [x]
;  (or
;    (nil? x)
;    (and
;      (sequential? x)
;      (= 3 (count x))
;      (not (sequential? (first x)))
;      (tree? (second x))
;      (tree? (nth x 2)))))

(deftest main-test []
                   (are [soln] soln
                               (= (__ '(:a (:b nil nil) (:b nil nil))) true)
                               (= (__ '(:a (:b nil nil) nil)) false)
                               (= (__ '(:a (:b nil nil) (:c nil nil))) false)
                               (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                       [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
                                  true)
                               (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                       [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
                                  false)
                               (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                       [2 [3 nil [4 [6 nil nil] nil]] nil]])
                                  false)
                               ))
