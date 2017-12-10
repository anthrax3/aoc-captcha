(ns aoc-captcha.core)

(defn captcha-count [captcha] (count captcha))  

(defn char->digit [char] (Integer/parseInt (str char)))

(defn str->digit-list [str] (map char->digit (seq str)))



