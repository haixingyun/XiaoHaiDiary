package com.joker.kit.feature.demo.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

/**
 * Demo 模块导航图
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.demoGraph(
    navController: NavHostController,
    sharedTransitionScope: SharedTransitionScope
) {
    networkDemoScreen(sharedTransitionScope)
    networkListDemoScreen(sharedTransitionScope)
    databaseScreen(sharedTransitionScope)
    localStorageScreen(sharedTransitionScope)
    stateManagementScreen(sharedTransitionScope)
    networkRequestScreen(sharedTransitionScope)
    navigationWithArgsScreen(sharedTransitionScope)
    navigationResultScreen(sharedTransitionScope)
}
