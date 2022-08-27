(ns functions.api)

(defn handler
  [_request response]
  (-> response
      (.status 200)
      (.send "hello world")))
