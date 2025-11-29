package com.joker.kit.core.network.service

import com.joker.kit.core.model.entity.Auth
import com.joker.kit.core.model.network.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 认证相关接口
 *
 * @author Joker.X
 */
interface AuthService {

    /**
     * 密码登录
     *
     * @param params 密码登录请求参数
     * @return 认证信息响应
     * @author Joker.X
     */
    @POST("user/login/password")
    suspend fun loginByPassword(@Body params: Map<String, String>): NetworkResponse<Auth>

} 