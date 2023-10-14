(ns app.components.historyitem)

(defn historyitem [item]
  [:li
   [:div.flex-start.flex.items-center.pt-3
    [:div {:class "-ml-[5px] mr-3 h-[9px] w-[9px] rounded-full bg-purple-700"}]
    [:p.text-sm.text-slate-600 (:date item)]]
   [:div.mb-6.ml-4.mt-2
    [:h4.mb-1.5.text-xl.font-semibold.text-slate-800 (str "$" (:priceUsd item))]]])