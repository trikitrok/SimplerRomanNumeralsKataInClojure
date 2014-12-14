(ns roman-numerals.core-test
  (:use midje.sweet)
  (:use [roman-numerals.core]))

(facts "about Roman numerals converter"
  (fact "converts a decimal number into a roman number"
    (to-roman 1) => "I"))
