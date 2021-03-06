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

(defn json-200
  "Returns a successful 200 (OK) message." [to-render]
  {:status 200
   :headers {"Content-Type" "text/json; charset=utf-8"
             "Cache-Control" "no-cache, no-store, must-revalidate"
             "Pragma" "no-cache"
             "Expires" "0"}
   :body (cheshire/generate-string
          (util/kebab->camel to-render))})

(defn json-404
  "Return a 404 (Not Found) message." []
  {:status 404
   :headers {"Content-Type" "text/html; charset=utf-8"}
   :body "Not Found"})

(defn link-children
  "Embeds maps in a parent that exists in vector v who references their :_id
  fields in sub-vector k." [col k v]
  (assoc col k (for [id (k col)]
                 (some #(if (= (:_id %) id) %) v))))

(defn get-maps
  "Simulates a function that goes to the datastore and grabs the specified
  table and does something with it prior to returning it to the front end.
  Here, we're just assuming it's the identity table and only returning
  top-level records, then manually splicing in the child records." [table]
  (let [ref-ids (flatten (map #(concat (:headmates %) (:tuplas %)) table))]
    (->> (filter #(not (some #{(:_id %)} ref-ids)) table)
         (map #(link-children % :headmates table))
         (map #(link-children % :tuplas table)))))

(defn get-by-id
  "Simulates a function that goes to the datastore and retrieves a record of
  matching id from the specified table." [table id]
  (some #(when (= (:_id %) (util/str->int id)) %) (get-maps table)))

(cc/defroutes app-routes
  (cc/GET "/identity" [] (json-200 (get-maps data/identities)))
  (cc/GET "/identity/:id" [id] (json-200 (get-by-id data/identities id)))
  (cc/GET "/" [] (response/redirect "/index.html"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults (handler/site app-routes) site-defaults))
