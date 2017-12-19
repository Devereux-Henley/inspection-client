(ns inspection-client.views.login.form.css
  (:require
   [garden.selectors :as selectors]
   [inspection-client.assets.palette :as palette]))

(selectors/defpseudoelement placeholder)

(defonce login-form-width
  "230px")

(def css
  [[:.login-button {:background palette/background-color
                    :border-color palette/border-color
                    :color palette/retro-green-glowing-text}
    [:&:focus {:border-color palette/input-border-color
               :outline "0"}]]])
