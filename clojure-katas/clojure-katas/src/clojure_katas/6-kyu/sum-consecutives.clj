(ns clojure-katas.6-kyu.sum-consecutives)
;; https://www.codewars.com/kata/55eeddff3f64c954c2000059/train/clojure

(def sum-consecutives
  #(map (partial reduce +) (partition-by identity %)))
  



