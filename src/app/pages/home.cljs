(ns app.pages.home
  (:require
   [ajax.core :refer [GET json-response-format]]
   [reagent.core :as r]
   [app.service.coincap :refer [api-base-url]]
   [app.components.coinitem :refer [coinitem]]))

(defonce assets (r/atom []))

(defn get-assets []
  (GET (str api-base-url "/assets") {:handler (fn [response] (reset! assets response)) :response-format (json-response-format {:keywords? true})}))

(get-assets)

(defn homepage []
  (fn []
    [:div.container.max-w-2xl.m-auto.h-screen.pt-12.px-4
     [:h1.text-3xl.font-bold.text-slate-800 "Coin Tracker"]
     [:p.text-slate-600.mb-8 "Top 100 Criptomoedas por Capitalização de Mercado"]
     [:div.grid.grid-flow-row.gap-6.grid-cols-2.md:grid-cols-4
      (for [asset (:data @assets)]  (coinitem asset))]]))