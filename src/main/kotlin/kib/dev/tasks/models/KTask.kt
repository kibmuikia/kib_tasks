package kib.dev.tasks.models

import kotlinx.serialization.Serializable

@Serializable
data class KTask(
    val id: Int? = null,
    val title: String,
    val description: String,
    val isCompleted: Boolean = false
)
