package com.joker.kit.core.database.datasource.task

import com.joker.kit.core.database.dao.TaskDao
import com.joker.kit.core.database.entity.TaskEntity
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class TaskDataSource @Inject constructor(
    private val taskDao: TaskDao
) {
    fun observeCart(): Flow<List<TaskEntity>> = taskDao.observeTask()  // Flow 供 UI 订阅

    suspend fun addOrUpdate(item: TaskEntity) = taskDao.upsert(item.copy(
        updatedAt = System.currentTimeMillis()                          // 自动刷新时间
    ))
    suspend fun remove(id: Long) = taskDao.deleteById(id)              // 删除单条

    suspend fun selectTask(id: Long) = taskDao.getTaskById(id)
}