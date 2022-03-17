(ns clojureKatas.kyu5.rgb
  (:use [clojure.string :only (upper-case)] ))
;; https://www.codewars.com/kata/513e08acc600c94f01000001/train/clojure
(defn to-rgb-number [x]
  (Math/round (double (if (> x 255)
                        255.0
                        (if (< x 0)
                          0.0
                          x)))))
(defn hexify [s]
  (str (format "%02x" (int s))))

(def to-rgb-hex #(hexify (to-rgb-number %)))

(defn rgb [r g b]
  (upper-case (str (to-rgb-hex r)
       (to-rgb-hex g)
       (to-rgb-hex b))))

(to-rgb-hex 300)
(hexify 300)