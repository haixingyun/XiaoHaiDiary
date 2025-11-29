package com.joker.kit.core.state.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * 用户状态模块，提供 UserState 所需的应用级协程作用域
 */
@Module
@InstallIn(SingletonComponent::class)
object UserStateModule {

    /**
     * 提供应用级别的协程作用域
     * SupervisorJob 确保子协程失败不会终止整个作用域
     */
    @ApplicationScope
    @Singleton
    @Provides
    fun providesApplicationScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.Default)
    }
}

/**
 * 应用级协程作用域限定符
 */
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope
