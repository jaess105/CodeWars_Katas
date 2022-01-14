(ns clojureKatas.kyu5.piglatin)

;;https://www.codewars.com/kata/520b9d2ad5c005041100000f/train/clojure
; Move the first letter of each word to the end of it,
; then add "ay" to the end of the word.
; Leave punctuation marks untouched.

(defn pig-it [s]
  (clojure.string/replace s #"\b(\w)(\w+)\b|\b(\w)\b" "$2$1$3ay"))

(pig-it "Pig latin is o cool!")

