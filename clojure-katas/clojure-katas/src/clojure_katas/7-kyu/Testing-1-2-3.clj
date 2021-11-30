(ns clojure-katas.7-kyu.Testing-1-2-3)
(comment "Your team is writing a fancy new text editor and you've been tasked with implementing the line numbering.
          
Write a function which takes a list of strings and returns each line prepended by the correct number.
          
The numbering starts at 1. The format is n: string. Notice the colon and space in between.
         
Examples:
number(List<string>()) // => List<string>()
number(List<string>{\"a\", \"b\", \"c\"}) // => [\"1: a\", \"2: b\", \"3: c\"]"
)


(defn number [lines]
  (let [line-formatting #(format "%d: %s" %1 %2)
        line-numbers (map inc (range (count lines)))]
    (map line-formatting line-numbers lines))
  )