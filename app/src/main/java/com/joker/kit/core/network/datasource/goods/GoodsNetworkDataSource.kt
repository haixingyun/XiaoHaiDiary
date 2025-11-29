package com.joker.kit.core.network.datasource.goods

import com.joker.kit.core.model.entity.Goods
import com.joker.kit.core.model.network.NetworkPageData
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.model.request.GoodsSearchRequest

/**
 * 商品相关数据源接口
 *
 * @author Joker.X
 */
interface GoodsNetworkDataSource {
    /**
     * 分页查询商品
     *
     * @param params 商品搜索请求参数
     * @return 商品分页数据响应
     * @author Joker.X
     */
    suspend fun getGoodsPage(params: GoodsSearchRequest): NetworkResponse<NetworkPageData<Goods>>

    /**
     * 获取商品信息
     *
     * @param id 商品ID
     * @return 商品信息响应
     * @author Joker.X
     */
    suspend fun getGoodsInfo(id: String): NetworkResponse<Goods>

}
