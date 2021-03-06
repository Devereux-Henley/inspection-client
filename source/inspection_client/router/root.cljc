(ns inspection-client.router.root
  (:require
   [fulcro.client.routing :refer [defrouter]]
   [inspection-client.views.about :refer [About]]
   [inspection-client.views.index :refer [Index]]
   [inspection-client.views.login :refer [Login]]
   [inspection-client.views.registration :refer [Registration]]
   [fulcro.client.primitives :as primitives]))

(defrouter RootRouter :router/root
  (ident [this props] [(:page props) :root])
  :index Index
  :about About
  :login Login
  :registration Registration)

(defonce root-router-factory (primitives/factory RootRouter))
