(ns inspection-client.validators.user
  (:require
   [fulcro.ui.forms :as fulcro-forms :refer [defvalidator]]))

(defvalidator email?
  [sym value args]
  (or (seq (re-matches #".*@.*\..*" value)) (not (empty? value))))

(defvalidator password?
  [sym value args]
  true)
