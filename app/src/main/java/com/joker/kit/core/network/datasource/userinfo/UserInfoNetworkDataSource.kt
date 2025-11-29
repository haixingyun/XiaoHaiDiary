package com.joker.kit.core.network.datasource.userinfo

import com.joker.kit.core.model.entity.User
import com.joker.kit.core.model.network.NetworkResponse

/**
 * 用户信息相关数据源接口
 *
 * @author Joker.X
 */
interface UserInfoNetworkDataSource {

    /**
     * 获取用户个人信息
     *
     * @return 用户信息响应
     * @author Joker.X
     */
    suspend fun getPersonInfo(): NetworkResponse<User>
}
