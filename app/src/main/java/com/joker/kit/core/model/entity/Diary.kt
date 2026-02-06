package com.joker.kit.core.model.entity

/**
 * 日记模型
 *
 * @param id ID
 * @param title 标题
 * @param content 内容
 * @param time 时间
 * @param pics 图片集合
 */
data class Diary(
    val id: Long = 0,
    val title: String = "",
    val content: String = "",
    val time: String = "",
    val pics: List<String> = emptyList()
)