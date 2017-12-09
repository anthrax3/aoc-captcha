(ns aoc-captcha.core-test
  (:require [clojure.test :refer :all]
            [aoc-captcha.core :refer :all]))

(deftest captcha-count-test
  (testing "stuff"
    (is (= (captcha-count "11") 2))
    (is (= (captcha-count "111") 3))
    (is (= (captcha-count "1111") 4))

    ))
