package com.example.karhim_app_jpc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.karhim_app_jpc.R
import com.example.karhim_app_jpc.navigation.AppScreens
import kotlinx.coroutines.delay


//logica y pintado
@Composable
fun SplashScreen(navController: NavController){
    //despues de unos segundos navegamos a la pantalla 1
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        navController.navigate(AppScreens.FirstScreen.route)
    }
    Splash()
}

//pintado
@Composable
fun Splash(){
    Column (
        modifier = Modifier.fillMaxSize()
            .background(color = Color.hsl(14f, 0.93f, 0.71f)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(id = R.drawable.logokarhim),
            contentDescription = "Logo Karhim",
            Modifier.size(200.dp,200.dp)
                .clip(RoundedCornerShape(50.dp))

        )
        Text(text = "Bienvenid@s",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    Splash()
}