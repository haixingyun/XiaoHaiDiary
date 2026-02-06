package com.joker.kit.feature.main.viewmodel

import com.joker.kit.core.base.viewmodel.BaseNetWorkViewModel
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * 我的 ViewModel
 *
 * @param navigator 导航管理器
 * @param userState 用户状态管理
 */
@HiltViewModel
class MyViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
) : BaseNetWorkViewModel<Any>(navigator, userState) {
    // TODO: 注入仓库并实现 requestApiFlow()
    override fun requestApiFlow(): Flow<NetworkResponse<Any>> {
        TODO("Not yet implemented")
    }
}