(ns app.components.coinitem
  (:require [clojure.string :as string]))

(defn coinitem [asset]
  [:a {:href (string/lower-case (:name asset))}
   [:div.flex.cursor-pointer.transition-all.flex-col.items-center.bg-indigo-50.p-4.rounded-md.hover:-translate-y-2 {:key (:id asset)}
    [:img.w-16.h-16.mb-4 {:src (string/lower-case (str "https://cryptocurrencyliveprices.com/img/" (:symbol asset) "-" (:name asset) ".png"))}]
    [:div.flex.items-center.gap-1.w-full
     [:h2.text-slate-800.text-lg.font-bold.truncate.w-full (:name asset)]
     [:p.text-slate-600 (:symbol asset)]]
    [:p.truncate.w-full (str "$" (:priceUsd asset))]]])