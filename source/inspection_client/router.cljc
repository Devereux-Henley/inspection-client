(ns inspection-client.router
  (:require
   [fulcro.client.routing :as routing]))

(defonce routing-tree
  (routing/routing-tree
    (routing/make-route
      :index
      [(routing/router-instruction :router/root [:index :root])])
    (routing/make-route
      :about
      [(routing/router-instruction :router/root [:about :root])])
    (routing/make-route
      :login
      [(routing/router-instruction :router/root [:login :root])])
    (routing/make-route
      :registration
      [(routing/router-instruction :router/root [:registration :root])])
    ))
