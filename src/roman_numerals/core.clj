(ns roman-numerals.core)

(defn to-roman [decimal]
  (if (>= decimal 10)
    (str 
      "X" 
      (to-roman (- decimal 10)))
    
    (if (>= decimal 5) 
      (str 
        "V" 
        (to-roman (- decimal 5)))
      
      (cond
        (= decimal 1) "I"
        (= decimal 2) "II"
        (= decimal 3) "III"))))