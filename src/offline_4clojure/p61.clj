;; Map Construction - Easy
;; Write a function which takes a vector of keys and a vector of values and constructs a map from them.
;; tags - core-functions
;; restricted - zipmap
(ns offline-4clojure.p61
  (:use clojure.test))

(def __

  (fn [k v]
    (into {} (map vector k v))
    )

  )
;
;(def a [:a :b :c])
;(def b [1 2 3])
;
;(interleave a b)
;=> (:a 1 :b 2 :c 3)
;
;(vector a b)
;=> [[:a :b :c] [1 2 3]]
;
;(into {} (map vector a b))
;=> {:a 1, :b 2, :c 3}

(deftest main-test []
  (are [soln] soln
    (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
    (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
    (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})))
