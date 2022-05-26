(ns cloclo.core
  (:require [cloclo.crawler.nester :as nester]
            [cloclo.crawler.crawler :as crawler])
  (:gen-class))

(defn from-translate-source
  [source]
  (-> source
      crawler/crawl->targets
      nester/flat->nested))
