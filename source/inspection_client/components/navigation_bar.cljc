(ns inspection-client.components.navigation-bar
  (:require
   [om.dom :as dom]
   [om.next :as om]))

(om/defui ^:once NavigationBar
  static om/IQuery
  (query
    [this]
    [:navigation-bar/page-keys])
  Object
  (render
    [this]
    (let [{:keys [navigation-bar/page-keys]} (om/props this)
          {:keys [routing/route-fn!]} (om/get-computed this)]
      (dom/div
        #js {:className "navigation-bar"}
        (map #(dom/a #js {:key %2 :onClick (partial route-fn! %1)} (name %1)) page-keys (range))))))

(defonce navigation-bar-factory (om/factory NavigationBar))
