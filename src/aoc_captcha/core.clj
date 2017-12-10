(ns aoc-captcha.core)

(defn char->digit [char] (Integer/parseInt (str char)))

(defn str->digit-list [str] (map char->digit (seq str)))

(defn first-two-match? [list] (= (first list)
                                     (first (rest list))))

(defn ends-match? [list] (= (first list) (last list)))

(defn captcha-count-to-end [captcha]
  (loop [captcha (str->digit-list captcha)
         result 0]
    (if (<= 2 (count captcha))
      (recur (rest captcha)
             (+ result
                (if (first-two-match? captcha)
                  (first captcha)
                  0)))
      result)))

(defn captcha-count-last-element [captcha]
  (let [captcha (str->digit-list captcha)]
    (if (ends-match? captcha)
      (last captcha)
      0)))

(defn captcha-solve [captcha]
  (+ (captcha-count-to-end captcha)
     (captcha-count-last-element captcha)))
