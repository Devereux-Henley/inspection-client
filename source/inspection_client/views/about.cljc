(ns inspection-client.views.about
  (:require
   [fulcro.client.dom :as dom]
   [fulcro.client.primitives :as primitives]))

(primitives/defsc About
  [this props]
  {:initial-state (fn [params] {:page :about})
   :query [:page]}
  (dom/div nil "About the world!"))
