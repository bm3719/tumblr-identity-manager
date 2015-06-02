(ns tumblr-identity-manager.handler
  (:require [compojure.core :as cc]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as response]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def app-routes
  (apply
   cc/routes (flatten
              [(cc/make-route :get "/" (fn [req] (response/redirect "/index.html")))
               (route/resources "/")
               (route/not-found "Not Found")])))

(def app
  (wrap-defaults (handler/site app-routes) site-defaults))
