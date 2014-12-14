(ns roman-numerals.core)

(defn to-roman [decimal]
  (if (= decimal 10)
    "X"
    (if (>= decimal 5) 
      (str "V" 
           (to-roman (- decimal 5)))
      (cond 
        (= decimal 1) "I"
        (= decimal 2) "II"
        (= decimal 3) "III"))))
