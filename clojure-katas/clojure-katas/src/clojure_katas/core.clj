;;;; (use 'clojure-katas.core :reload)

(ns clojure-katas.core
  (:gen-class))

(defn row-sum-odd-numbers [row-num]
  (reduce +
          (take-last row-num
                     (take
                      (reduce + (range 0 (+ row-num 1)))
                      (filter odd? (range))))))

(defn row-sum-odd-numbers [row-num]
  (->>
   (range)
   (filter odd?)
   (take (reduce + (range 0 (+ row-num 1))))
   (take-last row-num)
   (reduce +)))

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
   (reduce +)))




(defn divide [n]
  ;; https://www.codewars.com/kata/55192f4ecd82ff826900089e/train/clojure
  (and (not (= n 2)) (even? n)))





(defn number-to-string [num]
  ;; https://www.codewars.com/kata/5265326f5fda8eb1160004c8/train/clojure
  (str num))

(defn square-sum [lst]
  ;; https://www.codewars.com/kata/515e271a311df0350d00000f/train/clojure
  (->>
   (map (fn [x] (Math/pow x 2)) lst)
   (reduce +)
   (int)))

(defn check-type [arg]
  "Just a simple type check"
  (cond (= (type arg) (type "")) "Das war ein String"
        (= (type arg) (type 10)) "Das war ein int"
        :else "Ich kenne den type nicht"))


(defn is-divisible [n x y]
  ;; https://www.codewars.com/kata/5545f109004975ea66000086/train/clojure
  (and (= (mod n x) 0) (= (mod n y) 0)))


(defn str-to-length [ls]
  (map (fn [x] (count x)) 
       ls))

(defn mxdiflg [a1 a2]
  ;;https://www.codewars.com/kata/5663f5305102699bad000056/train/clojure
  (->> (for [a (str-to-length a1)
            b (str-to-length a2)] (- a b))
       (into [])
       (map #(Math/abs %))
       (reduce max -1))
  )


(defn declare-winner [f1 f2]
  ;;FIXME
  ;;https://www.codewars.com/kata/577bd8d4ae2807c64b00045b/train/clojure
  (println (format "%s a: %d hp: %d %s a: %d hp: %d. Kampf Ergebniss => %f %f"
           (:name f1) (:attack f1) (:hp f1)
           (:name f2) (:attack f2) (:hp f2)
           (float (/ (:hp f1) (:attack f2))) 
           (float (/ (:hp f2) (:attack f1)))))
  (def ergebnis
  (if (> (+ 0.5 (/ (:hp f1) (:attack f2))) (/ (:hp f2) (:attack f1)))
    (:name f1)
    (:name f2)))
  (println ergebnis)
  ergebnis
  )

(defn solution [n]
  "https://www.codewars.com/kata/5174a4c0f2769dd8b1000003/train/clojure"
  (sort n)
  )

(defn race [v1 v2 g]
  (defn get-hour [x](int x) )
  (defn get-min [x](int (* x 60))  )
  (defn get-sec [x] (int (* (* x 60) 60)))  
  (
   (->> (float (/ g (- v2 v1)))
        (into [])
        (apply (fn [x] (get-hour x) (get-min x) (get-sec x)))
        )
   
  ))


(race 720 850 70
      )

(= (race 720 850 70) [0 32 18])



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def s1 ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"])
  (def s2 ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"])
  (mxdiflg s1, s2))



