(ns inspection-client.root
  (:require
   [fulcro.client.routing :as routing]
   [fulcro-css.css :as css]
   [inspection-client.assets.css :refer [global-css]]
   [inspection-client.components.navigation-bar :refer [NavigationBar navigation-bar-factory]]
   [inspection-client.router :refer [routing-tree]]
   [inspection-client.router.root :refer [RootRouter RootRouter-Union root-router-factory]]
   [inspection-client.util.css :refer [routes-with-children]]
   [fulcro.client.dom :as dom]
   [fulcro.client.primitives :as primitives]))

(primitives/defsc Root
  [this {:keys [ui/react-key router/root navigation-bar/navigation-state]} computed {:keys [application-root]}]
  {:query [:ui/react-key
           {:navigation-bar/navigation-state (primitives/get-query NavigationBar)}
           {:router/root (primitives/get-query RootRouter)}]
   :css [global-css]
   :css-include (fn [] (conj (routes-with-children RootRouter-Union) NavigationBar))
   :initial-state (fn [params] (merge
                                 routing-tree
                                 {:router/root (primitives/get-initial-state RootRouter {})
                                  :navigation-bar/navigation-state {:navigation-bar/page-keys [:index :about :login]}}))}
  (dom/div #js {:key react-key}
    (navigation-bar-factory (primitives/computed navigation-state {:routing/route-fn! #(primitives/transact! this `[(routing/route-to {:handler ~%})])}))
    (dom/div #js {:className application-root}
      (root-router-factory root))))
