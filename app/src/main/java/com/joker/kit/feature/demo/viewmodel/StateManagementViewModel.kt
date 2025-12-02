package com.joker.kit.feature.demo.viewmodel

import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.DemoCounterState
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * 状态管理示例页 ViewModel
 */
@HiltViewModel
class StateManagementViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
    private val counterState: DemoCounterState
) : BaseViewModel(navigator, userState) {

    /**
     * 对外暴露的计数器 StateFlow
     */
    val count: StateFlow<Int> = counterState.count

    /**
     * +1
     */
    fun increase() = counterState.increase()

    /**
     * -1
     */
    fun decrease() = counterState.decrease()

    /**
     * 重置为 0
     */
    fun reset() = counterState.reset()
}
