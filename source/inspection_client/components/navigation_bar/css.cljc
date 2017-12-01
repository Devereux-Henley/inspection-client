(ns inspection-client.components.navigation-bar.css
  (:require
   [inspection-client.assets.palette :as palette]))

(def css
  [[:.navigation-bar {:background-color palette/background-color
                      :display "flex"
                      :justify-content "flex-end"
                      :width "100%"}
    [:.navigation-link-group {:width "30%"
                              :display "flex"
                              :margin-top "2%"
                              :margin-right "8%"
                              :justify-content "space-between"}
     [:.navigation-link {:color palette/retro-green-text
                         :text-shadow palette/retro-green-text-shadow}
      [:&:hover {:color palette/retro-green-glowing-text}]]]]])

