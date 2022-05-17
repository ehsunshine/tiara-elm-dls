package xyz.ehsun.tiaraelmcompose.foundation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class TiaraElmColors(
    val brand: BrandColors,
    val foreground: PrimarySecondaryColors,
    val ornament: PrimarySecondaryColors,
    val background: PrimarySecondaryColors,
    val feedback: FeedbackColors,
    val isLight: Boolean,
)

data class BrandColors(
    val primary: Color,
)

data class PrimarySecondaryColors(
    val primary: Color,
    val secondary: Color,
)

data class FeedbackColors(
    val negative: Color,
    val positive: Color,
)

// Default light colors

val tiaraElmDefaultLightColors =
    TiaraElmColors(
        brand = BrandColors(primary = Color(0xFFFF7A00)),
        foreground = PrimarySecondaryColors(
            primary = Color(0xFF141414),
            secondary = Color(0xFF707070),
        ),
        ornament = PrimarySecondaryColors(
            primary = Color(0xFFD5D5D5),
            secondary = Color(0xFFEBEBEB),
        ),
        background = PrimarySecondaryColors(
            primary = Color(0xFFFFFFFF),
            secondary = Color(0xFFFAFAFA),
        ),
        feedback = FeedbackColors(
            negative = Color(0xFFBF2012),
            positive = Color(0xFF058A30),
        ),
        isLight = true,
    )

// Default dark colors

val tiaraElmDefaultDarkColors =
    TiaraElmColors(
        brand = BrandColors(primary = Color(0xFFFF7A00)),
        foreground = PrimarySecondaryColors(
            primary = Color(0xFFFFFFFF),
            secondary = Color(0xFFA3A3A3),
        ),
        ornament = PrimarySecondaryColors(
            primary = Color(0xFF292929),
            secondary = Color(0xFF1F1F1F),
        ),
        background = PrimarySecondaryColors(
            primary = Color(0xFF000000),
            secondary = Color(0xFF2B2B2B),
        ),
        feedback = FeedbackColors(
            negative = Color(0xFFDA0808),
            positive = Color(0xFF058A30),
        ),
        isLight = false
    )

val LocalColors = staticCompositionLocalOf { tiaraElmDefaultLightColors }