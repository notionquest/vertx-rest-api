package com.notionquest.restapi

import io.vertx.core.AbstractVerticle
import io.vertx.core.Promise
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext

class MainVerticle : AbstractVerticle() {

  override fun start(startPromise: Promise<Void>) {
    val router = Router.router(vertx)

    //Create route
    router.route("/")
      .handler { routingContext: RoutingContext ->
        val response = routingContext.response()
        response
          .putHeader("content-type", "text/html")
          .end("<h1>Hello World!!</h1>")
      }

    //Create route
    router.route("/hello")
      .handler { routingContext: RoutingContext ->
        val response = routingContext.response()
        response
          .putHeader("content-type", "text/html")
          .end("<h1>Hello World!!</h1>")
      }

    //Create server
    val server = vertx.createHttpServer()

    //Start the server
    server.requestHandler(router).listen(8888) { http ->
      if (http.succeeded()) {
        startPromise.complete()
        println("HTTP server started on port 8888")
      } else {
        startPromise.fail(http.cause());
      }
    }
  }
}
