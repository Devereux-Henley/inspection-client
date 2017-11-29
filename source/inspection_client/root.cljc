(ns inspection-client.root
  (:require
   [fulcro.client.routing :as routing]
   [fulcro-css.css :as css]
   [inspection-client.assets.css :refer [global-css]]
   [inspection-client.components.navigation-bar :refer [NavigationBar navigation-bar-factory]]
   [inspection-client.router :refer [routing-tree]]
   [inspection-client.router.root :refer [RootRouter root-router-factory]]
   [fulcro.client.core :as fulcro-client]
   [om.dom :as dom]
   [om.next :as om]))

(om/defui ^:once Root
  static css/CSS
  (local-rules
    [this]
    [])
  (include-children
    [this]
    [])
  static css/Global
  (global-rules
    [this]
    global-css)
  static fulcro-client/InitialAppState
  (initial-state
    [comp-class params]
    (merge
      routing-tree
      {:router/root (fulcro-client/get-initial-state RootRouter {})
       :navigation-bar/navigation-state {:navigation-bar/page-keys [:index :about]}}))
  static om/IQuery
  (query
    [this]
    [:ui/react-key
     {:navigation-bar/navigation-state (om/get-query NavigationBar)}
     {:router/root (om/get-query RootRouter)}])
  Object
  (render
    [this]
    (let [{:keys [ui/react-key router/root navigation-bar/navigation-state] :as props} (om/props this)]
      (dom/div #js {:key react-key}
        (navigation-bar-factory (om/computed navigation-state {:routing/route-fn! #(om/transact! this `[(routing/route-to {:handler ~%})])}))
        (root-router-factory root)))))
