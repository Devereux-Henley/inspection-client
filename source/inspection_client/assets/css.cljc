(ns inspection-client.assets.css
  (:require
   [inspection-client.assets.palette :as palette]))

(def global-css
  [[:body {:height "100%"
           :width "100%"
           :display "flex"
           :justify-content "flex-start"
           :flex-direction "column"
           :font-family "Source Sans Pro"
           :background-color palette/background-color}]
   [:.application-root
    {:display "flex"
     :justify-content "center"
     :align-items "center"
     :height "100%"
     :width "100%"}]])
