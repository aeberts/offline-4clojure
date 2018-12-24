(defproject offline-4clojure "0.1.0-SNAPSHOT"
  :description "I want to use my real editor to solve 4clojure problems"
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [org.clojure/clojure "1.10.0"]
                 [clj-http "0.5.7"]
                 [cheshire "4.0.4"]
                 ; [org.clojure/math.combinatorics "0.0.8"]
                 ; [thalia "0.1.0"]
                 ; [com.cemerick/pomegranate "0.3.0"]
                 ; [org.clojure/tools.trace "0.7.8"]
                 ]
  :main  offline-4clojure.core
  ;;:profiles {:repl {:dependencies [[thalia "0.1.0"]]}}
  )
