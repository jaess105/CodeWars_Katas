(ns clojure-katas.core
  (:gen-class))

(defn row-sum-odd-numbers [row-num]
  (reduce + 
          (take-last row-num
            (take
             (reduce + (range 0 (+ row-num 1)))
             (filter odd? (range)))))
  )

(defn row-sum-odd-numbers [row-num]
  (->>
   (range)
   (filter odd?)
   (take (reduce + (range 0 (+ row-num 1))))
   (take-last row-num)
   (reduce +))
  )

(defn row-sum-odd-numbers [row-num]
  (->> 
   (+ 1 row-num)
   (range 1)
   (reduce +)
   (* 2)
   (+ 1)
   (range)
   (filter odd?)
   (take-last row-num)
   (reduce +))
  )


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (row-sum-odd-numbers 5))

(defn divide [n]
  ;; https://www.codewars.com/kata/55192f4ecd82ff826900089e/train/clojure
  (and (not (= n 2)) (even? n))
  )

