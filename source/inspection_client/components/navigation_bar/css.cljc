(ns inspection-client.components.navigation-bar.css
  (:require
   [inspection-client.assets.palette :as palette]))

(def css
  [[:.navigation-bar {:background-color palette/background-color
                      :display "flex"
                      :justify-content "center"
                      :height "10%"
                      :width "100%"}
    [:.navigation-link-group {:width "24%"
                              :display "flex"
                              :margin-top "2%"
                              :justify-content "center"}
     [:.navigation-link {:color palette/retro-green-text
                         :cursor "pointer"
                         :margin-left "12px"
                         :margin-right "12px"
                         :font-weight "bold"
                         :font-size "15px"
                         :text-shadow palette/retro-green-text-shadow}
      [:&:hover {:color palette/retro-green-glowing-text}]]]]])

