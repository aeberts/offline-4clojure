;; Beauty is Symmetry - Easy
;; Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right half of the tree.  Write a predicate to determine whether or not a given binary tree is symmetric. (see <a href='/problem/95'>To Tree, or not to Tree</a> for a reminder on the tree representation we're using).
;; tags - trees
;; restricted - 
(ns offline-4clojure.p96
  (:use clojure.test)
  (:use clojure.tools.trace)
  (:require [clojure.walk :as w])
  (:require [clojure.zip :as z]))


;; Approach: invert the right branch of the tree and compare left and right branches with =. If inverted left and right trees are =, the tree is symmetrical.
;; to invert a tree: swap the left and right branches of the tree and descend into the sub branches.
;;
;; Figure out how to get clojure.walk to yield nodes and children i.e. [3 [4 [ 5 nil nil] [ 6 nil nil]] nil ]
;;

(def ss [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]])

(w/postwalk #(if (sequential? %) (-> %  (conj (first %)) (conj (nth % 2)) (conj (nth % 1))) % ) ss)

(defn flip-kids
  [c]
  (assoc c 2 (nth c 1) 1 (nth c 2)))

(w/postwalk #(if (sequential? %) (flip-kids %) % ) ss)

(w/postwalk #(if (sequential? %) (assoc % 2 (nth % 1) 1 (nth % 2)) % ) ss)


(flip-kids [5 nil 1])


(defn invert-bad [c]
  (if (sequential? c)
    (cons (first c) (conj
                      (invert-bad (nth 2 c))
                      (invert-bad (nth 1 c))) )
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

(defn ptree [lst]
  (clojure.walk/postwalk #(if (seq? %) (println %) (println %)) lst))

(defn invert [coll]
  (clojure.walk/postwalk #(if (seq? %)
                           (cons (first %) (conj (nth 2 %) (nth 1 %))) %) coll))

(ptree ss1)

;(invert ss1)

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

(def __

  (fn [coll]
    (let [vcoll (clojure.walk/postwalk #(if (seq? %) (vec %) %) coll )
          lb (nth vcoll 1)
          rb (nth vcoll 2)
          invertrb (clojure.walk/postwalk #(if (sequential? %) (assoc % 2 (nth % 1) 1 (nth % 2)) % ) rb)]
      (if (= lb invertrb)
        true
        false)
      )
    )

  )



(__ '(:a (:b nil nil) (:b nil nil)))

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
