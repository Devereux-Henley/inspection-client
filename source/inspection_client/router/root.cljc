(ns inspection-client.router.root
  (:require
   [fulcro.client.routing :refer [defrouter]]
   [inspection-client.views.login :refer [Login]]
   [inspection-client.views.registration :refer [Registration]]
   [fulcro.client.primitives :as primitives]))

(defrouter RootRouter :router/root
  (ident [this props] [(:page props) :root])
  :login Login
  :registration Registration)

(defonce root-router-factory (primitives/factory RootRouter))
