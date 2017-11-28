(ns inspection-client.root
  (:require
   [fulcro.client.routing :as routing]
   [inspection-client.router :refer [routing-tree]]
   [inspection-client.router.root :refer [RootRouter root-router-factory]]
   [fulcro.client.core :as fulcro-client]
   [om.dom :as dom]
   [om.next :as om]))

(om/defui ^:once Root
  static fulcro-client/InitialAppState
  (initial-state
    [comp-class params]
    (merge
      routing-tree
      {:router/root (fulcro-client/get-initial-state RootRouter {})}))
  static om/IQuery
  (query
    [this]
    [:ui/react-key
     {:router/root (om/get-query RootRouter)}])
  Object
  (render
    [this]
    (let [{:keys [ui/react-key router/root] :as props} (om/props this)]
      (dom/div #js {:key react-key}
        (dom/a #js {:onClick #(om/transact! this `[(routing/route-to {:handler :index})])} "Index")
        "|"
        (dom/a #js {:onClick #(om/transact! this `[(routing/route-to {:handler :about})])} "About")
        (root-router-factory root)))))
