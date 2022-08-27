(ns app.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [reagent.dom :as rdom]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]))

(def function-url (str (. js/window -location) "api/hello"))

(defn- invoke-function
  []
  (go (let [response (<! (http/get function-url))]
        (js/console.log (:body response)))))

(defn app
  []
  [:div.min-h-full.bg-white.flex.justify-center.items-center
   [:div.flex.flex-col.justify-center.items-center.px-4
    [:div.text-center
     [:h2.text-base.text-indigo-600.font-semiboldy.tracking-wide.uppercase
      "Welcome"]
     [:p.mt-2.text-3xl.leading-8.font-extrabold.tracking-tight.text-gray-900
      "Hello, ClojureScript!"]]
    [:div.py-5.text-center
     [:button.bg-indigo-500.hover:bg-indigo-700.text-white.font-bold.py-2.px-4.rounded
      {:on-click invoke-function}
      "Trigger Vercel Function"]]]])

(defn start []
  (rdom/render [app] (. js/document (getElementById "app"))))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (start))

(defn stop []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))
