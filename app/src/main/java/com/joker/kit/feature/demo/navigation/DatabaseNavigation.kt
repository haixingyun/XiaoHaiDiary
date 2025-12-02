package com.joker.kit.feature.demo.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joker.kit.feature.demo.view.DatabaseRoute
import com.joker.kit.navigation.routes.DemoRoutes

/**
 * 数据库示例页面导航
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.databaseScreen(sharedTransitionScope: SharedTransitionScope) {
    composable<DemoRoutes.Database> {
        DatabaseRoute()
    }
}
