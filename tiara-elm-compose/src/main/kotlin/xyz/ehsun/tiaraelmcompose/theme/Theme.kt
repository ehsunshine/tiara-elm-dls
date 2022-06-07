package xyz.ehsun.tiaraelmcompose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import xyz.ehsun.tiaraelmcompose.foundation.*

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    // Using default ones but colors and typography can be replaced with desired colors and text styles
    val colors = if (darkTheme) {
        tiaraElmDefaultDarkColors
    } else {
        tiaraElmDefaultLightColors
    }

    TiaraElmTheme(
        colors = colors,
        typography = tiaraElmTypography,
        content = content
    )
}