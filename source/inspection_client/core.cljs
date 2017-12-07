(ns inspection-client.core
  (:require
   [fulcro.client :as fulcro-client]
   [fulcro-css.css :as css]
   [inspection-client.root :refer [Root]]))

(defonce app-atom (atom (fulcro-client/new-fulcro-client)))

(defn start
  []
  (swap! app-atom fulcro-client/mount Root "app")
  (css/upsert-css "app-styles" Root))

(defn stop
  [])

(defn ^:export init []
  (start))
