package com.joker.kit.core.data.repository

import android.util.Log
import com.joker.kit.core.database.datasource.task.TaskDataSource
import com.joker.kit.core.database.entity.TaskEntity
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class TaskRepository @Inject constructor(
    private val taskDataSource: TaskDataSource
) {
    fun observeTask(): Flow<List<TaskEntity>> = taskDataSource.observeCart()   // 直接转发

    suspend fun addItem(task: TaskEntity) = taskDataSource.addOrUpdate(task)  // 业务入参转实体


    suspend fun removeItem(id: Long) = taskDataSource.remove(id)

    suspend fun selectTask(id: Long) = taskDataSource.selectTask(id)
}