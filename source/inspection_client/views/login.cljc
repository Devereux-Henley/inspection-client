(ns inspection-client.views.login
  (:require
   [fulcro-css.css :as css]
   [fulcro.ui.forms :as fulcro-forms]
   [inspection-client.views.login.css :as login-css]
   [inspection-client.views.login.form :as form]
   [fulcro.client.dom :as dom]
   [fulcro.client.primitives :as primitives]))

(primitives/defsc Login
  [this {:keys [form/login-form]} computed {:keys [login-page]}]
  {:query [:page {:form/login-form (primitives/get-query form/LoginForm)}]
   :css [login-css/css]
   :css-include [form/LoginForm]
   :initial-state (fn [params] {:page :login
                                :form/login-form (fulcro-forms/build-form
                                                   form/LoginForm
                                                   {:db/id 1
                                                    :user/email ""
                                                    :user/password ""})})}
  (dom/div
    #js {:className login-page}
    (form/login-form-factory login-form)))
