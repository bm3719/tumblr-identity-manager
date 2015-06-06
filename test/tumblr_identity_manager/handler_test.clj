(ns tumblr-identity-manager.handler-test
  (:require [tumblr-identity-manager.utility :as util]
            [clojure.test :refer :all]
            [cheshire.core :as cheshire]
            [ring.mock.request :as mock]
            [tumblr-identity-manager.handler :refer :all]))

(deftest test-app
  (testing "identity route"
    (let [response (app (mock/request :get "/identity"))]
      (is (= (:status response) 200))
      (is (= (count (util/camel->kebab (cheshire/parse-string (:body response) true)))
             3))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
