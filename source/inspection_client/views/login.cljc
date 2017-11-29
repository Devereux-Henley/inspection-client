(ns inspection-client.views.login
  (:require
   [fulcro-css.css :as css]
   [fulcro.client.core :as fulcro-client]
   [om.dom :as dom]
   [om.next :as om]))

(fulcro-client/defsc Login
  [this props computed children]
  {:query [:page]
   :initial-state {:page :login}}
  (dom/div nil "Login Page"))
