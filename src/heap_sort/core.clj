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
  (if (= node nil)
    {:value value :left nil :right nil}
    (if (<= (size (:left node)) (size (:right node)))
      (assoc node :left (insert value (:left node)))
      (assoc node :right (insert value (:right node))))))

(defn create-tree
  [list-of-stuff]
  (def node nil)
  (doseq [x list-of-stuff]
    (def node (insert x node)))
  node)

(defn treat
  [element]
  (if (= element nil)
    ##-Inf
    element))

(defn max-with-nil
  [list-of-stuff]
  (def new-list (mapv #(treat %) list-of-stuff))
  (println new-list)
  (apply max new-list))

(defn sort
  [tree]
  (if (= tree nil)
    nil
    (let [
          left (sort (:left tree))
          right (sort (:right tree))
          ]
      
      (do 

        (println "        \n")
        (println "--------------------------")
        (println (:value tree))
        (println "LEFT IS: " left)

        (println "        \n")
        (println "--------------------------")
        (println (:value tree))
        (println "LEFT IS: " left)
        (println "RIGHT IS: " right)

        (def max-value (max-with-nil [(:value left) (:value right) (:value tree)]))
        (cond
          (= max-value (:value left))  {:value max-value :left (assoc left :value (:value tree)) :right right}
          (= max-value (:value right)) {:value max-value :left left :right (assoc right :value (:value tree))}
          (= max-value (:value tree))  {:value max-value :left left :right right})))))


(defn -main
  [& args]
  (def tree (create-tree [1 2 3 4 5 99 1000 212 278]))
  (println "Initial TREE")
  (println tree)
  (def sorted-tree (sort tree))
  (println "FINAL TREE")
  (println sorted-tree)
  )

