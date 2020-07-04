package com.notionquest.restapi

import io.vertx.core.Vertx

fun main() {
  Vertx.vertx().deployVerticle(MainVerticle())
}
