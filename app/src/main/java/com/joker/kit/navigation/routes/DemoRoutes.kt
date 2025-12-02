package com.joker.kit.navigation.routes

import kotlinx.serialization.Serializable

/**
 * Demo 模块路由
 */
object DemoRoutes {
    /** Network Demo 示例页 */
    @Serializable
    data object NetworkDemo

    /** Network List Demo 示例页 */
    @Serializable
    data object NetworkListDemo

    /** 数据库示例页 */
    @Serializable
    data object Database

    /** 本地存储示例页 */
    @Serializable
    data object LocalStorage

    /** 状态管理示例页 */
    @Serializable
    data object StateManagement

    /** 通用网络请求示例页 */
    @Serializable
    data object NetworkRequest

    /** 带参跳转示例页 */
    @Serializable
    data class NavigationWithArgs(
        val goodsId: Long
    )

    /** 结果回传示例页 */
    @Serializable
    data object NavigationResult
}
