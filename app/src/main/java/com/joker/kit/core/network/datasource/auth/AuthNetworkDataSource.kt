package com.joker.kit.core.network.datasource.auth

import com.joker.kit.core.model.entity.Auth
import com.joker.kit.core.model.network.NetworkResponse


/**
 * 认证相关数据源接口
 *
 * @author Joker.X
 */
interface AuthNetworkDataSource {
    /**
     * 密码登录
     *
     * @param params 密码登录请求参数
     * @return 认证信息响应
     * @author Joker.X
     */
    suspend fun loginByPassword(params: Map<String, String>): NetworkResponse<Auth>
} 