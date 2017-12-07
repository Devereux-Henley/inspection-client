(ns inspection-client.components.navigation-bar
  (:require
   [clojure.string]
   [fulcro-css.css :as css]
   [inspection-client.components.navigation-bar.css :as navigation-css]
   [fulcro.client.dom :as dom]
   [fulcro.client.primitives :as primitives]))

(primitives/defsc NavigationBar
  [this {:keys [navigation-bar/page-keys]} {:keys [routing/route-fn!]} {:keys [navigation-bar navigation-link navigation-link-group]}]
  {:query [:navigation-bar/page-keys]
   :css [navigation-css/css]
   :css-include []}
  (dom/div
    #js {:className navigation-bar}
    (dom/div
      #js {:className navigation-link-group}
      (map
        #(dom/a #js {:key %2 :className navigation-link :onClick (partial route-fn! %1)} (clojure.string/capitalize (name %1)))
        page-keys (range)))))

(defonce navigation-bar-factory (primitives/factory NavigationBar))
