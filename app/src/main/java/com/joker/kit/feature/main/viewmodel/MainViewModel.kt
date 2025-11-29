package com.joker.kit.feature.main.viewmodel

import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 主界面 ViewModel
 *
 * @param navigator 导航控制器
 * @param userState 全局用户状态
 * @author Joker.X
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState
) : BaseViewModel(
    navigator = navigator,
    userState = userState
) {}
