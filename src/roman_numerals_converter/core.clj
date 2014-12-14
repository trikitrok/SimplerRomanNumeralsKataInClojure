(ns roman-numerals-converter.core)

(def ^:private 
  decs-to-roms
  [{:dec 1000 :rom "M"}
   {:dec 900 :rom "CM"}
   {:dec 500 :rom "D"}
   {:dec 400 :rom "CD"}
   {:dec 100 :rom "C"}
   {:dec 90 :rom "XC"}
   {:dec 50 :rom "L"}
   {:dec 40 :rom "XL"}
   {:dec 10 :rom "X"}
   {:dec 9 :rom "IX"}
   {:dec 5 :rom "V"}
   {:dec 4 :rom "IV"}
   {:dec 1 :rom "I"}])

(defn- decimals-up-to-3999-to-roman [decimal]
  (loop [acc ""
         decimal decimal
         decs-to-roms decs-to-roms]
    (if (zero? decimal)
      acc
      (let [dec-to-rom (first decs-to-roms)]
        (if (>= decimal (:dec dec-to-rom))
          (recur (str acc (:rom dec-to-rom))
                 (- decimal (:dec dec-to-rom))
                 decs-to-roms)
          (recur acc
                 decimal
                 (rest decs-to-roms)))))))

(defn- lines [multiple-of-1000]
  (apply str (repeat (count multiple-of-1000) "-")))

(defn to-roman [decimal]
  (if (<= decimal 3999)
    (decimals-up-to-3999-to-roman decimal)
    (let [multiple-of-1000 (decimals-up-to-3999-to-roman
                              (quot decimal 1000))]
    (str (lines multiple-of-1000) 
         "\n" 
         multiple-of-1000
         (decimals-up-to-3999-to-roman
           (rem decimal 1000))))))
