package com.joker.kit.core.ui.component.loading

import androidx.compose.animation.core.DurationBasedAnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joker.kit.core.designsystem.theme.AppTheme
import com.joker.kit.core.designsystem.theme.Primary
import kotlin.math.cos
import kotlin.math.sin

/**
 * 小米风格Web加载动画 - 3条竖线交替缩放
 *
 * @param color 竖线颜色，默认使用Primary主题色
 */
@Composable
fun MiLoadingWeb(color: Color = Primary) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val animations = List(3) { index ->
        val alpha by infiniteTransition.animateFloat(
            initialValue = 0.3f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 400,
                    delayMillis = index * 100,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            ),
            label = "MiLoadingWebAlphaAnimation"
        )
        val scaleY by infiniteTransition.animateFloat(
            initialValue = 0.5f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 400,
                    delayMillis = index * 100,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse
            ),
            label = "MiLoadingWebScaleAnimation"
        )
        Pair(alpha, scaleY)
    }

    Canvas(modifier = Modifier.size(24.dp)) {
        animations.forEachIndexed { index, item ->
            val strokeWidth = 4.dp.toPx()
            val spacing = (size.width - (3 * strokeWidth)) / 2

            scale(scaleX = 1f, scaleY = item.second) {
                drawLine(
                    color = color.copy(alpha = item.first),
                    start = Offset(
                        x = strokeWidth / 2 + (strokeWidth + spacing) * index,
                        y = 0f
                    ),
                    end = Offset(
                        x = strokeWidth / 2 + (strokeWidth + spacing) * index,
                        y = size.height
                    ),
                    strokeWidth
                )
            }
        }
    }
}

/**
 * 小米风格移动端加载动画 - 圆形轨道上的圆点旋转
 *
 * @param borderColor 圆形轨道边框颜色，默认使用onSurface颜色
 * @param dotColor 旋转圆点的颜色，默认与边框颜色相同
 * @param animationSpec 动画规格配置，默认1200ms线性动画
 */
@Composable
fun MiLoadingMobile(
    borderColor: Color = MaterialTheme.colorScheme.onSurface,
    dotColor: Color = borderColor,
    animationSpec: DurationBasedAnimationSpec<Float> = tween(
        durationMillis = 1200,
        easing = LinearEasing
    )
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = animationSpec,
            repeatMode = RepeatMode.Restart
        ),
        label = "MiLoadingMobileAnimation"
    )

    Canvas(
        modifier = Modifier
            .size(28.dp)
            .border(2.dp, borderColor, CircleShape)
    ) {
        val circleRadius = size.minDimension / 2 - 8.dp.toPx()
        val dotRadius = 3.dp.toPx()
        val center = size.center
        val dotX = cos(Math.toRadians(angle.value.toDouble())) * circleRadius + center.x
        val dotY = sin(Math.toRadians(angle.value.toDouble())) * circleRadius + center.y

        drawCircle(dotColor, radius = dotRadius, center = Offset(dotX.toFloat(), dotY.toFloat()))
    }
}

/**
 * MiLoadingWeb组件预览
 */
@Preview(showBackground = true)
@Composable
fun MiLoadingWebPreview() {
    AppTheme {
        MiLoadingWeb()
    }
}

/**
 * 小米风格移动端加载动画
 */
@Preview(showBackground = true)
@Composable
fun MiLoadingMobilePreview() {
    AppTheme {
        MiLoadingMobile()
    }
}