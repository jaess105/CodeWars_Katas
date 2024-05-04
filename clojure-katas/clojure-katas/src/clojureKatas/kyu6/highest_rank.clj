(ns highest-rank)


(defn highest-rank
  "Returns the most frequent entry in the data ISeq"
  [data]
  (->> (frequencies data)
       (apply max-key val)
       key))