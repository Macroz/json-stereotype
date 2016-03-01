(ns json-stereotype.core-test
  (:require [clojure.test :refer :all]
            [json-stereotype.core :refer :all]))

(deftest stereotype-test
  (is (= {:foo [{:a 1 :b 2 :c 3}]}
         (stereotype {:foo [{:a 1} {:b 2 :c 3}]}))))
