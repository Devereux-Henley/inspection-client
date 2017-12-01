(ns inspection-client.components.navigation-bar
  (:require
   [clojure.string]
   [fulcro.client.core :as fulcro-client]
   [fulcro-css.css :as css]
   [inspection-client.components.navigation-bar.css :as navigation-css]
   [om.dom :as dom]
   [om.next :as om]))

(fulcro-client/defsc NavigationBar
  [this {:keys [navigation-bar/page-keys]} {:keys [routing/route-fn!]} children]
  {:query [:navigation-bar/page-keys]
   :css [navigation-css/css]
   :css-include []}
  (let [{:keys [navigation-bar navigation-link navigation-link-group]} (css/get-classnames NavigationBar)]
    (dom/div
     #js {:className navigation-bar}
     (dom/div
      #js {:className navigation-link-group}
      (map
       #(dom/a #js {:key %2 :className navigation-link :onClick (partial route-fn! %1)} (clojure.string/capitalize (name %1)))
       page-keys (range))))))

(defonce navigation-bar-factory (om/factory NavigationBar))
