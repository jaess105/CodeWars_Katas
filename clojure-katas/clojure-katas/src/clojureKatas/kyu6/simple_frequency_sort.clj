(ns clojureKatas.kyu6.simple-frequency-sort)

(defn solve
  [numbers]
  (->> (frequencies numbers)
       (sort-by key <)
       (sort-by val >)
       (map (fn [[x y]] (repeat y x)))
       flatten))

