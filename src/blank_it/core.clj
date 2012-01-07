(ns blank-it.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn print-result
  "Take an array, and print out the blankish question-answer format."
  [arr]
  (let [triplets (partition 3 1 arr)]
    (let [[a b c] (first triplets)]  ; first case is special
      (println "__" b c)
      (println a))
    (doseq [[a b c] triplets]  ; middle case is common and easy
      (println a "__" c)
      (println b))
    (let [[a b c] (last triplets)]  ; last case is special
      (println a b "__")
      (println c))))

(defn -main
  ([] (println "Give me a file to eat!"))
  ([file] (print-result (str/split (slurp file) #"\n"))))
