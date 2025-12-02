package com.joker.kit.feature.demo.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joker.kit.feature.demo.view.LocalStorageRoute
import com.joker.kit.navigation.routes.DemoRoutes

/**
 * 本地存储示例页面导航
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.localStorageScreen(sharedTransitionScope: SharedTransitionScope) {
    composable<DemoRoutes.LocalStorage> {
        LocalStorageRoute()
    }
}
