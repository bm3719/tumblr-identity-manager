;;;; This is a dev namespace to contain utility functions useful for
;;;; interacting with the data at the REPL, or for general development.
(ns user
  (:require [tumblr-identity-manager.handler :as handler]
            [tumblr-identity-manager.camel-kebab :as ck]
            [tumblr-identity-manager.data :as data]
            [tumblr-identity-manager.utility :as util]
            [clojure.core.memoize :as memo]
            [clojure.pprint :refer [pp pprint]]
            [clojure.repl :refer [doc]]
            [clojure.tools.namespace.repl :as repl]
            [ring.adapter.jetty :as jetty]))

;; Global Var that holds the server.
(def server nil)

(defn boot
  "Run this to start the server from the REPL."
  ([join?]
   (alter-var-root
    #'server (constantly
              (jetty/run-jetty #'handler/app
                               {:join? join?
                                :port  3000
                                :ssl?  false}))))
  ([] (boot false)))

(defn restart
  "Restart the Jetty server." []
  (if (nil? server) (boot)
      (do (when (= (org.eclipse.jetty.server.Server/getState server) "STARTED")
            (.stop server))
        (.start server))))

(defn refresh
  "Run this to refresh the project.  This will shut down the server if it's
  active first.  If you get a compilation error, you may have to manually run:
  (clojure.tools.namespace.repl/refresh), or reload the full user namespace." []
  (when (and server (= (org.eclipse.jetty.server.Server/getState server) "STARTED"))
    (.stop server))
  (repl/refresh))

;;; Profile case conversion code to find the optimal :fifo/threshold.

;; Create a set of data roughly the size of what we would expect in a
;; production system for the average large data returning REST call.
(defn data
  "Create n fake records and give them unique :_id values." [n]
  (map #(assoc %1 :_id %2)
       (flatten (repeat (inc (/ n (count data/identities))) data/identities))
       (range 1 (inc n))))

(def d (data 1000))

(defn memo-test
  "Test a range of fifo/threshold values in increments of 2." [data]
  (for [x (range 2 48 2)]
    (with-redefs [util/memoized->camelCase (memo/fifo ck/->kebab-case :fifo/threshold x)]
      (print (format "Testing fifo/threshold of %2d -> " x))
      (time (doall (util/kebab->camel data) nil)))))
