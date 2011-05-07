(def sum (partial reduce +))

(defn add [s]
  (cond
    (= s "") 0
    :else (sum (map #(Integer/parseInt %) (.split s ",")))))

(defn assert-equals [msg expected actual]
	(let [result (cond (= expected actual) "yes: " :else "you failed: ")]
		(println (str result msg))))

(assert-equals "blank string adds up to 0" 0 (add ""))
(assert-equals "one adds up to one" 1 (add "1"))
(assert-equals "one number alone adds up to itself" 2 (add "2"))
(assert-equals "adds any number of comma-separated numbers" 20 (add "2,3,4,5,6"))