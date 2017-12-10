(ns aoc-captcha.core-test
  (:require [clojure.test :refer :all]
            [aoc-captcha.core :refer :all]))

(deftest captcha-solve-test
  (is (= (captcha-solve "1122") 3))
  (is (= (captcha-solve "11122") 4))
  (is (= (captcha-solve "112233") 6))
  (is (= ((captcha-solve "11")) 2))
  (is (= (captcha-solve "121") 1))
  (is (= (captcha-solve "77") 14))
  (is (= (captcha-solve "777") 21)))

(deftest captcha-count-to-end-test
  (is (= (captcha-count-to-end "1122") 3))
  (is (= (captcha-count-to-end "11122") 4))
  (is (= (captcha-count-to-end "112233") 6)))

(deftest captcha-count-last-element-test
  (is (= (captcha-count-last-element "11") 1))
  (is (= (captcha-count-last-element "121") 1))
  (is (= (captcha-count-last-element "77") 7))
  (is (= (captcha-count-last-element "777") 7)))

(deftest ends-match?-test
  (is (ends-match? '(1 1)))
  (is (ends-match? '(1 2 1)))
  (is (ends-match? '(1 3 5 2 1)))
  (is (not (ends-match? '(1 2))))
  (is (not (ends-match? '(7 5 6 1 3 8 9)))))

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

(deftest first-two-match?-test
  (is (first-two-match? '(1 1)))
  (is (not (first-two-match? '(1 2)))))
