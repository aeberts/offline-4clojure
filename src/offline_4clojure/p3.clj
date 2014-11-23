;; Intro to Strings - Elementary
;; Clojure strings are Java strings.  This means that you can use any of the Java string methods on Clojure strings.
;; tags - 
;; restricted - 
(ns offline-4clojure.p3
  (:use clojure.test))

(def __
  "HELLO WORLD"
)

(deftest main-test []
  (are [soln] soln
(= __ (.toUpperCase "hello world"))
))
