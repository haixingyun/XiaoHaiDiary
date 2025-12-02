package com.joker.kit.feature.demo.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joker.kit.feature.demo.view.NetworkRequestRoute
import com.joker.kit.navigation.routes.DemoRoutes

/**
 * 网络请求示例页面导航
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.networkRequestScreen(sharedTransitionScope: SharedTransitionScope) {
    composable<DemoRoutes.NetworkRequest> {
        NetworkRequestRoute()
    }
}
