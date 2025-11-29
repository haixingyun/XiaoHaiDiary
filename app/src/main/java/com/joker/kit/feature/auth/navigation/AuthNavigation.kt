package com.joker.kit.feature.auth.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joker.kit.feature.auth.view.LoginRoute
import com.joker.kit.navigation.routes.AuthRoutes

/**
 * 注册登录页路由
 *
 * @param sharedTransitionScope 共享转场作用域
 * @author Joker.X
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.loginScreen(sharedTransitionScope: SharedTransitionScope) {
    composable<AuthRoutes.Login> {
        LoginRoute()
    }
}
