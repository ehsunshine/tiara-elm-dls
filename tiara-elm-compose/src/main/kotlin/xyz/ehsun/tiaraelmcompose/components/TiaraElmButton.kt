package xyz.ehsun.tiaraelmcompose.components

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import xyz.ehsun.tiaraelmcompose.foundation.TiaraElmTheme
import xyz.ehsun.tiaraelmcompose.foundation.emphasise

@Composable
fun TiaraElmButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonType: ButtonType = ButtonType.Primary,
    buttonStyle: ButtonStyle = ButtonStyle.Brand,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .height(52.dp),
        onClick = onClick,
        colors = buttonColors(buttonType, buttonStyle),
        enabled = enabled,
        shape = RoundedCornerShape(24.dp),
        elevation = buttonElevation(),
        border = borderStroke(buttonType, buttonStyle, enabled)
    ) {
        ButtonContent(text, buttonType)
    }
}

@Composable
private fun borderStroke(buttonType: ButtonType, buttonStyle: ButtonStyle, enabled: Boolean) =
    when (buttonType) {
        ButtonType.Primary -> null
        ButtonType.Secondary -> BorderStroke(
            3.dp,
            styleColor(buttonStyle).let { if (!enabled) it.copy(alpha = .5f) else it }
        )
    }

@Composable
private fun ButtonContent(
    text: String,
    buttonType: ButtonType
) {
    Text(
        modifier = Modifier.padding(8.dp),
        text = text,
        style = TiaraElmTheme.typography.mare.let {
            if (buttonType == ButtonType.Secondary) it.emphasise else it
        },
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        textAlign = TextAlign.Center,
    )
}

@Composable
private fun buttonElevation() =
    ButtonDefaults.elevation(
        defaultElevation = 0.dp,
        pressedElevation = 0.dp,
        hoveredElevation = 0.dp,
        focusedElevation = 0.dp
    )

@Composable
private fun buttonColors(
    buttonType: ButtonType,
    buttonStyle: ButtonStyle
) = when (buttonType) {
    ButtonType.Primary -> ButtonDefaults.buttonColors(
        backgroundColor = styleColor(buttonStyle),
        contentColor = TiaraElmTheme.colors.foreground.primary,
        disabledBackgroundColor = styleColor(buttonStyle).copy(alpha = .5f),
        disabledContentColor = TiaraElmTheme.colors.foreground.secondary,
    )
    ButtonType.Secondary -> ButtonDefaults.buttonColors(
        backgroundColor = Color.Transparent,
        contentColor = styleColor(buttonStyle),
        disabledBackgroundColor = Color.Transparent,
        disabledContentColor = styleColor(buttonStyle).copy(alpha = .5f),
    )

}

@Composable
private fun styleColor(buttonStyle: ButtonStyle) =
    when (buttonStyle) {
        ButtonStyle.Brand -> TiaraElmTheme.colors.brand.primary
        ButtonStyle.Destructive -> TiaraElmTheme.colors.feedback.negative
    }

enum class ButtonType { Primary, Secondary }
enum class ButtonStyle { Brand, Destructive }

/**
Make it compatible with AndroidView and ViewBinding
<pre>
binding.tiaraElmButton.apply {
text = "My Text"
type = ButtonType.Secondary
onClick = { ... }
}
</pre>
 **/
class TiaraElmButtonCompat @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var text by mutableStateOf<String>("")
    var onClick by mutableStateOf<() -> Unit>({})
    var type by mutableStateOf<ButtonType>(ButtonType.Primary)
    var style by mutableStateOf<ButtonStyle>(ButtonStyle.Brand)

    @Composable
    override fun Content() {
        TiaraElmTheme {
            TiaraElmButton(
                buttonType = type,
                buttonStyle = style,
                text = text,
                onClick = onClick,
                enabled = isEnabled,
            )
        }
    }
}
