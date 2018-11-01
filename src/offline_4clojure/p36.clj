;; Let it Be - Elementary
;; Can you bind x, y, and z so that these are all true?
;; tags - math:syntax
;; restricted - 
(ns offline-4clojure.p36
  (:use clojure.test))

(def __
  ; solution is:
  ;
  ; [x 7 y 3 z 1]
  ;
  ; this works on 4clojure because the code you add to the text block, "fills in the blanks" for the
  ; does not work in a stand-alone project because the vector syntax above which assigns x to 7, y to 3 and z to 1 only works in a let block
  ;
)

(deftest main-test []
  (are [soln] soln
(= 10 (let __ (+ x y)))
(= 4 (let __ (+ y z)))
(= 1 (let __ z))
))
