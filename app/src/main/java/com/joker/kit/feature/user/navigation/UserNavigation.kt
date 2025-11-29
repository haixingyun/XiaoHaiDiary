package com.joker.kit.feature.user.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joker.kit.feature.user.view.UserInfoRoute
import com.joker.kit.navigation.routes.UserRoutes

/**
 * 注册用户信息页路由
 *
 * @param sharedTransitionScope 共享转场作用域
 * @author Joker.X
 */
@OptIn(ExperimentalSharedTransitionApi::class)
fun NavGraphBuilder.userInfoScreen(sharedTransitionScope: SharedTransitionScope) {
    composable<UserRoutes.Info> {
        UserInfoRoute()
    }
}
