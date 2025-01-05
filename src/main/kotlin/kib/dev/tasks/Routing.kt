package kib.dev.tasks

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kib.dev.tasks.routes.configureTaskRoutes

fun Application.configureRouting() {
    routing {
        configureRootRoute()
        configureTaskRoutes()
    }
}

private fun Routing.configureRootRoute() {
    get("/") {
        call.respondText("Hello To KTasks !")
    }
}
