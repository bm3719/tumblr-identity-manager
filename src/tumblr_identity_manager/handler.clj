(ns tumblr-identity-manager.handler
  (:require [cheshire.core :as cheshire]
            [cheshire.generate :as generate]
            [compojure.core :as cc]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as response]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn json-200 [to-render]
  {:status 200
   :headers {"Content-Type" "text/json; charset=utf-8"
             "Cache-Control" "no-cache, no-store, must-revalidate"
             "Pragma" "no-cache"
             "Expires" "0"}
   :body (cheshire/generate-string to-render)})

(defn json-404 []
  {:status 404
   :headers {"Content-Type" "text/html; charset=utf-8"}
   :body "Not found"})

;; (def app-routes
;;   (apply
;;    cc/routes (flatten
;;               [(cc/make-route :get "/" (fn [req] (response/redirect "/index.html")))
;;                (route/resources "/")
;;                (route/not-found "Not Found")])))

;; TODO: Replace these.
(defn get-maps
  "Replace this later with a DB layer call." [table]
  [{:name "Bruce C. Miller"
    :sexuality "Lithromantic"
    :gender "Trigender"
    :therian-species "Plantkin"
    :trans-size "Rubenesque"
    :headmates ["Steelfang Ringtails"
                "Gleep"]
    :trigger-words ["Food"
                    "Homogenous"
                    "Monkey necklace"]
    :trans-ethnicity "German"}
   {:name "Erik J. Seppanen"
    :sexuality "Pomosexual"
    :gender "Genderfluid"
    :therian-species "Shloof"
    :trans-size "Transthin"
    :headmates ["Indigo Child"
                "Pyrofox"]
    :trigger-words ["Uncle Gary"
                    "The"
                    "Fishmonger"]
    :trans-ethnicity "Finnish"}
   {:name "Josh Q. Lents"
    :sexuality "Autosexual"
    :gender "Bi-androgynous"
    :therian-species "Pandakin"
    :trans-size "Rubenesque"
    :headmates ["Wayne Border"
                "President Obama"]
    :trigger-words ["Doctor"]
    :trans-ethnicity "German"}])
(defn get-by-id [table id]
  {:name "Bruce C. Miller"
    :sexuality "Lithromantic"
    :gender "Trigender"
    :therian-species "Plantkin"
    :trans-size "Rubenesque"
    :headmates ["Steelfang Ringtails"
                "Gleep"]
    :trigger-words ["Food"
                    "Homogenous"
                    "Monkey necklace"]
    :trans-ethnicity "German"})

(defmacro response
  "Creates responses used for endpoints."
  ([entity-name] `(json-200 (get-maps ~entity-name)))
  ([entity-name id] `(json-200 (get-by-id ~entity-name ~id))))

(cc/defroutes app-routes
  (cc/GET "/identity" [] (response "identity"))
  (cc/GET "/identity/:id" [id] (response "identity" id))
  (cc/GET "/" [] (response/redirect "/index.html"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults (handler/site app-routes) site-defaults))
