(ns clojureKatas.kyu8.sentence-smash-test
  (:require [clojure.test :refer :all])
  (:require [clojureKatas.kyu8.sentence-smash :refer :all]))


;; sample test cases
(deftest test-1
  (testing "Should return empty string for empty seq."
    (is (= (sentence-smash (list))
           ""))))

(deftest test-2
  (testing "One word example should return the word."
    (is (= (sentence-smash (list "hello"))
           "hello"))))

(deftest test-2
  (testing "Multiple words should be separated by spaces."
    (is (= (sentence-smash (list "hello", "world"))
           "hello world"))
    (is (= (sentence-smash (list "hello", "amazing", "world"))
           "hello amazing world"))
    (is (= (sentence-smash (list "this", "is", "a", "really", "long", "sentence"))
           "this is a really long sentence"))))



;; real test cases
(defn test-sentence-smash
  ([description sentence-seq solution]
   (testing description
     (is (= (sentence-smash sentence-seq)
            solution)))))

(deftest test-1
  (test-sentence-smash
    "Should return empty string for empty array."
    (list)
    "")
  ;(testing "Should return empty string for empty array."
  ;  (is (= (sentence-smash (list)) "")))
  )

(deftest test-2
  (test-sentence-smash
    "One word example should return the word."
    (list "hello")
    "hello"))

(deftest test-3
  (test-sentence-smash
    "Multiple words should be separated by spaces."
    (list "hello", "world")
    "hello world")
  (test-sentence-smash
    "Multiple words should be separated by spaces."
    (list "hello", "amazing", "world")
    "hello amazing world")
  (test-sentence-smash
    "Multiple words should be separated by spaces."
    (list "this", "is", "a", "really", "long", "sentence")
    "this is a really long sentence"))



(deftest test-random
  (letfn [(random-int [from, until] (+ (rand-int (- until from)) from))
          (rand-range [from, until] (range (random-int from until)))]
    (let [low-ascii (seq "abcdefghijklmnopqrstuvwxyz")
          random-char #(rand-nth low-ascii)
          word-random-len #(clojure.string/join "" (for [_ (rand-range 1 15)]
                                                     (random-char)))
          sentence-seq-rand-len #(for [_ (range (random-int 0 15))]
                                   (word-random-len))]
      (doseq [_ (range 100)]
        (let [sentence-seq (sentence-seq-rand-len)
              solution (clojure.string/join " " sentence-seq)]
          (test-sentence-smash
            (str "Random Tests for " solution)
            sentence-seq
            solution))))))


