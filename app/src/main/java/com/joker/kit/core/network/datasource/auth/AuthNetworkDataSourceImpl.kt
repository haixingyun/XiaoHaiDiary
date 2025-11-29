package com.joker.kit.core.network.datasource.auth

import com.joker.kit.core.model.entity.Auth
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.network.base.BaseNetworkDataSource
import com.joker.kit.core.network.service.AuthService
import javax.inject.Inject

/**
 * 认证相关数据源实现类
 * 负责处理所有与用户认证相关的网络请求
 *
 * @param authService 认证服务接口，用于发起实际的网络请求
 * @author Joker.X
 */
class AuthNetworkDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : BaseNetworkDataSource(), AuthNetworkDataSource {

    /**
     * 账号密码登录
     *
     * @param params 请求参数，包含账号和密码
     * @return 登录结果响应数据
     * @author Joker.X
     */
    override suspend fun loginByPassword(params: Map<String, String>): NetworkResponse<Auth> {
        return authService.loginByPassword(params)
    }

} 