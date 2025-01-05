package kib.dev.tasks.models

const val INVALID_ID_MESSAGE = "Invalid ID format"
const val NOT_FOUND_MESSAGE = "Task not found"

// In-memory storage for MVP
object KTaskStorage {
    private val tasks = mutableMapOf<Int, KTask>()
    private var idCounter = 1

    fun create(task: KTask): KTask {
        val taskWithId = task.copy(id = idCounter++)
        tasks[taskWithId.id!!] = taskWithId
        return taskWithId
    }

    fun read(id: Int): KTask? = tasks[id]

    fun readAll(): List<KTask> = tasks.values.toList()

    fun update(id: Int, task: KTask): KTask? {
        if (tasks.containsKey(id)) {
            val updatedTask = task.copy(id = id)
            tasks[id] = updatedTask
            return updatedTask
        }
        return null
    }

    fun delete(id: Int): Boolean = tasks.remove(id) != null
}