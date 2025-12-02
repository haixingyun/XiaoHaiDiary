package com.joker.kit.feature.demo.viewmodel

import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import com.joker.kit.navigation.results.DemoResult
import com.joker.kit.navigation.results.DemoResultKey
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 结果回传示例页 ViewModel
 */
@HiltViewModel
class NavigationResultViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState
) : BaseViewModel(
    navigator = navigator,
    userState = userState
) {
    fun sendResultAndBack() {
        popBackStackWithResult(
            DemoResultKey,
            DemoResult(id = 9527, message = "这是回传的结果")
        )
    }
}
