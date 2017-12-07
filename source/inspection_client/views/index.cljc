(ns inspection-client.views.index
  (:require
   [fulcro-css.css :as css]
   [fulcro.client.dom :as dom]
   [fulcro.client.primitives :as primitives]))

(primitives/defsc Index
  [this {:keys [app/title]} computed {:keys [index-page]}]
  {:css [[:.index-page {:background-color "red"}]]
   :initial-state (fn [params] {:page :index
                                :app/title "Inspection Client"})
   :query [:page :app/title]}
  (dom/div #js {:className index-page} (str "Title: " title)))
