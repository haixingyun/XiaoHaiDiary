package com.joker.kit.feature.main.view

import android.R.attr.data
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import com.joker.kit.R
import com.joker.kit.core.base.state.BaseNetWorkUiState
import com.joker.kit.core.designsystem.theme.AppTheme
import com.joker.kit.core.ui.component.network.BaseNetWorkView
import com.joker.kit.core.ui.component.scaffold.AppScaffold
import com.joker.kit.core.ui.component.text.AppText
import com.joker.kit.feature.main.viewmodel.MyViewModel

/**
 * 我的路由
 *
 * @param viewModel 我的 ViewModel
 */
@Composable
internal fun MyRoute(
    viewModel: MyViewModel = hiltViewModel()
) {

    MyScreen(
    )
}

/**
 * 我的界面
 *
 * @param uiState UI 状态
 * @param onBackClick 返回按钮回调
 * @param onRetry 重试回调
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MyScreen(
    uiState: BaseNetWorkUiState<Any> = BaseNetWorkUiState.Loading,
    onBackClick: () -> Unit = {},
    onRetry: () -> Unit = {}
) {
    AppScaffold(
        titleText = "我的",
        showBackIcon = false
    ) {
        MyContent(data = data)
    }
}

/**
 * 我的内容视图
 */
@Composable
private fun MyContent(data: Any) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppText(
            text = "加油！！！",
        )
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
    }

}

/**
 * 我的界面浅色主题预览
 */
@Preview(showBackground = true)
@Composable
internal fun MyPreview() {
    AppTheme {
        MyScreen(uiState = BaseNetWorkUiState.Success(Any()))
    }
}

/**
 * 我的界面深色主题预览
 */
@Preview(showBackground = true)
@Composable
internal fun MyPreviewDark() {
    AppTheme(darkTheme = true) {
        MyScreen(uiState = BaseNetWorkUiState.Success(Any()))
    }
}