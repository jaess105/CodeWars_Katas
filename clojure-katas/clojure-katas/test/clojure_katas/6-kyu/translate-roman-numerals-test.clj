(ns clojure-katas.6-kyu.translate-roman-numerals-test
  (:require [clojure.test :refer :all]
            [clojure-katas.core :refer :all]
            [clojure-katas.6-kyu.translate-roman-numerals :refer :all]))


(deftest sample-roman-numerals
  (are [given-value calculated-value] (= given-value calculated-value)
    1     (translate-roman-numerals "I")
    4     (translate-roman-numerals "IV")
    2008  (translate-roman-numerals "MMVIII")
    1666  (translate-roman-numerals "MDCLXVI")))

