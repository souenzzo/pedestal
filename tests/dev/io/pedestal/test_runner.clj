; Copyright 2024 Nubank NA

; The use and distribution terms for this software are covered by the
; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0)
; which can be found in the file epl-v10.html at the root of this distribution.
;
; By using this software in any fashion, you are agreeing to be bound by
; the terms of this license.
;
; You must not remove this notice, or any other, from this software.

(ns io.pedestal.test-runner
  (:require [cognitect.test-runner.api :as api]
            [br.dev.zz.pedestal-container-tests.runner :as pct.runner])
  (:refer-clojure :exclude [test]))

(defn test
  "Wrapper around normal test-runner that shuts agents down on completion."
  [options]
  (api/test options)
  (System/setProperty "br.dev.zz.pedestal-container-tests.type" ":jetty")
  (doseq [test-ns pct.runner/namespaces]
    (requiring-resolve (symbol (str test-ns) "_")))
  (apply clojure.test/run-tests pct.runner/namespaces)
  ;; Process hangs after completion; if we get this far, kill the process.
  (System/exit 0))
