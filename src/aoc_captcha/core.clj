(ns aoc-captcha.core)

(defn char->digit [char]
  (Integer/parseInt (str char)))

(defn str->digit-list [str] (map char->digit (seq str)))

(defn first-two-match? [list] (= (first list)
                                     (first (rest list))))

(defn ends-match? [list] (= (first list) (last list)))

(defn captcha-count-to-end [captcha-str]
  (loop [captcha-list (str->digit-list captcha-str)
         result 0]
    (if (<= 2 (count captcha-list))
      (recur (rest captcha-list)
             (+ result
                (if (first-two-match? captcha-list)
                  (first captcha-list)
                  0)))
      result)))

(defn captcha-count-last-element [captcha-str]
  (let [captcha-list (str->digit-list captcha-str)]
    (if (ends-match? captcha-list)
      (last captcha-list)
      0)))

(defn captcha-solve [captcha-str]
  (+ (captcha-count-to-end captcha-str)
     (captcha-count-last-element captcha-str)))
