(ns inspection-client.views.login.form
  (:require
   [fulcro-css.css :as css]
   [fulcro.ui.forms :as forms]
   [inspection-client.views.login.form.css :as form-css]
   [fulcro.client.dom :as dom]
   [fulcro.client.primitives :as primitives]))

(primitives/defsc LoginForm
  [this props computed {:keys [form form-field login-button-wrapper login-button]}]
  {:initial-state (fn [params]
                    (forms/build-form this (or params {})))
   :form-fields [(forms/id-field :db/id)
                 (forms/html5-input :user/email "email" :placeholder "Email")
                 (forms/html5-input :user/password "password" :placeholder "Password")]
   :query [:db/id :user/email :user/password forms/form-key]
   :ident [:login-form/by-id :db/id]
   :css [form-css/css]
   :css-include []}
  (dom/div #js {:className form}
    (dom/div #js {:className form-field}
      (forms/form-field this props :user/email))
    (dom/div #js {:className form-field}
      (forms/form-field this props :user/password))
    (dom/div #js {:className login-button-wrapper}
      (dom/button #js {:className login-button
                       :onClick #(.alert js/window "Log In!")}
        "Log In"))))

(defonce login-form-factory (primitives/factory LoginForm))
