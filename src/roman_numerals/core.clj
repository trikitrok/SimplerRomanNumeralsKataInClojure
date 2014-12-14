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
      
      (if (>= decimal 1)
        (str 
          "I" 
          (to-roman (- decimal 1)))))))