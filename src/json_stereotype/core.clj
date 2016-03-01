(ns json-stereotype.core
  (:require [clojure.data.json :as json]))

(defn stereotype [x]
  (cond (map? x) (into {} (map (fn [[k v]] [k (stereotype v)]) x))
        (and (coll? x) (map? (first x))) [(apply merge (map stereotype x))]
        (coll? x) (take 1 (map stereotype x))
        :else x))

(defn -main [& args]
  (let [input-file (first args)
        output-file (second args)]
    (spit output-file
          (with-out-str
            (json/pprint (stereotype (json/read-str (slurp input-file) :key-fn keyword)))))))
 
