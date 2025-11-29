package com.joker.kit.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * 深色主题配色方案
 * 定义MaterialTheme中深色模式下的各种颜色
 */
private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = TextWhite,
    primaryContainer = PrimaryDark,
    onPrimaryContainer = TextWhite,
    inversePrimary = PrimaryLight,
    secondary = ColorPurpleDark,
    onSecondary = TextWhite,
    secondaryContainer = ColorPurpleDark,
    onSecondaryContainer = TextWhite,
    tertiary = ColorSuccessDark,
    onTertiary = TextWhite,
    tertiaryContainer = ColorSuccessDark,
    onTertiaryContainer = TextWhite,
    background = BgGreyDark,
    onBackground = TextPrimaryDark,
    surface = BgWhiteDark,
    onSurface = TextPrimaryDark,
    surfaceVariant = BgContentDark,
    onSurfaceVariant = TextSecondaryDark,
    surfaceTint = PrimaryDark,
    inverseSurface = BgGreyLight,
    inverseOnSurface = TextPrimaryLight,
    error = ColorDangerDark,
    onError = TextWhite,
    errorContainer = BgRedDark,
    onErrorContainer = ColorDangerDark,
    outline = BorderDark,
    outlineVariant = BorderDark,
    scrim = MaskDark,
    surfaceBright = BgWhiteDark,
    surfaceContainer = BgWhiteDark,
    surfaceContainerHigh = BgWhiteDark,
    surfaceContainerHighest = BgWhiteDark,
    surfaceContainerLow = BgContentDark,
    surfaceContainerLowest = BgGreyDark,
    surfaceDim = BgGreyDark,
    primaryFixed = PrimaryDark,
    primaryFixedDim = PrimaryDark,
    onPrimaryFixed = TextWhite,
    onPrimaryFixedVariant = TextWhite,
    secondaryFixed = ColorPurpleDark,
    secondaryFixedDim = ColorPurpleDark,
    onSecondaryFixed = TextWhite,
    onSecondaryFixedVariant = TextWhite,
    tertiaryFixed = ColorSuccessDark,
    tertiaryFixedDim = ColorSuccessDark,
    onTertiaryFixed = TextWhite,
    onTertiaryFixedVariant = TextWhite
)

/**
 * 浅色主题配色方案
 * 定义MaterialTheme中浅色模式下的各种颜色
 */
private val LightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    onPrimary = TextWhite,
    primaryContainer = PrimaryLight,
    onPrimaryContainer = TextWhite,
    inversePrimary = PrimaryDark,
    secondary = ColorPurple,
    onSecondary = TextWhite,
    secondaryContainer = ColorPurple,
    onSecondaryContainer = TextWhite,
    tertiary = ColorSuccess,
    onTertiary = TextWhite,
    tertiaryContainer = ColorSuccess,
    onTertiaryContainer = TextWhite,
    background = BgGreyLight,
    onBackground = TextPrimaryLight,
    surface = BgWhiteLight,
    onSurface = TextPrimaryLight,
    surfaceVariant = BgContentLight,
    onSurfaceVariant = TextSecondaryLight,
    surfaceTint = PrimaryLight,
    inverseSurface = BgGreyDark,
    inverseOnSurface = TextPrimaryDark,
    error = ColorDanger,
    onError = TextWhite,
    errorContainer = BgRedLight,
    onErrorContainer = ColorDanger,
    outline = BorderLight,
    outlineVariant = BorderLight,
    scrim = MaskLight,
    surfaceBright = BgWhiteLight,
    surfaceContainer = BgWhiteLight,
    surfaceContainerHigh = BgWhiteLight,
    surfaceContainerHighest = BgWhiteLight,
    surfaceContainerLow = BgContentLight,
    surfaceContainerLowest = BgGreyLight,
    surfaceDim = BgGreyLight,
    primaryFixed = PrimaryLight,
    primaryFixedDim = PrimaryLight,
    onPrimaryFixed = TextWhite,
    onPrimaryFixedVariant = TextWhite,
    secondaryFixed = ColorPurple,
    secondaryFixedDim = ColorPurple,
    onSecondaryFixed = TextWhite,
    onSecondaryFixedVariant = TextWhite,
    tertiaryFixed = ColorSuccess,
    tertiaryFixedDim = ColorSuccess,
    onTertiaryFixed = TextWhite,
    onTertiaryFixedVariant = TextWhite
)

/**
 * 应用主题 Composable 函数
 * 根据系统设置决定使用深色或浅色主题，并应用所有设计系统元素
 *
 * @param darkTheme 是否使用深色主题，默认跟随系统设置
 * @param dynamicColor 是否使用动态颜色（Android 12+特性），默认关闭
 * @param content 需要应用主题的内容
 * @author Joker.X
 */
@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = AppShapes,
        content = content
    )
}