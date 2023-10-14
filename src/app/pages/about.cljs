(ns app.pages.about
  (:require [ajax.core :refer [GET json-response-format]]
            [app.service.coincap :refer [api-base-url]]
            [app.components.historyitem :refer [historyitem]]
            [reagent.core :as r]
            [clojure.string :as string]))

(defonce asset (r/atom nil))
(defonce priceList (r/atom []))

(defn handler [response]
  (reset! priceList (map #(:priceUsd %) (:data response)))
  (reset! asset response))

(defn get-asset-by-name [name]
  (GET (str api-base-url (str "/assets/" name "/history?interval=d1"))
    {:handler handler
     :response-format (json-response-format {:keywords? true})}))

(defn aboutpage [params]
  (let [{:keys [path]} (:parameters params)
        {:keys [name]} path]
    (get-asset-by-name name)
    (fn []
      [:div.container.max-w-2xl.m-auto.h-screen.pt-12.px-4
       [:a {:href "/"} [:h1.text-3xl.font-bold.text-slate-800.mb-8.cursor-pointer (str "<" (string/capitalize name))]]
       [:ol.border-l.border-purple-100
        (for [asset (:data @asset)] (historyitem asset))]])))