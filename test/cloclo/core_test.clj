(ns cloclo.core-test
  (:require [clojure.test :refer :all]
            [cloclo.core :refer :all]))

(def form-source
  "<document>
      <div>{{ 'real.money.penny' | translate }}</div>
      <div>{{ 'real.money.deals' | translate }}</div>
      <div>A complicated song.</div>
  </document>")

(def nested-form {:real {:money {:penny "", :deals ""}}})

(deftest test-from-translate-source
  (testing "Returns a nested map from the x(ht)ml structured document."
    (let [source form-source]
      (is (= nested-form (from-translate-source source))))))
