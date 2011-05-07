(defn add [s] 0) 

(defn assert-equals [msg expressionA expressionB] 
	(let [result (cond (= expressionA expressionB) "yes" :else "you failed")]
		(println (str result ": " msg))))		
		
(assert-equals "blank string adds up to 0" 0 (add ""))