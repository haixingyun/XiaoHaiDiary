package com.joker.kit.navigation.results

import com.joker.kit.navigation.NavigationResultKey
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * Demo 结果回传示例：返回 DemoResult 数据类
 */
object DemoResultKey : NavigationResultKey<DemoResult> {
    override fun serialize(value: DemoResult): Any = Json.encodeToString(value)
    override fun deserialize(raw: Any): DemoResult = Json.decodeFromString(raw as String)
}

@Serializable
data class DemoResult(
    val id: Long,
    val message: String
)
