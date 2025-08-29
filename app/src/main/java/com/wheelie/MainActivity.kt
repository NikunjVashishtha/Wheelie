package com.wheelie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.wheelie.ui.theme.Disc
import com.wheelie.ui.theme.WheelieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WheelieTheme {
                MainScreen(
                    modifier = Modifier.statusBarsPadding()
                )
            }
        }
    }
}

data class Sector(
    val value: String,
    val color: Color,
)

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Disc()
}
