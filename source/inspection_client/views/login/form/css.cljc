(ns inspection-client.views.login.form.css
  (:require
   [garden.selectors :as selectors]
   [inspection-client.assets.palette :as palette]))

(selectors/defpseudoelement placeholder)

(defonce login-form-width
  "230px")

(def css
  [[:.form {:display "flex"
            :flex-direction "column"
            :justify-content "center"
            :align-items "center"}]
   [:.login-button {:background palette/background-color
                    :border-color palette/border-color
                    :color palette/retro-green-glowing-text}
    [:&:focus {:border-color palette/input-border-color
               :outline "0"}]]
   [:.form-field {:display "flex"
                  :flex-direction "column"
                  :justify-content "center"
                  :align-items "center"
                  :margin-top "10px"
                  :margin-bottom "10px"
                  :width "325px"}
    [:input {:width login-form-width
             :background-color palette/background-color
             :border-color palette/input-border-color
             :color palette/retro-green-glowing-text
             :caret-color palette/retro-green-glowing-text}]
    [(selectors/selector (selectors/input placeholder)) {:color palette/retro-green-glowing-text
                                                         :text-shadow palette/retro-green-text-shadow}]]])
