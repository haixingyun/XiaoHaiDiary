package com.joker.kit.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joker.kit.core.database.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(tasK: TaskEntity)

    @Query("SELECT * FROM task_items ORDER BY updatedAt DESC")
    fun observeTask(): Flow<List<TaskEntity>>

    @Query("DELETE FROM task_items WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("SELECT * FROM task_items WHERE id = :id")
    suspend fun getTaskById(id: Long): TaskEntity
}