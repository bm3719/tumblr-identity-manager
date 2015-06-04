(ns tumblr-identity-manager.handler
  (:require [tumblr-identity-manager.utility :as util]
            [tumblr-identity-manager.data :as data]
            [cheshire.core :as cheshire]
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
   :body (cheshire/generate-string
          (util/kebab->camel to-render))})

(defn json-404 []
  {:status 404
   :headers {"Content-Type" "text/html; charset=utf-8"}
   :body "Not found"})

(defn link-children
  "Embeds maps in a parent who references their :_id fields in
  sub-vector k." [col k]
  (map #(assoc % k (for [id (k (first data/identity))]
                     (some (fn [m] (if (= (:_id m) id) m)) data/identity)))
       col))

(defn get-maps
  "Simulates a function that goes to the database and grabs the specified table
  and does something with it prior to returning it to the front end.  Here,
  we're just assuming it's the identity table and only returning top-level
  records, then manually splicing in the child records." [table]
  (let [ref-ids (flatten (map #(concat (:headmates %) (:tuplas %)) data/identity))]
    (as-> (filter #(not (some #{(:_id %)} ref-ids)) data/identity) $
      (link-children $ :headmates)
      (link-children $ :tuplas))))

(defn get-by-id [table id]
  (some #(if (= (:_id %) (util/str->int id)) %) (get-maps table)))

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
