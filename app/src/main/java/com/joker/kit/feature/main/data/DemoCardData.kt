package com.joker.kit.feature.main.data

import com.joker.kit.feature.main.model.DemoCardInfo
import com.joker.kit.navigation.routes.DemoRoutes
import com.joker.kit.navigation.routes.UserRoutes

/**
 * Demo 卡片静态数据源
 */
object DemoCardData {

    val coreCards: List<DemoCardInfo> = listOf(
        DemoCardInfo(
            title = "Network Demo",
            description = "网络状态切换，包含加载、错误、重试等流程。",
            route = DemoRoutes.NetworkDemo
        ),
        DemoCardInfo(
            title = "Network List Demo",
            description = "下拉刷新与分页加载的统一列表模板，内置空状态与重试。",
            route = DemoRoutes.NetworkListDemo
        ),
        DemoCardInfo(
            title = "数据库",
            description = "Room 的增删改查示例，含简单的列表展示与数据观察。",
            route = DemoRoutes.Database
        ),
        DemoCardInfo(
            title = "本地存储",
            description = "DataStore / MMKV 的写入与清除示例，演示单值增删改查。",
            route = DemoRoutes.LocalStorage
        ),
        DemoCardInfo(
            title = "状态管理",
            description = "全局 DemoCounterState 计数器共享示例，展示跨页面 StateFlow 同步。",
            route = DemoRoutes.StateManagement
        ),
        DemoCardInfo(
            title = "网络请求",
            description = "结合 ResultHandler 的通用接口请求、加载状态与错误提示。",
            route = DemoRoutes.NetworkRequest
        )
    )

    val navigationCards: List<DemoCardInfo> = listOf(
        DemoCardInfo(
            title = "带参跳转",
            description = "类型安全路由参数，包含必填/可选参数与目标页接收方式。",
            route = DemoRoutes.NavigationWithArgs(123)
        ),
        DemoCardInfo(
            title = "结果回传",
            description = "NavigationResultKey 返回数据，包含刷新信号与数据实体回传。",
            route = DemoRoutes.NavigationResult
        ),
        DemoCardInfo(
            title = "导航拦截",
            description = "登录拦截流程：未登录跳登录页，登录成功后才能进入用户详情。",
            route = UserRoutes.Info
        )
    )
}