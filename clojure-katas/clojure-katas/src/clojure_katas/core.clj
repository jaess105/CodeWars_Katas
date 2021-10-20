(ns clojure-katas.core
  (:gen-class))

(defn row-sum-odd-numbers [row-num]
  ;; https://www.codewars.com/kata/55fd2d567d94ac3bc9000064/train/clojure
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

(defn nth-odd-number [n] (- (* n 2) 1))
(defn sum-till-n [n] (/ (* n (+ n 1)) 2))

(defn row-sum-odd-numbers [row-num]
  (def numbers-before (->> (- row-num 1) 
       (sum-till-n)
       (+ 1)))
  (->>
   (range numbers-before (+ numbers-before row-num))
   (map nth-odd-number)
   (reduce +)))

(defn exp [x n]
  (reduce * (repeat n x)))



(defn row-sum-odd-numbers [row-num]
  (as-> row-num n
    (- n 1)
    (sum-till-n n)
    (- (Math/pow (+ n row-num) 2)
     (Math/pow n 2))
    (long n)
    ))

(defn arr [n]
  ;;https://www.codewars.com/kata/571d42206414b103dc0006a1/solutions/clojure
  (into [] (range n)))


(defn get-sum [a b]
  ;;https://www.codewars.com/kata/55f2b110f61eb01779000053/train/clojure
  ;Your code here!
  (->> 
   (if (< a b) (range a (+ b 1)) (range b (+ a 1)) )
   (reduce +))

  )





(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;(row-sum-odd-numbers 5)
  (row-sum-odd-numbers 5))

(defn divide [n]
  ;; https://www.codewars.com/kata/55192f4ecd82ff826900089e/train/clojure
  (and (not (= n 2)) (even? n))
  )

