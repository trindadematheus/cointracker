(ns app.components.historyitem)

(defn historyitem [item]
  [:div.mb-4.bg-indigo-50.p-4.rounded-md
   [:p.font-bold.text-slate-800 (:date item)]
   [:p.text-slate-600 (str "$" (:priceUsd item))]])