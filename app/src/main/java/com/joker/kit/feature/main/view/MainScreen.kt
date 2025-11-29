package com.joker.kit.feature.main.view

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
import com.joker.kit.feature.main.viewmodel.MainViewModel

/**
 * 主页面路由
 *
 * @param viewModel 主页面 ViewModel
 * @author Joker.X
 */
@Composable
internal fun MainRoute(
    viewModel: MainViewModel = hiltViewModel()
) {
    MainScreen()
}

/**
 * 主页面
 *
 * @param onBackClick 返回按钮回调
 * @author Joker.X
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    onBackClick: () -> Unit = {},
) {
    Scaffold { innerPadding ->
        MainContentView(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

/**
 * 主页面内容视图
 *
 * @param modifier 修饰符
 * @author Joker.X
 */
@Composable
private fun MainContentView(modifier: Modifier = Modifier) {
    AppText(
        text = "主页面",
        size = TextSize.TITLE_MEDIUM,
        modifier = modifier
    )
}

/**
 * 主页面界面浅色主题预览
 *
 * @author Joker.X
 */
@Preview(showBackground = true)
@Composable
internal fun MainScreenPreview() {
    AppTheme {
        MainScreen()
    }
}

/**
 * 主页面界面深色主题预览
 *
 * @author Joker.X
 */
@Preview(showBackground = true)
@Composable
internal fun MainScreenPreviewDark() {
    AppTheme(darkTheme = true) {
        MainScreen()
    }
} 
