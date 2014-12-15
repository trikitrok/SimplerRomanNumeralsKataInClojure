(ns roman-numerals-converter.core)

(declare 
  to-roman-from-up-to-3999
  to-roman-from-over-3999)

(defn to-roman [decimal]
  (if (<= decimal 3999)
    (to-roman-from-up-to-3999 decimal)
    (to-roman-from-over-3999 decimal)))

;;
;; Decimal numbers up to 3999
;;
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

(defn- to-roman-from-up-to-3999 [decimal]
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

;;
;; Decimal numbers over 3999
;;
(def ^:private join-str 
  (partial apply str))

(defn- times-thousand-bar [multiple]
  (concat (repeat (count multiple) "-") "\n"))

(defn- times-thousand-bars [multiple times]
  (join-str 
    (flatten 
      (repeat times 
              (times-thousand-bar multiple)))))

(defn- multiple [decimal]
  (loop [times 0 num decimal]
    (if (<= num 3999)
      [(to-roman-from-up-to-3999 num) times]
      (recur (inc times) (quot num 1000)))))

(defn- to-roman-from-over-3999 [decimal]
  (let [[multiple times] (multiple decimal)]
    (str (times-thousand-bars multiple times)     
         multiple
         (to-roman-from-up-to-3999
           (rem decimal (* times 1000))))))