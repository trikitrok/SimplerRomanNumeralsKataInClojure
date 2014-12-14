(ns roman-numerals.core)

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

(defn to-roman 
  ([decimal] (to-roman decimal decs-to-roms))
  ([decimal decs-to-roms]
   (if (zero? decimal)
     ""
     (let [dec-rom (first decs-to-roms)]
       (if (>= decimal (:dec dec-rom))
         (str (:rom dec-rom)
              (to-roman (- decimal (:dec dec-rom)) 
                        decs-to-roms))
         (to-roman decimal 
                   (rest decs-to-roms)))))))