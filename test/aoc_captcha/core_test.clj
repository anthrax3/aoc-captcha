(ns aoc-captcha.core-test
  (:require [clojure.test :refer :all]
            [aoc-captcha.core :refer :all]))

(deftest captcha-count-test
  "stuff"
    (is (= (captcha-count "11") 2)))
