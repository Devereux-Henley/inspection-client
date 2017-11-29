(ns inspection-client.util.css
  (:require
   [fulcro-css.css :as css]
   [om.next :as om]))

(defn has-css?
  [component]
  (implements? css/CSS component))

(defn routes-with-children
  [router-component]
  (->> (om/get-query router-component) second :current-route vals (keep (comp :component meta))
    (filter has-css?) vec))
