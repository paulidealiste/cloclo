(ns cloclo.crawler.nester-test
  (:require [clojure.test :refer :all]
            [cloclo.core :refer :all]))

(deftest test-nester
  (testing "Splits vectors of dot delimited strings to a nested map."
    (let [imperials [["only.for.gargoyles"]["only.for.medley"]]]
      (is (= {:only {:for {:gargoyles "", :medley ""}}} (flat->nested imperials))))))
