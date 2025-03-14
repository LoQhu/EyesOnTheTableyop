package com.example.eyesonthetableyop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.eyesonthetableyop.screens.HomeScrollScreen
import com.example.eyesonthetableyop.screens.NewPostScreen
import com.example.eyesonthetableyop.ui.theme.EyesOnTheTableyopTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EyesOnTheTableyopTheme {
                val systemUiController= rememberSystemUiController()

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Red
                    )
                }
                //HomeScrollScreen()
                NewPostScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EyesOnTheTableyopTheme {
    }
}