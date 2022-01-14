(ns clojureKatas.kyu5.perimeter)

(defn fib-seq-sum-fun [n]
  (let [x (atom n)
        arr (atom [0N 1N 1N])]
    (while (> @x 2)
      (swap! arr #(conj % (reduce + (take-last 2 @arr))))
      (swap! x dec))
    (reduce + @arr)))

(defn perimeter [n]
  (* (fib-seq-sum-fun (+ n 1)) 4))

(defn fib-seq-sum [n]
  (let [x           (atom n)
        last        (atom 1N)
        before-last (atom 0N)
        sum         (atom 1N)]
    (while (> @x 1)
      (let [tmp @last]
        (swap! last #(+ @before-last %))
        (reset! before-last tmp)
        (swap! sum #(+ % @last))
        (swap! x dec)
        (println (str @before-last " " @last))
               ))
    @sum)      
   )

(defn perimeter [n]
  (* (fib-seq-sum (+ n 1)) 4))

(fib-seq-sum 6)

(perimeter 5)
(perimeter 6)
(perimeter 7)