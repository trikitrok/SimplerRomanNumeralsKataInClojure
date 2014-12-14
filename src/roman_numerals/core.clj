(ns roman-numerals.core)

(defn to-roman [decimal]
  (cond 
    (= decimal 1) "I"
    (= decimal 2) "II"
    (= decimal 3) "III"))
