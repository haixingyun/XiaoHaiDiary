package com.joker.kit.feature.auth.view

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
import com.joker.kit.feature.auth.viewmodel.LoginViewModel

/**
 * 登录页面路由入口
 *
 * @param viewModel 登录页 ViewModel
 * @author Joker.X
 */
@Composable
internal fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel()
) {
    LoginScreen()
}

/**
 * 登录页面
 *
 * @param onBackClick 返回按钮回调
 * @author Joker.X
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LoginScreen(
    onBackClick: () -> Unit = {},
) {
    Scaffold { innerPadding ->
        LoginContentView(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

/**
 * 登录页面内容
 *
 * @param modifier 修饰符
 * @author Joker.X
 */
@Composable
private fun LoginContentView(modifier: Modifier = Modifier) {
    AppText(
        text = "登录页面",
        size = TextSize.TITLE_MEDIUM,
        modifier = modifier
    )
}

/**
 * 登录页浅色主题预览
 *
 * @author Joker.X
 */
@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    AppTheme {
        LoginScreen()
    }
}

/**
 * 登录页深色主题预览
 *
 * @author Joker.X
 */
@Preview(showBackground = true)
@Composable
private fun LoginScreenPreviewDark() {
    AppTheme(darkTheme = true) {
        LoginScreen()
    }
}
