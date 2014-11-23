;; Regular Expressions - Elementary
;; Regex patterns are supported with a special reader macro.
;; tags - regex:syntax
;; restricted - 
(ns offline-4clojure.p37
  (:use clojure.test))

(def __
;; your solution here
)

(deftest main-test []
  (are [soln] soln
(= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
))
