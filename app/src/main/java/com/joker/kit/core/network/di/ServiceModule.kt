package com.joker.kit.core.network.di

import com.joker.kit.core.network.service.AuthService
import com.joker.kit.core.network.service.GoodsService
import com.joker.kit.core.network.service.UserInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * 服务模块，提供所有网络服务接口的依赖注入
 * 为Hilt提供各种网络服务接口的实例
 *
 * @author Joker.X
 */
@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    /**
     * 提供认证相关服务接口
     *
     * @param retrofit Retrofit实例
     * @return 认证服务接口实现
     * @author Joker.X
     */
    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    /**
     * 提供商品相关服务接口
     *
     * @param retrofit Retrofit实例
     * @return 商品服务接口实现
     * @author Joker.X
     */
    @Provides
    @Singleton
    fun provideGoodsService(retrofit: Retrofit): GoodsService {
        return retrofit.create(GoodsService::class.java)
    }

    /**
     * 提供用户信息相关服务接口
     *
     * @param retrofit Retrofit实例
     * @return 用户信息服务接口实现
     * @author Joker.X
     */
    @Provides
    @Singleton
    fun provideUserInfoService(retrofit: Retrofit): UserInfoService {
        return retrofit.create(UserInfoService::class.java)
    }
}