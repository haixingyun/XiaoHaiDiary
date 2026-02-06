package com.joker.kit.feature.main.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.joker.kit.core.designsystem.theme.AppTheme
import com.joker.kit.core.designsystem.theme.BgContentLight
import com.joker.kit.core.designsystem.theme.BgFloatingActionButton
import com.joker.kit.core.designsystem.theme.BgWhiteLight
import com.joker.kit.core.model.entity.Diary
import com.joker.kit.core.model.preview.diaryPreviewList
import com.joker.kit.feature.main.component.DiaryGridItem
import com.joker.kit.core.ui.component.scaffold.AppScaffold
import com.joker.kit.feature.main.viewmodel.HomeViewModel

/**
 * 首页路由
 *
 * @param viewModel 首页 ViewModel
 */
@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    // 收集 UI 状态

    HomeScreen(

    )
}

/**
 * 首页界面
 *
 * @param items 日记数据列表
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(
    items: List<Diary> = emptyList(),
) {
    AppScaffold(
        isExcludeNavigationBar = true,
        titleText = "笔记",
        showBackIcon = false,
        topBarColors = TopAppBarDefaults.topAppBarColors(
            containerColor = BgContentLight,
        ),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* 新增日记 */ },
                containerColor = BgFloatingActionButton,
                contentColor = BgWhiteLight
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "新增",
                )
            }
        }
    ) {
        HomeContent(items = items)
    }
}

/**
 * 首页内容视图
 */
@Composable
private fun HomeContent(items: List<Diary>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp
    ) {
        items(diaryPreviewList, key = { it.id }) { diary ->
            DiaryGridItem(diary, onClick = { /*跳转*/ })
        }
    }
}

/**
 * 首页界面浅色主题预览
 */
@Preview(showBackground = true)
@Composable
internal fun HomePreview() {
    AppTheme {
        HomeScreen()
    }
}

/**
 * 首页界面深色主题预览
 */
@Preview(showBackground = true)
@Composable
internal fun HomePreviewDark() {
    AppTheme(darkTheme = true) {
        HomeScreen()
    }
}