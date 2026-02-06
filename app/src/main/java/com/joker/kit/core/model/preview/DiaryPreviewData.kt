package com.joker.kit.core.model.preview

import com.joker.kit.core.model.entity.Diary

val diaryPreviewList = listOf(
    Diary(
        id = 1,
        title = "今天的心情",
        content = "今天心情特别好，天气晴朗，出去散步了。",
        time = "2026-02-05 09:30",
        pics = listOf(
            "https://picsum.photos/400/400?random=1",
            "https://picsum.photos/400/400?random=2"
        )
    ),
    Diary(
        id = 2,
        title = "工作总结",
        content = "今天完成了项目的初步开发，还需要优化界面。",
        time = "2026-02-04 18:00",
        pics = emptyList()
    ),
    Diary(
        id = 3,
        title = "旅行记",
        content = "去了海边，拍了很多照片，海水很蓝，很舒服。",
        time = "2026-01-20 15:00",
        pics = listOf(
            "https://picsum.photos/400/400?random=3",
            "https://picsum.photos/400/400?random=4",
            "https://picsum.photos/400/400?random=5"
        )
    ),
    Diary(
        id = 4,
        title = "美食日记",
        content = "尝试了新的甜品店，草莓蛋糕超好吃！",
        time = "2026-01-18 12:30",
        pics = listOf("https://picsum.photos/400/400?random=6")
    ),
    Diary(
        id = 5,
        title = "随笔",
        content = "今天随意写写，没有特别的主题。",
        time = "2026-02-01 20:00",
        pics = emptyList()
    ),
    Diary(
        id = 6,
        title = "运动记录",
        content = "今天跑了5公里，感觉很轻松。",
        time = "2026-02-03 07:00",
        pics = emptyList()
    ),
    Diary(
        id = 7,
        title = "学习笔记",
        content = "复习了 Kotlin 中的协程，终于搞懂了 suspend 和 launch 的区别。",
        time = "2026-02-02 22:00",
        pics = emptyList()
    ),
    Diary(
        id = 8,
        title = "电影观后感",
        content = "今天看了《奇异博士2》，特效很棒，但剧情稍显复杂。",
        time = "2026-01-30 20:30",
        pics = listOf("https://picsum.photos/400/400?random=7")
    ),
    Diary(
        id = 9,
        title = "购物日记",
        content = "买了一件新外套，颜色正好，穿起来很舒服。",
        time = "2026-01-28 16:00",
        pics = emptyList()
    ),
    Diary(
        id = 10,
        title = "音乐分享",
        content = "发现一首好听的钢琴曲，晚上听很放松。",
        time = "2026-01-27 21:00",
        pics = listOf("https://picsum.photos/400/400?random=8")
    )
)
