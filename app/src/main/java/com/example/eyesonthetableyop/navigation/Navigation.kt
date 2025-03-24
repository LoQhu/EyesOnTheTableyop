//package com.example.eyesonthetableyop.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.eyesonthetableyop.screens.HomeScrollScreen
//import com.example.eyesonthetableyop.screens.NewPostScreen
//import kotlinx.serialization.Serializable
//
//@Composable
//fun Navigation() {
//    val navController = rememberNavController()
//
//    NavHost(
//    navController = navController,
//    startDestination = HomeScreen
//    ) {
//        composable<HomeScreen> {
//            HomeScrollScreen()
//        }
//        composable<NewPostScreen> {
//            NewPostScreen(navController)
//        }
//    }
//
//}
//@Serializable
//object HomeScreen
//@Serializable
//object NewPostScreen