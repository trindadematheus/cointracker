(ns functions.api)

(defn handler
  [_request _response]
  (clj->js {:statusCode 200 :body "hello world"}))
