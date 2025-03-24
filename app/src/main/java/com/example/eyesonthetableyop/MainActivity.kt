package com.example.eyesonthetableyop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eyesonthetableyop.screens.HomeScrollScreen
import com.example.eyesonthetableyop.screens.NewPostScreen
import com.example.eyesonthetableyop.ui.theme.EyesOnTheTableyopTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EyesOnTheTableyopTheme {
                val systemUiController= rememberSystemUiController()
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = HomeScreen
                ) {
                    composable<HomeScreen> {
                        HomeScrollScreen(navController = navController,
                            onNewPostClick = {navController.navigate(NewPostScreen)}
                        )
                    }
                    composable<NewPostScreen> {
                        NewPostScreen(navController = navController)
                    }
                }

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Red
                    )
                }
            }
        }
    }
}

@Serializable
object HomeScreen

@Serializable
object NewPostScreen

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EyesOnTheTableyopTheme {
    }
}