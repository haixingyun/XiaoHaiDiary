package com.joker.kit.feature.demo.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joker.kit.feature.demo.view.NavigationResultRoute
import com.joker.kit.navigation.routes.DemoRoutes

/**
 * 结果回传示例页面导航
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.navigationResultScreen(sharedTransitionScope: SharedTransitionScope) {
    composable<DemoRoutes.NavigationResult> {
        NavigationResultRoute()
    }
}
