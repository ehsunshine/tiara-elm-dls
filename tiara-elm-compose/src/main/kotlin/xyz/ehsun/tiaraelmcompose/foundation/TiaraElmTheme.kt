package xyz.ehsun.tiaraelmcompose.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun TiaraElmTheme(
    colors: TiaraElmColors = TiaraElmTheme.colors,
    typography: TiaraElmTypography = TiaraElmTheme.typography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
    ) {
        content()
    }
}

object TiaraElmTheme {

    // Retrieves the current colors
    val colors: TiaraElmColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    // Retrieves the current typography
    val typography: TiaraElmTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
