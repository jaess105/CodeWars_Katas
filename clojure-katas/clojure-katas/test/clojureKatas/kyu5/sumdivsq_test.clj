(ns clojureKatas.kyu5.sumdivsq-test
  (:require [clojure.test :refer :all])
  (:require [clojureKatas.kyu5.sumdivsq :refer [list-squared]]))

(deftest a-test1
  (testing "test1"
    (is (= (list-squared 1 250) [[1, 1], [42, 2500], [246, 84100]]))))
(deftest a-test2
  (testing "test2"
    (is (= (list-squared 42 250) [[42, 2500], [246, 84100]]))))
(deftest a-test3
  (testing "test3"
    (is (= (list-squared 250 500) [[287, 84100]]))))