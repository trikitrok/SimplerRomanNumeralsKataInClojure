(ns roman-numerals-converter.core-test
  (:use midje.sweet)
  (:use [roman-numerals-converter.core]))

(facts 
  "about Roman numerals converter"

  (fact 
    "converts decimal numbers up to 3999 into roman numbers"
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
    (to-roman 900) => "CM"
    (to-roman 1000) => "M"
    (to-roman 2499) => "MMCDXCIX"
    (to-roman 3949) => "MMMCMXLIX"
    (to-roman 3999) => "MMMCMXCIX")
  
  (fact 
    "converts decimal numbers over 3999 into roman numbers"
    (to-roman 4000) => "--\nIV"
    (to-roman 4001) => "--\nIVI"
    (to-roman 30000) => "---\nXXX"
    (to-roman 3999005) => "---------\nMMMCMXCIXV"
    (to-roman 4000000) => "--\n--\nIV"
    (to-roman 4000025) => "--\n--\nIVXXV"))
