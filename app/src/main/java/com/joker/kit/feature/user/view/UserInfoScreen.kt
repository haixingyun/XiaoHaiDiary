package com.joker.kit.feature.user.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.joker.kit.core.designsystem.theme.AppTheme
import com.joker.kit.core.ui.component.text.AppText
import com.joker.kit.core.ui.component.text.TextSize
import com.joker.kit.feature.user.viewmodel.UserInfoViewModel

/**
 * 用户信息页面路由入口
 *
 * @param viewModel 用户信息页 ViewModel
 * @author Joker.X
 */
@Composable
internal fun UserInfoRoute(
    viewModel: UserInfoViewModel = hiltViewModel()
) {
    UserInfoScreen()
}

/**
 * 用户信息页面
 *
 * @param onBackClick 返回按钮回调
 * @author Joker.X
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun UserInfoScreen(
    onBackClick: () -> Unit = {},
) {
    Scaffold { innerPadding ->
        UserInfoContentView(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

/**
 * 用户信息内容
 *
 * @param modifier 修饰符
 * @author Joker.X
 */
@Composable
private fun UserInfoContentView(modifier: Modifier = Modifier) {
    AppText(
        text = "用户信息页",
        size = TextSize.TITLE_MEDIUM,
        modifier = modifier
    )
}

/**
 * 用户信息页浅色主题预览
 *
 * @author Joker.X
 */
@Preview(showBackground = true)
@Composable
private fun UserInfoScreenPreview() {
    AppTheme {
        UserInfoScreen()
    }
}

/**
 * 用户信息页深色主题预览
 *
 * @author Joker.X
 */
@Preview(showBackground = true)
@Composable
private fun UserInfoScreenPreviewDark() {
    AppTheme(darkTheme = true) {
        UserInfoScreen()
    }
}
