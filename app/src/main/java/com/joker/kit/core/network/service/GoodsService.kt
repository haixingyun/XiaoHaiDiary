package com.joker.kit.core.network.service

import com.joker.kit.core.model.entity.Goods
import com.joker.kit.core.model.network.NetworkPageData
import com.joker.kit.core.model.network.NetworkResponse
import com.joker.kit.core.model.request.GoodsSearchRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 商品相关接口
 *
 * @author Joker.X
 */
interface GoodsService {

    /**
     * 分页查询商品
     *
     * @param params 商品搜索请求参数
     * @return 商品分页数据响应
     * @author Joker.X
     */
    @POST("goods/info/page")
    suspend fun getGoodsPage(@Body params: GoodsSearchRequest): NetworkResponse<NetworkPageData<Goods>>

    /**
     * 获取商品信息
     *
     * @param id 商品ID
     * @return 商品信息响应
     * @author Joker.X
     */
    @GET("goods/info/info")
    suspend fun getGoodsInfo(@Query("id") id: String): NetworkResponse<Goods>
}
