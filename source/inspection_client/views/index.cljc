(ns inspection-client.views.index
  (:require
   [fulcro.client.core :as fulcro-client]
   [fulcro-css.css :as css]
   [om.dom :as dom]
   [om.next :as om :refer [defui]]))

(defui ^:once Index
  static css/CSS
  (local-rules
    [this]
    [[:.index-page {:background-color "red"}]])
  (include-children
    [this]
    [])
  static fulcro-client/InitialAppState
  (initial-state [comp-class params] {:page :index
                                      :app/title "Inspection Client"})
  static om/IQuery
  (query
    [this]
    [:page :app/title])
  Object
  (render
    [this]
    (let [{:keys [app/title]} (om/props this)
          {:keys [index-page]} (css/get-classnames Index)]
      (dom/div #js {:className index-page} (str "Title: " title)))))
