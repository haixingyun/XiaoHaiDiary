package com.joker.kit.feature.demo.viewmodel

import com.joker.kit.core.base.viewmodel.BaseNetWorkListViewModel
import com.joker.kit.core.data.repository.GoodsRepository
import com.joker.kit.core.model.entity.Goods
import com.joker.kit.core.model.network.NetworkPageData
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.model.request.GoodsSearchRequest
import com.joker.kit.core.state.UserState
import com.joker.kit.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Network List Demo 示例页 ViewModel
 *
 * @param navigator 导航器
 * @param userState 用户状态管理
 * @param goodsRepository 商品数据仓库
 */
@HiltViewModel
class NetworkListDemoViewModel @Inject constructor(
    navigator: AppNavigator,
    userState: UserState,
    private val goodsRepository: GoodsRepository
) : BaseNetWorkListViewModel<Goods>(
    navigator = navigator,
    userState = userState
) {

    init {
        initLoad()
    }

    /**
     * 重写请求API Flow，获取商品列表
     */
    override fun requestListData(): Flow<NetworkResponse<NetworkPageData<Goods>>> {
        return goodsRepository.getGoodsPage(
            GoodsSearchRequest(
                page = currentPage,
                size = pageSize
            )
        )
    }
}
