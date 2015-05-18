(defproject tumblr-identity-manager "0.1.0-SNAPSHOT"
  :description "For great social justice!"
  :url "http://localhost:3000/"
  :license {:name "GNU Public License Version 3"
            :url "http://www.gnu.org/copyleft/gpl.html"}
  :dependencies [[cheshire "5.4.0"]
                 [compojure "1.3.4"]
                 [org.clojure/clojure "1.6.0"]
                 [org.clojure/core.memoize "0.5.7"]
                 [org.eclipse.jetty/jetty-servlet "7.6.1.v20120215"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-jetty-adapter "1.3.2"]]
  :plugins [[lein-ring "0.9.4"]]
  :ring {:handler tumblr-identity-manager.handler/app}
  :jvm-opts ["-Xmx128m"]
  :repl-options {:init-ns user}
  :global-vars {*print-length* 100}
  :profiles {:dev {:resource-paths ["dev"]
                   :dependencies [[javax.servlet/servlet-api "2.5"]
                                  [org.clojure/tools.namespace "0.2.10"]
                                  [ring-mock "0.1.5"]]}})
