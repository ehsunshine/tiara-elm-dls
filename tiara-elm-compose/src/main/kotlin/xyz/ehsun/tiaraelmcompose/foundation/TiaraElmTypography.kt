package xyz.ehsun.tiaraelmcompose.foundation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import xyz.ehsun.tiaraelmcompose.R

data class TiaraElmTypography(
    val maria: TextStyle,
    val lama: TextStyle,
    val mare: TextStyle,
    val area: TextStyle,
)

internal val robotoFontFamily = FontFamily(
    Font(R.font.roboto_light, FontWeight.W100),
    Font(R.font.roboto_medium, FontWeight.W400),
)

val tiaraElmTypography =
    TiaraElmTypography(
        maria = TextStyle(
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 32.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.sp,
        ),
        lama = TextStyle(
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.W100,
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp,
        ),
        mare = TextStyle(
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.W100,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
        ),
        area = TextStyle(
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.W100,
            fontSize = 14.sp,
            lineHeight = 22.sp,
            letterSpacing = .5.sp,
        ),
    )

val TextStyle.emphasise get() = this.copy(fontWeight = FontWeight.W400)

val LocalTypography = staticCompositionLocalOf { tiaraElmTypography }
