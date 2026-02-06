package com.joker.kit.feature.main.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.joker.kit.R
import com.joker.kit.core.database.entity.TaskEntity
import com.joker.kit.core.designsystem.component.SpaceVerticalMedium
import com.joker.kit.core.designsystem.theme.AppTheme
import com.joker.kit.core.designsystem.theme.BgFloatingActionButton
import com.joker.kit.core.designsystem.theme.BgWhiteLight
import com.joker.kit.core.ui.component.dialog.ToDoDialog
import com.joker.kit.core.ui.component.empty.TasksEmptyContent
import com.joker.kit.core.ui.component.scaffold.AppScaffold
import com.joker.kit.feature.main.component.ToDoItem
import com.joker.kit.feature.main.viewmodel.ToDoViewModel

/**
 * 待办路由
 *
 * @param viewModel 待办 ViewModel
 */
@Composable
internal fun ToDoRoute(
    viewModel: ToDoViewModel = hiltViewModel()
) {
    val completedTasks by viewModel.completedTasks.collectAsState()
    val tasks by viewModel.activeTasks.collectAsState()
    val task by viewModel.task.collectAsState()
    // 添加待办的对话框显示状态
    val showConfirmDialog by viewModel.toDoConfirmDialog.collectAsState()

    ToDoScreen(
        task = task,
        tasks = tasks,
        completedTasks = completedTasks,
        onInsertTaskClick = viewModel::showDialogClearData,
        onConfirmDialogDismiss = viewModel::hideConfirmDialog,
        onComplete = viewModel::insetTask,
        showConfirmDialog = showConfirmDialog,
        onTaskItemClick = viewModel::selectTask,
        onDialogInputValueChange = viewModel::updateTaskText,
        onTaskCheckedChange = viewModel::updateTaskState,
        onDeleteClick = viewModel::deleteTask
    )
}

/**
 * 待办界面
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ToDoScreen(
    task: TaskEntity = TaskEntity(),
    tasks: List<TaskEntity> = emptyList(),
    completedTasks: List<TaskEntity> = emptyList(),
    onInsertTaskClick: () -> Unit = {},
    showConfirmDialog: Boolean = false,
    onConfirmDialogDismiss: () -> Unit = {},
    onComplete: () -> Unit = {},
    onTaskCheckedChange: (TaskEntity, Boolean) -> Unit = { _, _ -> },
    onTaskItemClick: (TaskEntity) -> Unit = {},
    onDialogInputValueChange: (String) -> Unit = {},
    onDeleteClick: () -> Unit = {}
) {
    AppScaffold(
        isExcludeNavigationBar = true,
        titleText = "待办",
        showBackIcon = false,
        topBarColors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        floatingActionButton = {
            FloatingActionButton(
                onClick = onInsertTaskClick,
                containerColor = BgFloatingActionButton,
                contentColor = BgWhiteLight
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "新增"
                )
            }
        }
    ) {
        if (tasks.isEmpty() && completedTasks.isEmpty()) {
            TasksEmptyContent(
                noTasksLabel = R.string.empty_task_data,
                noTasksIconRes = R.drawable.logo_no_fill,
            )
        } else {
            ToDoContent(
                tasks = tasks,
                completedTasks = completedTasks,
                onTaskCheckChange = onTaskCheckedChange,
                onTaskItemClick = onTaskItemClick
            )
        }
    }

    if (showConfirmDialog) {
        ToDoDialog(
            task = task,
            onComplete = onComplete,
            onValueChange = onDialogInputValueChange,
            onCancel = onConfirmDialogDismiss,
            onDismiss = onConfirmDialogDismiss,
            onDeleteClick = onDeleteClick
        )
    }

}

/**
 * 待办内容视图
 *
 */
@Composable
private fun ToDoContent(
    tasks: List<TaskEntity>,
    completedTasks: List<TaskEntity>,
    onTaskCheckChange: (TaskEntity, Boolean) -> Unit,
    onTaskItemClick: (TaskEntity) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 10.dp),
    ) {
        items(tasks) { task ->
            ToDoItem(
                task = task,
                onCheckChange = { onTaskCheckChange(task, it) },
                onClick = onTaskItemClick
            )
            SpaceVerticalMedium()
        }
        if (completedTasks.isNotEmpty()) {
            item {
                Text("已完成")
                SpaceVerticalMedium()
            }
        }
        items(completedTasks) { task ->
            ToDoItem(
                task = task,
                onCheckChange = { onTaskCheckChange(task, it) },
                onClick = onTaskItemClick
            )
            SpaceVerticalMedium()
        }
    }
}

/**
 * 待办界面浅色主题预览
 */
@Preview(showBackground = true)
@Composable
internal fun ToDoPreview() {
    AppTheme {
        ToDoScreen()
    }
}

/**
 * 待办界面深色主题预览
 */
@Preview(showBackground = true)
@Composable
internal fun ToDoPreviewDark() {
    AppTheme(darkTheme = true) {
        ToDoScreen()
    }
}