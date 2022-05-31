package xyz.ehsun.tiaraelm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.ehsun.tiaraelm.ui.theme.MyTheme
import xyz.ehsun.tiaraelmcompose.components.ButtonStyle
import xyz.ehsun.tiaraelmcompose.components.ButtonType
import xyz.ehsun.tiaraelmcompose.components.TiaraElmButton
import xyz.ehsun.tiaraelmcompose.foundation.TiaraElmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = TiaraElmTheme.colors.background.primary
                ) {
                    Column(Modifier.padding(top = 16.dp)) {
                        TiaraElmButton(
                            text = "Brand Primary",
                            enabled = false,
                            buttonStyle = ButtonStyle.Brand,
                            buttonType = ButtonType.Primary,
                            onClick = {},
                        )
                        TiaraElmButton(
                            text = "Destructive Primary",
                            enabled = false,
                            buttonStyle = ButtonStyle.Destructive,
                            buttonType = ButtonType.Primary,
                            onClick = {},
                        )
                        TiaraElmButton(
                            text = "Brand Secondary",
                            enabled = false,
                            buttonStyle = ButtonStyle.Brand,
                            buttonType = ButtonType.Secondary,
                            onClick = {},
                        )
                        TiaraElmButton(
                            text = "Destructive Secondary",
                            enabled = false,
                            buttonStyle = ButtonStyle.Destructive,
                            buttonType = ButtonType.Secondary,
                            onClick = {},
                        )
                    }
                }
            }
        }
    }
}
