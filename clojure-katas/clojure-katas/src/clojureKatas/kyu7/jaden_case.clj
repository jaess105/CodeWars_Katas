(ns clojureKatas.kyu7.jaden_case
  (:use [clojure.string :only (split capitalize join)]))

(defn jaden-case [s]
  (->> (split s #" ")
       (map capitalize)
       (join " ")
  ))

(jaden-case "how can mirrors be real if our Eyes Aren't Real")