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

(defn to-roman [decimal]
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