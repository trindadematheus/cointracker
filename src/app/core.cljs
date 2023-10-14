(ns app.core
  (:require [reagent.dom :as rdom]
            [reitit.frontend :as rf]
            [reitit.frontend.easy :as rfe]
            [reitit.coercion.spec :as rss]
            [reagent.core :as r]
            [app.pages.home :refer [homepage]]
            [app.pages.about :refer [aboutpage]]))

(defonce match (r/atom nil))

(defn current-page []
  [:div
   (if @match
     (let [view (:view (:data @match))]
       [view @match]))])

(def routes
  [["/"
    {:name ::homepage
     :view homepage}]

   ["/:name"
    {:name ::about
     :view aboutpage
     :paramters {:path {:name str}}}]])

(defn init! []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion}})
   (fn [m] (reset! match m))
    ;; set to false to enable HistoryAPI
   {:use-fragment false})
  (rdom/render [current-page] (.getElementById js/document "app")))

(init!)