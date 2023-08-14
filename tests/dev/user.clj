(ns user
  (:require [clj-commons.pretty.repl :as repl]
            [net.lewisship.trace :as trace]))

(repl/install-pretty-exceptions)
(trace/setup-default)

(trace/trace :tracing-enabled true)

(trace/set-enable-trace! false)

(set! *warn-on-reflection* true)

(comment


  (trace/set-enable-trace! true)
  )
