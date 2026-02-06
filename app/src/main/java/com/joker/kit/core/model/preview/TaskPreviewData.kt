package com.joker.kit.core.model.preview

import com.joker.kit.core.database.entity.TaskEntity

val todoTaskEntitys = listOf(
    TaskEntity(
        id = 1,
        text = "学习 Jetpack Compose 基础",
        isCompleted = false
    ),
    TaskEntity(
        id = 2,
        text = "完成 ToDo 列表展开/收起效果",
        isCompleted = false
    ),
    TaskEntity(
        id = 3,
        text = "整理项目结构（ViewModel + UIState）",
        isCompleted = false
    )
)


val completedTaskEntitys = listOf(
    TaskEntity(
        id = 4,
        text = "创建 TaskEntity 数据模型",
        isCompleted = true
    ),
    TaskEntity(
        id = 5,
        text = "实现 Checkbox 勾选完成状态",
        isCompleted = true
    )
)
