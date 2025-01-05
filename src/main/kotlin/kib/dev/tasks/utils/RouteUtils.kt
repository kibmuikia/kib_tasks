package kib.dev.tasks.utils

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

object RouteUtils {
    private const val INVALID_ID_MESSAGE = "Invalid ID format"

    suspend fun parseId(call: ApplicationCall): Int? {
        return call.parameters["id"]?.toIntOrNull()?.also { return it }
            ?: run {
                call.respond(HttpStatusCode.BadRequest, INVALID_ID_MESSAGE)
                return null
            }
    }
}