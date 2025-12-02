package com.joker.kit.navigation.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.joker.kit.navigation.NavigationResultKey

/**
 * 监听返回结果扩展
 */
@Composable
fun <T> NavController.observeResult(
    key: NavigationResultKey<T>,
    onResult: (T) -> Unit
) {
    val backStackEntry = currentBackStackEntry ?: return
    val savedStateHandle = backStackEntry.savedStateHandle

    DisposableEffect(backStackEntry, key) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                val raw = savedStateHandle.get<Any?>(key.key)
                if (raw != null) {
                    val result = key.deserialize(raw)
                    onResult(result)
                    savedStateHandle.remove<Any?>(key.key)
                }
            }
        }
        backStackEntry.lifecycle.addObserver(observer)
        onDispose {
            backStackEntry.lifecycle.removeObserver(observer)
        }
    }
}
