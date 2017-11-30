(ns inspection-client.root
  (:require
   [fulcro.client.core :as fulcro-client]
   [fulcro.client.routing :as routing]
   [fulcro-css.css :as css]
   [inspection-client.assets.css :refer [global-css]]
   [inspection-client.components.navigation-bar :refer [NavigationBar navigation-bar-factory]]
   [inspection-client.router :refer [routing-tree]]
   [inspection-client.router.root :refer [RootRouter RootRouter-Union root-router-factory]]
   [inspection-client.util.css :refer [routes-with-children]]
   [om.dom :as dom]
   [om.next :as om]))

(fulcro-client/defsc Root
  [this {:keys [ui/react-key router/root navigation-bar/navigation-state]} computed children]
  {:query [:ui/react-key
           {:navigation-bar/navigation-state (om/get-query NavigationBar)}
           {:router/root (om/get-query RootRouter)}]
   :css [global-css]
   :css-include (fn [this] (conj (routes-with-children RootRouter-Union) NavigationBar))
   :initial-state (fn [this params] (merge
                                      routing-tree
                                      {:router/root (fulcro-client/get-initial-state RootRouter {})
                                       :navigation-bar/navigation-state {:navigation-bar/page-keys [:index :about :login]}}))}
  (let [{:keys [application-root]} (css/get-classnames Root)]
    (dom/div #js {:key react-key}
      (navigation-bar-factory (om/computed navigation-state {:routing/route-fn! #(om/transact! this `[(routing/route-to {:handler ~%})])}))
      (dom/div #js {:className application-root}
        (root-router-factory root)))))
