package kib.dev.tasks.services

import kib.dev.tasks.models.KTask
import kib.dev.tasks.repositories.KTaskRepository

class KTaskService(
    private val taskRepository: KTaskRepository = KTaskRepository()
) {
    fun createTask(task: KTask): KTask = taskRepository.create(task)

    fun getAllTasks(): List<KTask> = taskRepository.readAll()

    fun getTaskById(id: Int): KTask? = taskRepository.read(id)

    fun updateTask(id: Int, task: KTask): KTask? = taskRepository.update(id, task)

    fun deleteTask(id: Int): Boolean = taskRepository.delete(id)
}