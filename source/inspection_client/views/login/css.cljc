(ns inspection-client.views.login.css
  (:require
   [inspection-client.assets.palette :as palette]))

(def css
  [[:.login-page {:background-color palette/background-color
                  :display "flex"
                  :flex-direction "column"
                  :justify-content "center"
                  :align-items "center"
                  :width "35vw"
                  :min-width "450px"
                  :height "45vh"
                  :border-style "solid"
                  :border-width "3px"
                  :border-color palette/border-color}]])
