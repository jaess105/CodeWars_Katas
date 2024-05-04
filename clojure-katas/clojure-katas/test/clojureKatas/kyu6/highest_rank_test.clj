(ns clojureKatas.kyu6.highest-rank-test
  (:require [clojure.test :refer :all]
            [highest-rank :refer [highest-rank]]))

(deftest Testing
  (testing
   "[12, 10, 8, 12, 7, 6, 4, 10, 12]"
    (is (= (highest-rank [12, 10, 8, 12, 7, 6, 4, 10, 12])
           12)))
  (testing
   "[12, 10, 8, 12, 7, 6, 4, 10, 10]"
    (is (= (highest-rank [12, 10, 8, 12, 7, 6, 4, 10, 10])
           10)))
  (testing
   "[12, 10, 8, 12, 7, 6, 4, 10, 10, 12, 12]"
    (is (= (highest-rank [12, 10, 8, 12, 7, 6, 4, 10, 10, 12, 12])
           12)))
  (testing
   "[12, 10, 8, 12, 7, 6, 4, 10, 10, 12, 12, 14, 14, 14, 14]"
    (is (= (highest-rank [12, 10, 8, 12, 7, 6, 4, 10, 10, 12, 12, 14, 14, 14, 14])
           14))))

(Testing)
;; => #'clojureKatas.kyu6.highest-rank-test/Testing
