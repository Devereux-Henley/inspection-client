(ns inspection-client.assets.css
  (:require
   [inspection-client.assets.palette :as palette]))

(def global-css
  [[:body {:height "100vh"
           :width "100vw"
           :margin 0
           :display "flex"
           :justify-content "center"
           :flex-direction "column"
           :font-family "Source Sans Pro"
           :background-color palette/background-color}]
   [:#app {:height "100%" :width "100%"}]
   [:.page-root {:height "100%" :width "100%"}]
   [:.application-root
    {:display "flex"
     :justify-content "center"
     :align-items "center"
     :height "80%"
     :width "100%"}]])
