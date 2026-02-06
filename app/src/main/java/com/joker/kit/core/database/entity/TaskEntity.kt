package com.joker.kit.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_items")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var text: String = "",
    val isCompleted: Boolean = false,
    val updatedAt: Long = System.currentTimeMillis()
)