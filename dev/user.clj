;;;; This is a dev namespace to contain utility functions useful for
;;;; interacting with the data at the REPL, or for general development.
(ns user
  (:require [tumblr-identity-manager.handler :as handler]
            [clojure.pprint :refer [pp pprint]]
            [clojure.repl :refer [doc]]
            [clojure.tools.namespace.repl :as repl]
            [ring.adapter.jetty :as jetty])
  (:import [org.eclipse.jetty.servlet ServletHolder ServletContextHandler FilterHolder]))

;; Global Var that holds the server.
(def server nil)

(defn boot
  "Run this to start the server from the REPL."
  ([join?]
     (alter-var-root
      #'server
      (constantly
       (jetty/run-jetty
        #'handler/app
        {:join? join?
         :port  3000
         :ssl?  false}))))
  ([] (boot false)))

(defn restart
  "Restart the Jetty server." []
  (if (nil? server) (boot)
      (do
        (when (= (org.eclipse.jetty.server.Server/getState server) "STARTED")
          (.stop server))
        (.start server))))

(defn refresh
  "Run this to refresh the project.  This will shut down the server if it's
  active first.  If you get a compilation error, you may have to manually run:
  (clojure.tools.namespace.repl/refresh), or reload the full user namespace." []
  (when (and server (= (org.eclipse.jetty.server.Server/getState server) "STARTED"))
    (.stop server))
  (repl/refresh))
