package com.joker.kit.feature.main.viewmodel

import com.joker.kit.core.base.viewmodel.BaseViewModel
import com.joker.kit.core.state.DemoCounterState
import com.joker.kit.core.state.UserState
import com.joker.kit.feature.main.data.DemoCardData
import com.joker.kit.feature.main.model.DemoCardInfo
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * Core Demo ViewModel
 */
@HiltViewModel
class CoreDemoViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
    counterState: DemoCounterState
) : BaseViewModel(
    navigator = navigator,
    userState = userState
) {

    private val _cards = MutableStateFlow(DemoCardData.coreCards)
    val cards: StateFlow<List<DemoCardInfo>> = _cards.asStateFlow()

    /** 全局计数器值 */
    val count: StateFlow<Int> = counterState.count

    fun onCardClick(info: DemoCardInfo) {
        info.route?.let { navigate(it) }
    }
}
