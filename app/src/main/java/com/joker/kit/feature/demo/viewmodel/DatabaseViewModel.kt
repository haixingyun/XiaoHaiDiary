package com.joker.kit.feature.demo.viewmodel

import androidx.lifecycle.viewModelScope
import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.data.repository.DemoRepository
import com.joker.kit.core.database.entity.DemoEntity
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 数据库示例页 ViewModel
 *
 * @param navigator 导航管理器
 * @param userState 用户状态管理
 * @param demoRepository Demo 仓库，封装 DemoDataSource 的增删改查
 */
@HiltViewModel
class DatabaseViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
    private val demoRepository: DemoRepository
) : BaseViewModel(navigator, userState) {

    /** 标题输入 */
    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title.asStateFlow()

    /** 描述输入 */
    private val _description = MutableStateFlow("")
    val description: StateFlow<String> = _description.asStateFlow()

    /**
     * Demo 表数据流
     * UI 侧直接 collectAsState() 获取最新列表
     */
    val items: StateFlow<List<DemoEntity>> = demoRepository
        .observeItems()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    /**
     * 更新标题输入
     *
     * @param value 文本框中的标题
     */
    fun onTitleChange(value: String) {
        _title.value = value
    }

    /**
     * 更新描述输入
     *
     * @param value 文本框中的描述
     */
    fun onDescriptionChange(value: String) {
        _description.value = value
    }

    /**
     * 新增一条记录（仅当标题非空）
     */
    fun addItem() {
        val title = _title.value.trim()
        if (title.isBlank()) return
        viewModelScope.launch {
            demoRepository.createItem(
                title = title,
                description = _description.value.trim()
            )
            // 重置输入框
            _title.value = ""
            _description.value = ""
        }
    }

    /**
     * 删除指定记录
     *
     * @param id 记录主键
     */
    fun deleteItem(id: Long) {
        viewModelScope.launch {
            demoRepository.deleteItem(id)
        }
    }

    /**
     * 清空全部记录
     */
    fun clearAll() {
        viewModelScope.launch {
            demoRepository.clearAll()
        }
    }
}
