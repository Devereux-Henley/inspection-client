(ns inspection-client.views.registration
  (:require
   [fulcro-css.css :as css]
   [fulcro.ui.forms :as fulcro-forms]
   [fulcro.client.dom :as dom]
   [fulcro.client.primitives :as primitives]
   [inspection-client.views.registration.form :as form]))

(primitives/defsc Registration
  [this {:keys [form/registration-form]} computed classes]
  {:query [:page {:form/registration-form (primitives/get-query form/RegistrationForm)}]
   :css [[]]
   :css-include []
   :initial-state (fn [params] {:page :registration
                                :form/registration-form (fulcro-forms/build-form
                                                          form/RegistrationForm
                                                          {:db/id 1
                                                           :registration/email ""
                                                           :registration/password ""
                                                           :registration/verification-password ""})})}
  (dom/div
    nil
    (form/registration-form-factory registration-form)))
