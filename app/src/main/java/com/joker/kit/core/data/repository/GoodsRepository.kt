package com.joker.kit.core.data.repository

import com.joker.kit.core.model.entity.Goods
import com.joker.kit.core.model.network.NetworkPageData
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.model.request.GoodsSearchRequest
import com.joker.kit.core.network.datasource.goods.GoodsNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * 商品相关仓库
 *
 * @param goodsNetworkDataSource 商品网络数据源
 * @author Joker.X
 */
class GoodsRepository @Inject constructor(
    private val goodsNetworkDataSource: GoodsNetworkDataSource
) {
    /**
     * 分页查询商品
     *
     * @param params 搜索请求参数
     * @return 商品分页数据Flow
     * @author Joker.X
     */
    fun getGoodsPage(params: GoodsSearchRequest): Flow<NetworkResponse<NetworkPageData<Goods>>> =
        flow {
            emit(goodsNetworkDataSource.getGoodsPage(params))
        }.flowOn(Dispatchers.IO)

    /**
     * 获取商品信息
     *
     * @param id 商品ID
     * @return 商品信息Flow
     * @author Joker.X
     */
    fun getGoodsInfo(id: String): Flow<NetworkResponse<Goods>> = flow {
        emit(goodsNetworkDataSource.getGoodsInfo(id))
    }.flowOn(Dispatchers.IO)

}
