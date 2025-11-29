package com.joker.kit.core.network.service

import com.joker.kit.core.model.entity.User
import com.joker.kit.core.model.network.NetworkResponse
import retrofit2.http.GET

/**
 * 用户信息相关接口
 *
 * @author Joker.X
 */
interface UserInfoService {

    /**
     * 获取用户个人信息
     *
     * @return 用户信息响应
     * @author Joker.X
     */
    @GET("user/info/person")
    suspend fun getPersonInfo(): NetworkResponse<User>
}
