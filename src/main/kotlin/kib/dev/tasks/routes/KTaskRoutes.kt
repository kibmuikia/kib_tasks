package kib.dev.tasks.routes

import io.ktor.server.routing.*
import kib.dev.tasks.handlers.KTaskHandler

fun Routing.configureTaskRoutes() {
    route("/tasks") {
        val taskHandler = KTaskHandler()

        post { taskHandler.createTask(this.call) }
        get { taskHandler.getAllTasks(this.call) }
        get("{id}") { taskHandler.getTaskById(this.call) }
        put("{id}") { taskHandler.updateTask(this.call) }
        delete("{id}") { taskHandler.deleteTask(this.call) }
    }
}