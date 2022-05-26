(ns cloclo.crawler.crawler-test
  (:require [clojure.test :refer :all]
            [cloclo.crawler.crawler :refer :all]))

(deftest test-crawling
  (testing "Read html-like string and get pipe translated strings."
    (let [source "<document><div>{{ 'one.two.three' | translate }}</div></document>"]
          (is (= [["one.two.three"]] (crawl->targets source))))))
