(ns aoc-captcha.core-test
  (:require [clojure.test :refer :all]
            [aoc-captcha.core :refer :all]))

(deftest captcha-count-test
  (testing "stuff"
    (is (= (captcha-count "11") 2))
    (is (= (captcha-count "111") 3))
    (is (= (captcha-count "1111") 4))))

(deftest char->digit-test
  (is (= (char->digit \0) 0))
  (is (= (char->digit \1) 1))
  (is (= (char->digit \3) 3))
  (is (= (char->digit \5) 5))
  (is (= (char->digit \7) 7))
  (is (= (char->digit \9) 9)))

(deftest str->digit-list-test
  (is (= (str->digit-list "1234") '(1 2 3 4)))
  (is (= (str->digit-list "112233") '(1 1 2 2 3 3))))
