package kib.dev.tasks.repositories

import kib.dev.tasks.models.KTask
import kib.dev.tasks.models.KTaskStorage

class KTaskRepository {
    private val storage = KTaskStorage

    fun create(task: KTask): KTask = storage.create(task)

    fun read(id: Int): KTask? = storage.read(id)

    fun readAll(): List<KTask> = storage.readAll()

    fun update(id: Int, task: KTask): KTask? = storage.update(id, task)

    fun delete(id: Int): Boolean = storage.delete(id)
}