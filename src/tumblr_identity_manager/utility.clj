(ns tumblr-identity-manager.utility
  (:require [tumblr-identity-manager.camel-kebab :as ck]
            [clojure.core.memoize :as memo]
            [clojure.string :as s]
            [clojure.walk :as walk]))

;;; Case conversion, memoized for performance.

(def memoized->kebab-case
  (memo/fifo ck/->kebab-case :fifo/threshold 24))

(def memoized->camelCase
  (memo/fifo ck/->camelCase :fifo/threshold 24))

(defn kebab->camel
  "Recursively transforms all kebab-case keys in coll to camelCase.
  Preserves :_id keys." [col]
  (walk/postwalk #(if (and (keyword? %) (= % :id)) :_id %)
                 (ck/transform-keys memoized->camelCase col)))

(defn camel->kebab
  "Recursively transforms all camelCase keys in coll to kebab-case.
  Preserves :_id keys." [col]
  (walk/postwalk #(if (and (keyword? %) (= % :id)) :_id %)
                 (ck/transform-keys memoized->kebab-case col)))

(defn camel-str->kebab
  "Given a string, converts it to kebab-case.  Excludes _id." [s]
  (if (= s "_id") s (memoized->kebab-case s)))

(defn memo-test
  "Test a range of fifo/threshold values in increments of 2." [data]
  (for [x (range 2 48 2)]
    (with-redefs [memoized->camelCase (memo/fifo ck/->kebab-case :fifo/threshold x)]
      (print (format "Testing fifo/threshold of %2d -> " x))
      (time (doall (kebab->camel data) nil)))))

;;; General utility functions.

(defn str->int
  "Safely parse untrusted strings to ints." [str]
  (if (re-matches (re-pattern "\\d+") str) (read-string str)))
