package com.joker.kit.core.state

import com.joker.kit.core.state.di.ApplicationScope
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Demo 计数器状态
 *
 * 通过全局 StateFlow 演示如何在任意页面共享一个简单的计数器。
 *
 * @author Joker.X
 */
@Singleton
class DemoCounterState @Inject constructor(
    @param:ApplicationScope private val appScope: CoroutineScope
) {

    /**
     * 计数器值
     */
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()

    /**
     * +1
     */
    fun increase() {
        appScope.launch {
            _count.value += 1
        }
    }

    /**
     * -1，最低为 0
     */
    fun decrease() {
        appScope.launch {
            _count.value = (_count.value - 1).coerceAtLeast(0)
        }
    }

    /**
     * 重置
     */
    fun reset() {
        appScope.launch {
            _count.value = 0
        }
    }
}
