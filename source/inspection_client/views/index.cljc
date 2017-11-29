(ns inspection-client.views.index
  (:require
   [fulcro.client.core :as fulcro-client]
   [om.dom :as dom]
   [om.next :as om :refer [defui]]))

(defui ^:once Index
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
    (let [{:keys [app/title]} (om/props this)]
      (dom/div nil (str "Title: " title)))))
