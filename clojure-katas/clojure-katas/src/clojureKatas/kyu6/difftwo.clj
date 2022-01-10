(ns clojureKatas.kyu6.difftwo)

;The objective is to return all pairs of integers from a given array of integers that have a difference of 2.
;The result array should be sorted in ascending order of values.
;Assume there are no duplicate integers in the array. The order of the integers in the input array should not matter.
; https://www.codewars.com/kata/5340298112fa30e786000688/train/clojure

(defn twos-difference [lst]
  (->> (sort lst)
       (reduce (fn [arr x] (if
                             (some #(= (+ x 2) %) lst)
                             (conj arr [x (+ 2 x)])
                             arr))
               [])))


