package com.example.karhim_app_jpc.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.karhim_app_jpc.navigation.AppScreens

@Composable
fun FirstScreen(navController: NavController){
    Scaffold{
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Iniciar")
        Button(onClick = {
            navController.navigate(route= AppScreens.PrincipalScreen.route)
        }) {
            Text(text = "Go")
        }
    }
}

