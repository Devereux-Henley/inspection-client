(ns inspection-client.util.css
  (:require
   [fulcro-css.css :as css]
   [om.next :as om]))

(defn has-css?
  [component]
  (implements? css/CSS component))

(defn routes-with-children
  [router-union-component]
  (->> (om/get-query router-union-component) vals (keep (comp :component meta))
    (filter has-css?) vec))
