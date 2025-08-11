package com.pathok.user.android.design_system

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

/**
 * Reference:
 * 1. https://m3.material.io/styles/color/roles#a828e350-1551-45e5-8430-eb643e6a7713
 * 2. https://developer.android.com/codelabs/jetpack-compose-theming#3
 */

private val darkColorScheme = darkColorScheme(
    primary = Blue500,
    onPrimary = White,
    primaryContainer = White,
    secondary = Blue50,
    onSecondary = White,
    secondaryContainer = Yellow10,
    background = Blue10,
    onBackground = White,
    surface = White,
    onSurface = Gray500,
    surfaceTint = Gray50,
    surfaceVariant = Gray100,
    inverseSurface = Red10,
    tertiary = Gray500,
    onTertiary = White,
    onTertiaryContainer = Gray400,
    error = Red500,
    onError = White,
    errorContainer = Red50,
    outline = Gray200,
    outlineVariant = Gray300,
)

private val lightColorScheme = lightColorScheme(
    primary = Blue500,
    onPrimary = White,
    primaryContainer = White,
    secondary = Blue50,
    onSecondary = White,
    secondaryContainer = Yellow10,
    background = Blue10,
    onBackground = White,
    surface = White,
    onSurface = Gray500,
    surfaceTint = Gray50,
    surfaceVariant = Gray100,
    inverseSurface = Red10,
    tertiary = Gray500,
    onTertiary = White,
    onTertiaryContainer = Gray400,
    error = Red500,
    onError = White,
    errorContainer = Red50,
    outline = Gray200,
    outlineVariant = Gray300,
)

@Composable
fun PathokTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            darkTheme -> darkColorScheme
            else -> lightColorScheme
        }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
