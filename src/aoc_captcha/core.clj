(ns aoc-captcha.core)

(defn char->digit [char]
  (Integer/parseInt (str char)))

(defn str->digit-list [str] (map char->digit (seq str)))

(defn first-two-match? [list] (= (first list)
                                 (first (rest list))))

(defn ends-match? [list] (= (first list) (last list)))

(defn captcha-count-pair [list]
  (if (first-two-match? list)
    (first list)
    0))

(defn captcha-count-to-end [captcha-str]
  (loop [captcha-list (str->digit-list captcha-str)
         result 0]
    (if (<= 2 (count captcha-list))
      (recur (rest captcha-list)
             (+ result (captcha-count-pair captcha-list)))
      result)))

(defn captcha-count-last-element [captcha-str]
  (let [captcha-list (str->digit-list captcha-str)]
    (if (ends-match? captcha-list)
      (last captcha-list)
      0)))

(defn captcha-solve [captcha-str]
  (+ (captcha-count-to-end captcha-str)
     (captcha-count-last-element captcha-str)))

(defn rotate-list-left [l]
  (concat
   (rest l)
   (list (first l))))

(defn n-ahead-matches? [list n]
  (= (first list)
     (first
      (loop [n n
             list list]
        (if (< 0 n)
          (recur (dec n) (rotate-list-left list))
          list)))))
