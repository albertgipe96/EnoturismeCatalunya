package com.development.core.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DarkRed50,
    onPrimary = Neutral0,
    primaryContainer = DarkRed10,
    onPrimaryContainer = DarkRed90,
    secondary = AntiqueWhite50,
    onSecondary = Neutral100,
    secondaryContainer = AntiqueWhite10,
    onSecondaryContainer = AntiqueWhite90,
    error = Error,
    onError = Neutral0,
    errorContainer = Error,
    onErrorContainer = Neutral0,
    background = AntiqueWhite10,
    onBackground = Neutral100,
    surface = AntiqueWhite10,
    onSurface = Neutral100
)

private val LightColorScheme = lightColorScheme(
    primary = DarkRed50,
    onPrimary = Neutral0,
    primaryContainer = DarkRed10,
    onPrimaryContainer = DarkRed90,
    secondary = AntiqueWhite50,
    onSecondary = Neutral100,
    secondaryContainer = AntiqueWhite10,
    onSecondaryContainer = AntiqueWhite90,
    error = Error,
    onError = Neutral0,
    errorContainer = Error,
    onErrorContainer = Neutral0,
    background = AntiqueWhite10,
    onBackground = Neutral100,
    surface = AntiqueWhite10,
    onSurface = Neutral100
)

@Composable
fun EnoturismeCatalunyaTheme(
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
        content = content
    )
}
