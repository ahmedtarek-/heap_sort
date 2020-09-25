(ns heap-sort.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn size
  [node]
  (if (= node nil)
    0
    (+ 1 (size (:left node)) (size (:right node)))))


(defn insert
  [value node]
  (println value "     " node)
  (if (= node nil)
    {:value value :left nil :right nil}
    (if (<= (size (:left node)) (size (:right node)))
      (assoc node :left (insert value (:left node)))
      (assoc node :right (insert value (:right node))))))

(defn create-tree
  [list-of-stuff]
  (def node nil)
  (doseq [x list-of-stuff]
    (def node (insert x node))
    (println "      ")
    (println node))
  )


(defn -main
  [& args]
  (create-tree [1 2 3 4 5])
  )

