(ns clojureKatas.kyu6.translate_roman_numerals
  (:use [clojure.string :only (split)]))

(defn translate-roman-numerals [roman]
  (let [vals {"I" 1 "V" 5 "X" 10 "L" 50 "C" 100 "D" 500 "M" 1000}
        transformed-list (map #(get vals %) (split roman #""))]
    (reduce +
           (last transformed-list) 
           (map (fn [x y] (if (< x y) (- x) x))
                transformed-list
                (rest transformed-list)) 
            )))
