(ns roman-numerals.core)

(defn to-roman [decimal]
  (if (= decimal 5) "V"
    (cond 
      (= decimal 1) "I"
      (= decimal 2) "II"
      (= decimal 3) "III"))))
