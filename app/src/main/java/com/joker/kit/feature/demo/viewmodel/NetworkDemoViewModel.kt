package com.joker.kit.feature.demo.viewmodel

import com.joker.kit.core.base.viewmodel.BaseNetWorkViewModel
import com.joker.kit.core.data.repository.GoodsRepository
import com.joker.kit.core.model.entity.Goods
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * 网络状态 Demo 页面 ViewModel
 *
 * @param navigator 导航管理器
 * @param userState 用户状态管理
 * @param goodsRepository 商品数据仓库
 */
@HiltViewModel
class NetworkDemoViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
    private val goodsRepository: GoodsRepository
) : BaseNetWorkViewModel<Goods>(navigator, userState) {

    init {
        super.executeRequest()
    }

    /**
     * 重写请求API Flow，获取商品信息
     */
    override fun requestApiFlow(): Flow<NetworkResponse<Goods>> {
        return goodsRepository.getGoodsInfo("1")
    }
}