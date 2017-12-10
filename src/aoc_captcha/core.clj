(ns aoc-captcha.core)

(defn captcha-count-to-end [captcha]
  (loop [captcha (str->digit-list captcha)
         result 0]
    (if (<= 2 (count captcha))
      (recur (rest captcha)
             (+ result
                (if (first-two-digits-eq? captcha)
                  (first captcha)
                  0)))
      result)))

(defn char->digit [char] (Integer/parseInt (str char)))

(defn str->digit-list [str] (map char->digit (seq str)))

(defn first-two-match? [list] (= (first list)
                                     (first (rest list))))
