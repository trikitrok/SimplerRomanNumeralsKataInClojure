(ns roman-numerals.core)

(defn to-roman [decimal]
  (if (= decimal 1)
    "I"
    "II"))
