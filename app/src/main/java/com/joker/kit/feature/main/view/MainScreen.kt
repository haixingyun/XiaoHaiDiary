package com.joker.kit.feature.main.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.joker.kit.core.designsystem.theme.AppTheme
import com.joker.kit.core.designsystem.theme.BgContentLight
import com.joker.kit.core.ui.component.divider.Divider
import com.joker.kit.core.ui.component.text.AppText
import com.joker.kit.core.ui.component.text.TextSize
import com.joker.kit.feature.main.viewmodel.MainTab
import com.joker.kit.feature.main.viewmodel.MainUiState
import com.joker.kit.feature.main.viewmodel.MainViewModel

/**
 * 主页面路由
 *
 * @param viewModel 主页面 ViewModel
 * @author Joker.X
 */
@Composable
internal fun MainRoute(
    viewModel: MainViewModel = hiltViewModel(), navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()
    MainScreen(
        uiState = uiState, onTabSelected = viewModel::selectTab, navController = navController
    )
}

/**
 * 主页面
 *
 * @param uiState UI 状态
 * @param onTabSelected Tab 切换回调
 * @author Joker.X
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    uiState: MainUiState = MainUiState(),
    onTabSelected: (MainTab) -> Unit,
    navController: NavController = NavController(LocalContext.current)
) {
    MainScreenContent(
        uiState = uiState, onTabSelected = onTabSelected, navController = navController
    )
}

/**
 * 主页面内容视图，包含底部导航和横向 Pager
 *
 * @param uiState UI 状态
 * @param onTabSelected Tab 切换回调
 * @param navController 导航控制器
 * @author Joker.X
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun MainScreenContent(
    uiState: MainUiState, onTabSelected: (MainTab) -> Unit, navController: NavController
) {
    val pagerState = rememberPagerState(pageCount = { MainTab.allTabs.size })
    val currentPage = pagerState.currentPage

    LaunchedEffect(uiState.currentTab) {
        val targetPage = uiState.currentTab.index
        if (pagerState.currentPage != targetPage) {
            pagerState.scrollToPage(targetPage)
        }
    }

    LaunchedEffect(currentPage) {
        val tab = MainTab.fromIndex(currentPage)
        if (tab != uiState.currentTab) {
            onTabSelected(tab)
        }
    }

    Scaffold(
        // 排除系统导航栏
        contentWindowInsets = ScaffoldDefaults
            .contentWindowInsets
            .exclude(WindowInsets.statusBars)
        ,
        bottomBar = {
            MainBottomBar(
                tabs = MainTab.allTabs,
                currentTab = uiState.currentTab,
                onTabSelected = onTabSelected
            )
        }
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) { page ->
            when (MainTab.fromIndex(page)) {
                MainTab.Home -> HomeRoute()
                MainTab.Todo -> ToDoRoute()
                MainTab.My -> MyRoute()
            }
        }
    }
}

/**
 * 自定义纯文字底部导航栏
 *
 * @param tabs 底部栏 Tab 列表
 * @param currentTab 当前选中 Tab
 * @param onTabSelected Tab 选择回调
 * @author Joker.X
 */
@Composable
private fun MainBottomBar(
    tabs: List<MainTab>, currentTab: MainTab, onTabSelected: (MainTab) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgContentLight)
            .navigationBarsPadding()
    ) {
        Divider(color = Color.Red)
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            tabs.forEach { tab ->
                val selected = tab == currentTab
                val color = if (selected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 10.dp)
                        .clickable {
                            onTabSelected(tab)
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        painter = painterResource(tab.icon),
                        contentDescription = tab.title,
                        tint = color
                    )
                    AppText(
                        text = tab.title,
                        size = TextSize.BODY_MEDIUM,
                        color = color,
                    )
                }

            }
        }
    }

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
        MainScreen(
            uiState = MainUiState(),
            onTabSelected = {},
        )
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
        MainScreen(
            uiState = MainUiState(), onTabSelected = {})
    }
}
