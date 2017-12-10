(ns aoc-captcha.core-test
  (:require [clojure.test :refer :all]
            [aoc-captcha.core :refer :all]))

(deftest captcha-count-to-end-test
    (is (= (captcha-count-to-end "1122") 3))
    (is (= (captcha-count-to-end "11122") 4))
    (is (= (captcha-count-to-end "112233") 6)))

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

(deftest first-two-digits-eq?-test
  (is (first-two-digits-eq? '(1 1)))
  (is (not (first-two-digits-eq? '(1 2)))))
