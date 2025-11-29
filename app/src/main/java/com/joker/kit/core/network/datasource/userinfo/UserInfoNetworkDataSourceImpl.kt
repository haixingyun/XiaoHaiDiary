package com.joker.kit.core.network.datasource.userinfo

import com.joker.kit.core.model.entity.User
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.network.base.BaseNetworkDataSource
import com.joker.kit.core.network.service.UserInfoService
import javax.inject.Inject

/**
 * 用户信息相关数据源实现类
 * 负责处理所有与用户信息相关的网络请求
 *
 * @param userInfoService 用户信息服务接口，用于发起实际的网络请求
 * @author Joker.X
 */
class UserInfoNetworkDataSourceImpl @Inject constructor(
    private val userInfoService: UserInfoService
) : BaseNetworkDataSource(), UserInfoNetworkDataSource {

    /**
     * 获取用户个人信息
     *
     * @return 用户个人信息响应数据
     * @author Joker.X
     */
    override suspend fun getPersonInfo(): NetworkResponse<User> {
        return userInfoService.getPersonInfo()
    }
}
