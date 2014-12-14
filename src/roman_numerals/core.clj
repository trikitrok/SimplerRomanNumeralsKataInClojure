(ns roman-numerals.core)

(def ^:private 
  decs-to-roms
  [{:dec 10 :rom "X"}
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