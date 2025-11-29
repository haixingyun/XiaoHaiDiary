package com.joker.kit.feature.auth.viewmodel

import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 登录页 ViewModel
 *
 * @param navigator 导航管理器
 * @param userState 全局用户状态
 * @author Joker.X
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState
) : BaseViewModel(
    navigator = navigator,
    userState = userState
)
