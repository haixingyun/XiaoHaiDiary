package com.joker.kit.feature.main.viewmodel

import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.UserState
import com.joker.kit.feature.main.data.DemoCardData
import com.joker.kit.feature.main.model.DemoCardInfo
import com.joker.kit.navigation.AppNavigator
import com.joker.kit.navigation.results.DemoResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * Navigation Demo ViewModel
 */
@HiltViewModel
class NavigationDemoViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
) : BaseViewModel(
    navigator = navigator,
    userState = userState
) {

    private val _cards = MutableStateFlow(DemoCardData.navigationCards)
    val cards: StateFlow<List<DemoCardInfo>> = _cards.asStateFlow()

    /** 全局登录状态 */
    val isLoggedIn: StateFlow<Boolean> = userState.isLoggedIn

    private val _demoResult = MutableStateFlow<DemoResult?>(null)
    val demoResult: StateFlow<DemoResult?> = _demoResult.asStateFlow()

    fun onCardClick(info: DemoCardInfo) {
        info.route?.let { navigate(it) }
    }

    fun onResultReceived(result: DemoResult) {
        _demoResult.value = result
    }
}
