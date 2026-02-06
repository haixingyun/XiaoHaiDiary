package com.joker.kit.feature.main.viewmodel

import android.R.attr.text
import androidx.lifecycle.viewModelScope
import com.hjq.toast.Toaster
import com.joker.kit.core.base.viewmodel.BaseNetWorkViewModel
import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.data.repository.DemoRepository
import com.joker.kit.core.data.repository.TaskRepository
import com.joker.kit.core.database.entity.DemoEntity
import com.joker.kit.core.database.entity.TaskEntity
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.state.UserState
import com.joker.kit.core.util.toast.ToastUtils
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.NonCancellable.isCompleted
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 待办 ViewModel
 *
 * @param navigator 导航管理器
 * @param userState 用户状态管理
 */
@HiltViewModel
class ToDoViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
    private val taskRepository: TaskRepository
) : BaseViewModel(navigator, userState) {

    /**
     * 添加待办对话框的显示状态
     */
    private val _toDoConfirmDialog = MutableStateFlow(false)
    val toDoConfirmDialog: StateFlow<Boolean> = _toDoConfirmDialog.asStateFlow()

    /**
     * 当前对话框显示的任务
     */
    private val _task = MutableStateFlow(TaskEntity())
    val task: StateFlow<TaskEntity> = _task.asStateFlow()

    /**
     * 任务数据流
     */
    val items: StateFlow<List<TaskEntity>> = taskRepository
        .observeTask()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    /**
     * 已经完成的任务
     */
    val completedTasks: StateFlow<List<TaskEntity>> =
        items
            .map { list ->
                list.filter { it.isCompleted }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )

    /**
     * 未完成的任务
     */
    val activeTasks: StateFlow<List<TaskEntity>> =
        items
            .map { list ->
                list.filter { !it.isCompleted }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )


    /**
     * 隐藏添加待办对话框
     */
    fun hideConfirmDialog() {
        _toDoConfirmDialog.value = false
    }

    /**
     * 打开对话框
     */
    fun showConfirmDialog() {
        _toDoConfirmDialog.value = true
    }

    /**
     * 打开对话框并清除_task  (新增任务悬浮按钮)
     */
    fun showDialogClearData() {
        _task.value = TaskEntity()
        showConfirmDialog()
    }

    /**
     * 新增任务 (点击对话框确定)
     */
    fun insetTask() {
        hideConfirmDialog()
        val text = _task.value.text.trim()
        if (text.isBlank()) return
        viewModelScope.launch {
            taskRepository.addItem(_task.value)
        }
    }

    /**
     * 查询任务
     */
    fun selectTask(task: TaskEntity) {
        _toDoConfirmDialog.value = true
        viewModelScope.launch {
            _task.value = taskRepository.selectTask(task.id)
        }
    }

    /**
     * 更新对话框里的当前文本
     */
    fun updateTaskText(taskText: String) {
        _task.value = _task.value.copy(
            text = taskText,
            updatedAt = System.currentTimeMillis()
        )
    }

    /**
     * 更新任务状态
     */
    fun updateTaskState(task: TaskEntity, isCompleted: Boolean) {
        if (task.isCompleted == isCompleted) return
        val newTask = task.copy(
            isCompleted = isCompleted,
        )
        viewModelScope.launch {
            taskRepository.addItem(newTask)
        }
    }

    /**
     * 删除任务
     */
    fun deleteTask() {
        hideConfirmDialog()
        viewModelScope.launch {
            taskRepository.removeItem(_task.value.id)
        }
        ToastUtils.showError("删除成功")
    }


}