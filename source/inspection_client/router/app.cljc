(ns inspection-client.router.app
  (:require
   [fulcro.client.routing :refer [defrouter]]
   [inspection-client.views.about :refer [About]]
   [inspection-client.views.index :refer [Index]]
   [fulcro.client.primitives :as primitives]))

(defrouter AppRouter :router/app
  (ident [this props [(:page props) :app]])
  :index Index
  :about About)

(defonce app-router-factory (primitives/factory AppRouter))
