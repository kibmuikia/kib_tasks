package kib.dev.tasks.handlers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import kib.dev.tasks.models.KTask
import kib.dev.tasks.services.KTaskService
import kib.dev.tasks.utils.RouteUtils.parseId

class KTaskHandler(
    private val taskService: KTaskService = KTaskService()
) {
    suspend fun createTask(call: ApplicationCall) {
        val task = call.receive<KTask>()
        val createdTask = taskService.createTask(task)
        call.respond(HttpStatusCode.Created, createdTask)
    }

    suspend fun getAllTasks(call: ApplicationCall) {
        call.respond(taskService.getAllTasks())
    }

    suspend fun getTaskById(call: ApplicationCall) {
        val id = parseId(call) ?: return
        taskService.getTaskById(id)?.let { task ->
            call.respond(task)
        } ?: call.respond(HttpStatusCode.NotFound, NOT_FOUND_MESSAGE)
    }

    suspend fun updateTask(call: ApplicationCall) {
        val id = parseId(call) ?: return
        val task = call.receive<KTask>()

        taskService.updateTask(id, task)?.let { updatedTask ->
            call.respond(updatedTask)
        } ?: call.respond(HttpStatusCode.NotFound, NOT_FOUND_MESSAGE)
    }

    suspend fun deleteTask(call: ApplicationCall) {
        val id = parseId(call) ?: return
        if (taskService.deleteTask(id)) {
            call.respond(HttpStatusCode.NoContent)
        } else {
            call.respond(HttpStatusCode.NotFound, NOT_FOUND_MESSAGE)
        }
    }

    companion object {
        private const val NOT_FOUND_MESSAGE = "Task not found"
    }
}