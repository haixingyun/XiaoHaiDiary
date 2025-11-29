package com.joker.kit.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.joker.kit.feature.auth.navigation.authGraph
import com.joker.kit.feature.main.navigation.mainGraph
import com.joker.kit.feature.user.navigation.userGraph
import com.joker.kit.navigation.routes.MainRoutes
import kotlinx.coroutines.flow.collectLatest

/**
 * 应用导航宿主
 * 配置整个应用的导航图和动画
 *
 * @param navigator 导航管理器
 * @param modifier 修饰符
 * @author Joker.X
 */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavHost(
    navigator: AppNavigator,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    // 监听导航事件
    LaunchedEffect(navController) {
        navigator.navigationEvents.collectLatest { event ->
            navController.handleNavigationEvent(event)
        }
    }

    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = MainRoutes.Main,
            modifier = modifier,
            // 页面进入动画
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            },
            // 页面退出动画
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(300)
                )
            },
            // 返回时页面进入动画
            popEnterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            },
            // 返回时页面退出动画
            popExitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(300)
                )
            }
        ) {
            mainGraph(navController, this@SharedTransitionLayout)
            authGraph(navController, this@SharedTransitionLayout)
            userGraph(navController, this@SharedTransitionLayout)
        }
    }
}
