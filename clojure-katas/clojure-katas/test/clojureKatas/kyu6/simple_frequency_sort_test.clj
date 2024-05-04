(ns clojureKatas.kyu6.simple-frequency-sort-test
  (:require [clojure.test :refer :all]
            [clojureKatas.kyu6.simple-frequency-sort         :refer [solve]]))

(deftest basic-tests
  (is (= (solve [2 3 5 3 7 9 5 3 7]) [3 3 3 5 5 7 7 2 9]))
  (is (= (solve [1 2 3 0 5 0 1 6 8 8 6 9 1]) [1 1 1 0 0 6 6 8 8 2 3 5 9]))
  (is (= (solve [5 9 6 9 6 5 9 9 4 4]) [9 9 9 9 4 4 5 5 6 6]))
  (is (= (solve [4 4 2 5 1 1 3 3 2 8]) [1 1 2 2 3 3 4 4 5 8]))
  (is (= (solve [4 9 5 0 7 3 8 4 9 0]) [0 0 4 4 9 9 3 5 7 8])))
;; => Syntax error compiling at (test/clojureKatas/kyu6/simple_frequency_sort_test.clj:6:10).
;;    Unable to resolve symbol: solve in this context



;; => Syntax error compiling at (test/clojureKatas/kyu6/simple_frequency_sort_test.clj:6:10).
;;    Unable to resolve symbol: solve in this context
