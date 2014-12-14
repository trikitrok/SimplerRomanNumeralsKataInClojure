(ns roman-numerals.core-test
  (:use midje.sweet)
  (:use [roman-numerals.core]))

(facts 
  "about Roman numerals converter"
  (fact 
    "converts a decimal number into a roman number"
    (to-roman 1) => "I"
    (to-roman 2) => "II"
    (to-roman 3) => "III"
    (to-roman 4) => "IV"
    (to-roman 5) => "V"
    (to-roman 6) => "VI"
    (to-roman 8) => "VIII"
    (to-roman 9) => "IX"
    (to-roman 10) => "X"
    (to-roman 11) => "XI"
    (to-roman 18) => "XVIII"
    (to-roman 25) => "XXV"
    (to-roman 33) => "XXXIII"
    (to-roman 34) => "XXXIV"
    (to-roman 39) => "XXXIX"
    (to-roman 40) => "XL"
    (to-roman 50) => "L"
    (to-roman 90) => "XC"
    (to-roman 100) => "C"
    (to-roman 400) => "CD"
    (to-roman 500) => "D"
    (to-roman 900) => "CM"))
