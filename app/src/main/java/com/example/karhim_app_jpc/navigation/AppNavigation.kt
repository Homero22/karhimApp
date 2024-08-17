package com.example.karhim_app_jpc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.karhim_app_jpc.screens.CardScreen
import com.example.karhim_app_jpc.screens.FirstScreen
import com.example.karhim_app_jpc.screens.PrincipalScreen
import com.example.karhim_app_jpc.screens.SplashScreen
import com.example.karhim_app_jpc.screens.TarjetaAlimentacion


//Gestionar las pantallas
@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(route=AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(route=AppScreens.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route = AppScreens.PrincipalScreen.route){
            PrincipalScreen(navController)
        }
        composable(route=AppScreens.CardScreen.route){
            CardScreen(navController)
        }
    }
}