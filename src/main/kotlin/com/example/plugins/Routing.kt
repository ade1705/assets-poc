package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/api/v1") {
            call.respondText("Hello World!")
            call.application.environment.log.info("Hello from /api/v1!")
        }
    }
}
