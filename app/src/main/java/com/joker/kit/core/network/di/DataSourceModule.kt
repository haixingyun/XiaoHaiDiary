package com.joker.kit.core.network.di

import com.joker.kit.core.network.datasource.auth.AuthNetworkDataSource
import com.joker.kit.core.network.datasource.auth.AuthNetworkDataSourceImpl
import com.joker.kit.core.network.datasource.goods.GoodsNetworkDataSource
import com.joker.kit.core.network.datasource.goods.GoodsNetworkDataSourceImpl
import com.joker.kit.core.network.datasource.userinfo.UserInfoNetworkDataSource
import com.joker.kit.core.network.datasource.userinfo.UserInfoNetworkDataSourceImpl
import com.joker.kit.core.network.service.AuthService
import com.joker.kit.core.network.service.GoodsService
import com.joker.kit.core.network.service.UserInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 数据源模块，提供所有网络数据源的依赖注入
 * 为Hilt提供各种网络数据源的实例
 *
 * @author Joker.X
 */
@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    /**
     * 提供认证相关网络数据源
     *
     * @param authService 认证服务接口
     * @return 认证网络数据源实现
     * @author Joker.X
     */
    @Provides
    @Singleton
    fun provideAuthNetworkDataSource(authService: AuthService): AuthNetworkDataSource {
        return AuthNetworkDataSourceImpl(authService)
    }

    /**
     * 提供商品相关网络数据源
     *
     * @param goodsService 商品服务接口
     * @return 商品网络数据源实现
     * @author Joker.X
     */
    @Provides
    @Singleton
    fun provideGoodsNetworkDataSource(goodsService: GoodsService): GoodsNetworkDataSource {
        return GoodsNetworkDataSourceImpl(goodsService)
    }

    /**
     * 提供用户信息相关网络数据源
     *
     * @param userInfoService 用户信息服务接口
     * @return 用户信息网络数据源实现
     * @author Joker.X
     */
    @Provides
    @Singleton
    fun provideUserInfoNetworkDataSource(userInfoService: UserInfoService): UserInfoNetworkDataSource {
        return UserInfoNetworkDataSourceImpl(userInfoService)
    }
}