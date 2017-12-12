(ns inspection-client.views.registration.form
  (:require
   [fulcro-css.css :as css]
   [fulcro.ui.forms :as forms]
   [fulcro.client.dom :as dom]
   [fulcro.client.primitives :as primitives]))

(primitives/defsc RegistrationForm
  [this props computed classes]
  {:query [:db/id :registration/email :registration/password :registration/verification-password forms/form-key]
   :ident [:registration-form/by-id :db/id]
   :initial-state (fn [params] (forms/build-form this (or params {})))
   :form-fields [(forms/id-field :db/id)
                 (forms/html5-input :registration/email "email" :placeholder "Email")
                 (forms/html5-input :registration/password "password" :placeholder "Password")
                 (forms/html5-input :registration/verification-password "password" :placeholder "Verify Password")]
   :css [[]]
   :css-include []}
  (dom/div nil
    (dom/div nil
      (forms/form-field this props :registration/email))
    (dom/div nil
      (forms/form-field this props :registration/password))
    (dom/div nil
      (forms/form-field this props :registration/verification-password))))

(defonce registration-form-factory (primitives/factory RegistrationForm))
