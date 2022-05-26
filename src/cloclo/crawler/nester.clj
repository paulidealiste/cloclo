(ns cloclo.crawler.nester
  (:require [clojure.string :as s]))

(defn dot-splitter-keywords
  "Split dot delimited vectors of strings and turn them into keywords."
  [nests]
  (map #(map keyword (s/split (first %) #"\.")) nests))

(defn split-nester
  ([splats]
   (split-nester splats {}))
  ([splats nester]
   (if (empty? splats)
     nester
     (recur (rest splats) (assoc-in nester (first splats) "")))))
  
(defn flat->nested
  [source]
  (-> source
      dot-splitter-keywords
      split-nester))
