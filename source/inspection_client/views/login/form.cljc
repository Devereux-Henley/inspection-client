(ns inspection-client.views.login.form
  (:require
   [fulcro.client.core :as fulcro-client]
   [fulcro-css.css :as css]
   [fulcro.ui.forms :as forms]
   [inspection-client.views.login.form.css :as form-css]
   [om.dom :as dom]
   [om.next :as om]))

(fulcro-client/defsc LoginForm
  [this props computed children]
  {:initial-state (fn [this params]
                    (forms/build-form this (or params {})))
   :form-fields [(forms/id-field :db/id)
                 (forms/html5-input :user/email "email" :placeholder "Email")
                 (forms/html5-input :user/password "password" :placeholder "Password")]
   :query [:db/id :user/email :user/password forms/form-key]
   :ident [:login-form/by-id :db/id]
   :css [form-css/css]
   :css-include []}
  (let [{:keys [form form-field login-button-wrapper login-button]} (css/get-classnames LoginForm)]
    (dom/div #js {:className form}
      (dom/div #js {:className form-field}
        (forms/form-field this props :user/email))
      (dom/div #js {:className form-field}
        (forms/form-field this props :user/password))
      (dom/div #js {:className login-button-wrapper}
        (dom/button #js {:className login-button
                         :onClick #(.alert js/window "Log In!")}
          "Log In")))))

(defonce login-form-factory (om/factory LoginForm))
