(ns inspection-client.assets.css
  (:require
   [inspection-client.assets.palette :as palette]))

(def global-css
  [[:.application-root {:height "100vh"
                        :width "100vw"
                        :display "flex"
                        :flex-direction "column"
                        :justify-content "center"
                        :align-items "center"
                        :font-family "Source Sans Pro"
                        :background-color palette/background-color}]])
