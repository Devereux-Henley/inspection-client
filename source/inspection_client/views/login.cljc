(ns inspection-client.views.login
  (:require
   [fulcro-css.css :as css]
   [fulcro.client.core :as fulcro-client]
   [fulcro.ui.forms :as fulcro-forms]
   [inspection-client.views.login.css :as login-css]
   [inspection-client.views.login.form :as form]
   [om.dom :as dom]
   [om.next :as om]))

(fulcro-client/defsc Login
  [this {:keys [form/login-form]} computed children]
  {:query [:page {:form/login-form (om/get-query form/LoginForm)}]
   :css [login-css/css]
   :css-include [form/LoginForm]
   :initial-state (fn [this params] {:page :login
                                     :form/login-form (fulcro-forms/build-form
                                                        form/LoginForm
                                                        {:db/id 1
                                                         :user/email ""
                                                         :user/password ""})})}
  (let [{:keys [login-page]} (css/get-classnames Login)]
    (dom/div
      #js {:className login-page}
      (form/login-form-factory login-form))))
