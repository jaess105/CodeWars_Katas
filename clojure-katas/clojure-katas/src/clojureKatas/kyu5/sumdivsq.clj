(ns clojureKatas.kyu5.sumdivsq)

;; https://www.codewars.com/kata/55aa075506463dac6600010d/train/clojure
;1, 246, 2, 123, 3, 82, 6, 41 are the divisors of number 246.
; Squaring these divisors we get: 1, 60516, 4, 15129, 9, 6724, 36, 1681. The sum of these squares
; is 84100 which is 290 * 290.
;
;Task
;Find all integers between m and n (m and n integers with 1 <= m <= n) such that the sum of their
; squared divisors is itself a square.
;
;We will return an array of subarrays or of tuples (in C an array of Pair) or a string.
; The subarrays (or tuples or Pairs) will have two elements:
; first the number the squared divisors of which is a square and then the sum of the squared divisors.



(defn list-squared [m n]
  (let [get-all-divisors (fn [x] (reduce #(if (zero? (mod x %2)) (conj %1 %2) %1)
                                         []
                                         (range 1 (+ x 1))))
        square #(Math/pow % 2)
        square-and-sum #(reduce + (map square %))
        natural-number? #(and (= % (double (int %))) (>= % 0))]
    (->> (range m (+ n 1))
         (map #(vector % (square-and-sum (get-all-divisors %))))
         (filter #(natural-number? (Math/sqrt (second %))))
         (map #(vector (first %) (int (second %)))))))

