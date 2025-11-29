package com.joker.kit.core.data.repository

import com.joker.kit.core.model.entity.Auth
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.network.datasource.auth.AuthNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * 认证相关仓库
 *
 * @param authNetworkDataSource 认证网络数据源
 * @author Joker.X
 */
class AuthRepository @Inject constructor(
    private val authNetworkDataSource: AuthNetworkDataSource
) {

    /**
     * 密码登录
     *
     * @param params 登录参数
     * @return 认证信息Flow
     * @author Joker.X
     */
    fun loginByPassword(params: Map<String, String>): Flow<NetworkResponse<Auth>> = flow {
        emit(authNetworkDataSource.loginByPassword(params))
    }.flowOn(Dispatchers.IO)
}
