(ns inspection-client.views.about
  (:require
   [fulcro.client.core :as fulcro-client]
   [om.dom :as dom]
   [om.next :as om :refer [defui]]))

(defui ^:once About
  static fulcro-client/InitialAppState
  (initial-state [comp-class params] {:page :about})
  static om/IQuery
  (query
    [this]
    [:page])
  Object
  (render
    [this]
    (dom/div nil "About the world!")))
