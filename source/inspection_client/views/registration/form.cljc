(ns inspection-client.views.registration.form
  (:require
   [fulcro-css.css :as css]
   [fulcro.ui.forms :as forms]
   [fulcro.client.dom :as dom]
   [fulcro.client.primitives :as primitives]
   [inspection-client.assets.form.css :as form-css]
   [inspection-client.validators.user :as user-validators]))

(primitives/defsc RegistrationForm
  [this props computed {:keys [form form-field]}]
  {:query [:db/id :registration/email :registration/password :registration/verification-password forms/form-key]
   :ident [:registration-form/by-id :db/id]
   :initial-state (fn [params] (forms/build-form this (or params {})))
   :form-fields [(forms/id-field :db/id)
                 (forms/html5-input :registration/email "email" :placeholder "Email" :validator `user-validators/email?)
                 (forms/html5-input :registration/password "password" :placeholder "Password")
                 (forms/html5-input :registration/verification-password "password" :placeholder "Verify Password")]
   :css [form-css/css]
   :css-include []}
  (dom/div #js {:className form}
    (dom/div #js {:className form-field}
             (forms/form-field this props :registration/email)
             (when (forms/invalid? props :registration/email) (dom/p nil "Email is invalid.")))
    (dom/div #js {:className form-field}
      (forms/form-field this props :registration/password))
    (dom/div #js {:className form-field}
      (forms/form-field this props :registration/verification-password))))

(defonce registration-form-factory (primitives/factory RegistrationForm))
