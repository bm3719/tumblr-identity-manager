;;;; A local, modified version of camel-snake-kebab library.  This is a subset
;;;; of the official library's functionality, most importantly lacking the
;;;; ClojureScript integration.  The trade-off is a removed dependency (and its
;;;; sub-dependency tree), lessened build non-determinism, and a simplified
;;;; interface.

(ns tumblr-identity-manager.camel-kebab
  (:require [clojure.string]
            [clojure.walk :refer [postwalk]])
  (:import (java.util.regex Pattern)
           (clojure.lang Keyword Symbol)))

(defn classify-char [c]
  (case c
    (\0 \1 \2 \3 \4 \5 \6 \7 \8 \9) :number
    (\- \_ \space \tab \newline \o013 \formfeed \return) :whitespace
    (\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z) :lower
    (\A \B \C \D \E \F \G \H \I \J \K \L \M \N \O \P \Q \R \S \T \U \V \W \X \Y \Z) :upper
    :other))

(defn split [ss]
  (let [cs (mapv classify-char ss)]
    (loop [result [], start 0, current 0]
      (let [next (inc current)
            result+new (fn [end]
                         (if (> end start)
                           (conj result (.substring ^String ss start end))
                           result))]
        (cond (>= current (count ss))
              (result+new current)

              (= (nth cs current) :whitespace)
              (recur (result+new current) next next)

              (let [[a b c] (subvec cs current)]
                (or (and (not= a :upper) (= b :upper))
                    (and (not= a :number) (= b :number))
                    (and (= a :upper) (= b :upper) (= c :lower))))
              (recur (result+new next) next next)

              :else
              (recur result start next))))))

(defn convert-case [first-fn rest-fn sep s]
  (let [[first & rest] (split s)]
    (clojure.string/join sep (cons (first-fn first) (map rest-fn rest)))))

(defn type-preserving-function [case-label first-fn rest-fn sep]
  `(let [convert-case# (partial convert-case ~first-fn ~rest-fn ~sep)]
     (defn ~(symbol (str "->" case-label)) [s#]
       (alter-name s# convert-case#))))

(defn type-converting-functions [case-label first-fn rest-fn sep]
  (letfn [(make-name [type-label]
            (->> (str case-label " " type-label)
                 (convert-case (resolve first-fn) (resolve rest-fn) sep)
                 (str "->")
                 (symbol)))]
    (for [[type-label type-converter] {"string" `identity "symbol" `symbol "keyword" `keyword}]
      `(defn ~(make-name type-label) [s#]
         (->> (name s#)
              (convert-case ~first-fn ~rest-fn ~sep)
              ~type-converter)))))

(defmacro defconversion [case-label first-fn rest-fn sep]
  `(do ~(type-preserving-function  case-label first-fn rest-fn sep)
       ~@(type-converting-functions case-label first-fn rest-fn sep)))

(defprotocol AlterName
  (alter-name [this f] "Alters the name of this with f."))

(extend-protocol AlterName
  String
  (alter-name [this f]
    (-> this f))

  Keyword
  (alter-name [this f]
    (if (namespace this)
      (throw (ex-info "Namespaced keywords are not supported" {:input this}))
      (-> this name f keyword)))

  Symbol
  (alter-name [this f]
    (if (namespace this)
      (throw (ex-info "Namespaced symbols are not supported" {:input this}))
      (-> this name f symbol))))

(defn convert-case2 [first-fn rest-fn sep s]
  "Converts the case of a string according to the rule for the first
  word, remaining words, and the separator."
  (convert-case first-fn rest-fn sep s))

(defn transform-keys [t coll]
  "Recursively transforms all map keys in coll with t."
  (letfn [(transform [[k v]] [(t k) v])]
    (postwalk (fn [x] (if (map? x) (into {} (map transform x)) x)) coll)))

(defconversion "camelCase" clojure.string/lower-case clojure.string/capitalize "")
(defconversion "kebab-case" clojure.string/lower-case clojure.string/lower-case "-")
