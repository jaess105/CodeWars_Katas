(ns clojureKatas.kyu6.buy-car)

;Let us begin with an example:
;A man has a rather old car being worth $2000.
; He saw a secondhand car being worth $8000. He wants to keep his old car until he can buy the secondhand one.
;He thinks he can save $1000 each month but the prices of his old car and of the new one decrease
; of 1.5 percent per month. Furthermore this percent of loss increases of 0.5 percent at the end
; of every two months. Our man finds it difficult to make all these calculations.
;
;Can you help him?
;
;How many months will it take him to save up enough money to buy the car he wants, and how much money will he have left over?
; https://www.codewars.com/kata/554a44516729e4d80b000012/train/clojure

(defn nb-months
  [start-price-old start-price-new saving-per-month percent-loss-per-month]
  (let [old-car-val (atom start-price-old)
        new-car-val (atom start-price-new)
        loss-percent (atom (* percent-loss-per-month 0.01))
        savings (atom 0)
        months (atom 0)
        reduce-car-val #(swap! % (fn [car-val loss] (- car-val (* car-val loss))) @loss-percent)
        increase-loss-if-uneven-month #(swap! loss-percent (fn [loss] (if (not (even? @months)) (+ loss 0.005) loss)))
        increase-savings #(swap! savings (fn [save] (+ save saving-per-month)))
        increment-months #(swap! months inc)
        round #(Math/round (double %))]
    (while (< (+ @old-car-val @savings) @new-car-val)
      (increase-loss-if-uneven-month)
      (reduce-car-val old-car-val)
      (reduce-car-val new-car-val)
      (increase-savings)
      (increment-months)
      )
    [@months (round (- (+ @old-car-val @savings) @new-car-val))]
    )
  )
