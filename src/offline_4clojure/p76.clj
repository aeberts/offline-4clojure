;; Intro to Trampoline - Medium
;; The trampoline function takes a function f and a variable number of parameters.  Trampoline calls f with any parameters that were supplied.  If f returns a function, trampoline calls that function with no arguments.  This is repeated, until the return value is not a function, and then trampoline returns that non-function value.  This is useful for implementing mutually recursive algorithms in a way that won't consume the stack.
;; tags - recursion
;; restricted - 
(ns offline-4clojure.p76
  (:use clojure.test))

; foo takes and x and y and returns a function: (bar (conj x y) y)
;
; bar takes and x and y
; returns x if (last x) > 10
; else returns a function: (foo x (+ 2 y)
; (bar [1] 1)
; (foo [1] 3)
; (bar [1 3] 5)

(def __

  [1 3 5 7 9 11]

)

(deftest main-test []
  (are [soln] soln
(= __
   (letfn
     [(foo [x y] #(bar (conj x y) y))
      (bar [x y] (if (> (last x) 10)
                   x
                   #(foo x (+ 2 y))))]
     (trampoline foo [] 1)))
))
