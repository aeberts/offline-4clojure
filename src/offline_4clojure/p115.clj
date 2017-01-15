;; The Balance of N - Medium
;; A balanced number is one whose component digits have the same sum on the left and right halves of the number.  Write a function which accepts an integer n, and returns true iff n is balanced.
;; tags - math
;; restricted - 
(ns offline-4clojure.p115
  (:use clojure.test))

(def __

 (fn [n]
   (let [expl (map #(Character/getNumericValue %) (str n))
         lhs  (if (even? (count expl)) (take (/ (count expl) 2) expl) (take (int (Math/floor (double (/ (count expl) 2)))) expl))
         rhs  (if (even? (count expl)) (drop (/ (count expl) 2) expl) (drop (int (Math/ceil (double (/ (count expl) 2)))) expl))]
     (if (= (reduce + lhs) (reduce + rhs))
       true
       false))))

(defn lhs [expl]
  (if (even? (count expl)) (take (/ (count expl) 2) expl) (take (int (Math/floor (dec (/ (count expl) 2)))) expl)))


(defn rhs [expl]
  (if (even? (count expl)) (drop (/ (count expl) 2) expl) (drop (int (Math/floor (inc (/ (count expl) 2)))) expl)))


(rhs [0])
(rhs [0 1 2 3])
(rhs [0 1 2 3 4 5])
(rhs [9 8 7 4 3 2 0 9 8 7 4 3 2])
(lhs [0])
(lhs [0 1])
(lhs [0 1 2])
(lhs [0 1 2 3])
(lhs [9 8 0 9 8])
(lhs [0 1 2 3 4 5])
(lhs [9 8 7 4 3 2 0 9 8 7 4 3 2])


;; austintaylor's solution:
(fn [x]
  (let [digits (map #(Integer/parseInt (str %)) (str x))
        half (int (/ (count digits) 2))
        left (reduce + (take half digits))
        right (reduce + (take half (reverse digits)))]
    (= left right)))

;; amcnamara's solution:
#(-> % str count (/ 2) ((juxt take take-last) (str %)) (->> (map sort) (reduce =)))

;; silverio's solution
#(let [s ((fn digits [n]
            (if (pos? n) (cons (mod n 10) (digits (quot n 10))))) %)
       k (/ (count s) 2)
       r (reverse s)]
  (= (reduce + (take k s)) (reduce + (take k r))))


;; jbear's solution
(fn [n]
  (let [ds (map int (str n))]
    (zero? (reduce + (map - (take (quot (count ds) 2) ds) (reverse ds))))))

;; jafingerhut's solution

(fn [n]
  (let [digits (map #(- (int %) (int \0)) (str n))
        len (count digits)
        half (quot len 2)]
    (= (apply + (take half digits))
       (apply + (drop (- len half) digits)))))




(defn explode-to-digits [number]
  "explode-to-digits takes an integer and returns a sequence of it's individual digits"
  (map #(Character/getNumericValue %) (str number)))

(defn splitter [n]
  (partition 2 (explode-to-digits n)))


(splitter 11)

(deftest main-test []
  (are [soln] soln
   (= true (__ 11))
   (= true (__ 121))
   (= false (__ 123))
   (= true (__ 0))
   (= false (__ 88099))
   (= true (__ 89098))
   (= true (__ 89089))
   (= (take 20 (filter __ (range)))
      [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])))

