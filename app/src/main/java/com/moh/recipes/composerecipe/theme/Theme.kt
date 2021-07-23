package com.moh.recipes.composerecipe.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Palette_Blue1,
    secondary = Palette_Blue2,
    background = Palette_Neutral5,
    onPrimary = Palette_Neutral5,
    onSecondary = Palette_Neutral4,
    error = Palette_Red1
)

private val DarkColorPalette = darkColors(
    primary = Palette_Yellow1,
    secondary = Palette_Yellow2,
    background = Palette_Neutral0,
    onPrimary = Palette_Neutral1,
    onSecondary = Palette_Neutral2,
    error = Palette_Red2
)

@Composable
fun SampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = sampleTypography,
        shapes = Shapes,
        content = content
    )
}
