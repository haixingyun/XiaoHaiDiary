package com.joker.kit.core.network.datasource.goods

import com.joker.kit.core.model.entity.Goods
import com.joker.kit.core.model.network.NetworkPageData
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.model.request.GoodsSearchRequest
import com.joker.kit.core.network.base.BaseNetworkDataSource
import com.joker.kit.core.network.service.GoodsService
import javax.inject.Inject

/**
 * 商品相关数据源实现类
 * 负责处理所有与商品相关的网络请求
 *
 * @param goodsService 商品服务接口，用于发起实际的网络请求
 * @author Joker.X
 */
class GoodsNetworkDataSourceImpl @Inject constructor(
    private val goodsService: GoodsService
) : BaseNetworkDataSource(), GoodsNetworkDataSource {

    /**
     * 分页查询商品
     *
     * @param params 请求参数，包含分页和筛选信息
     * @return 商品分页列表响应数据
     * @author Joker.X
     */
    override suspend fun getGoodsPage(params: GoodsSearchRequest): NetworkResponse<NetworkPageData<Goods>> {
        return goodsService.getGoodsPage(params)
    }

    /**
     * 获取商品详情
     *
     * @param id 商品ID
     * @return 商品详情响应数据
     * @author Joker.X
     */
    override suspend fun getGoodsInfo(id: String): NetworkResponse<Goods> {
        return goodsService.getGoodsInfo(id)
    }
}
