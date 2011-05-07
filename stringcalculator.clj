(defn delimiter+number-str [s]
  (cond
    (.startsWith s "//;") {:delimiter (.substring s 2 3) :number-str (.substring s 4) }
    (= s "")              {:delimiter "," :number-str "0"}
    :else                 {:delimiter "," :number-str s}))

(defn add [s]
  (let [{:keys [delimiter number-str]} (delimiter+number-str s)
        numbers (map #(Integer/parseInt %) (.split number-str (str delimiter "|\n")))]
    (reduce + numbers)))

(defn assert-equals [msg expected actual]
	(let [result (cond (= expected actual) "yes: " :else "you failed: ")]
		(println (str result msg))))

(assert-equals "blank string adds up to 0" 0 (add ""))
(assert-equals "one adds up to one" 1 (add "1"))
(assert-equals "one number alone adds up to itself" 2 (add "2"))
(assert-equals "adds any number of comma-separated numbers" 20 (add "2,3,4,5,6"))
(assert-equals "can separate numbers by either ',' or '\n'" 9 (add "2\n3,4"))
(assert-equals "can specify your own delimiter" 3 (add "//;\n1;2"))