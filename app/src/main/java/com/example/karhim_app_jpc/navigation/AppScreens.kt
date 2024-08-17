package com.example.karhim_app_jpc.navigation


//se definen las pantallas que tendrá la app
sealed class AppScreens(val route: String) {
    object SplashScreen: AppScreens("splash_screen")
    object FirstScreen : AppScreens("first_screen");
    object PrincipalScreen : AppScreens("principal_screen");
    object CardScreen: AppScreens("card_screen")
}