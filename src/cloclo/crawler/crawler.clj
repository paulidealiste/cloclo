(ns cloclo.crawler.crawler
  (:require [clojure.xml :as xml]
            [clojure.string :as str]))

(defn xml-sequencer
  [source]
  (xml-seq
   (xml/parse (java.io.ByteArrayInputStream. (.getBytes source)))))

(defn translate-target
  [contents]
  (second (re-find #"'(.*?)'" contents)))

(defn only-translated
  [parsed]
  (reduce (fn [collected content]
            (if (and (string? content)
                     (str/includes? content "| translate"))
              (conj collected [(translate-target content)])
              collected))
          []
          parsed))

(defn crawl->targets
  "Crawl over any x(ht)ml and extract pipe translated strings."
  [source]
  (-> source
      xml-sequencer
      only-translated))
