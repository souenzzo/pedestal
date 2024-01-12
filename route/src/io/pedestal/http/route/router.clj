; Copyright 2024 Nubank NA
; Copyright 2013 Relevance, Inc.
; Copyright 2014-2022 Cognitect, Inc.

; The use and distribution terms for this software are covered by the
; Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0)
; which can be found in the file epl-v10.html at the root of this distribution.
;
; By using this software in any fashion, you are agreeing to be bound by
; the terms of this license.
;
; You must not remove this notice, or any other, from this software.

(ns io.pedestal.http.route.router)

(defprotocol Router
  "A Router is created from a routing table (see [[expand-routes]]).
  Each implementation of Router represents a different strategy for dispatching incoming requests,
  balancing a number of tradeoffs."
  (find-route [this req]
    "Given an incoming request, find the matching route (one route map from the routing table)."))
