package com.example.karhim_app_jpc.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.karhim_app_jpc.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CardScreen(navController: NavController)
{
    TarjetaAlimentacion(navController = navController, logo = painterResource(id = R.drawable.logo2) , title ="D'KARHIM",slogan="Con Sabor Original" , clientName ="RUBÉN" )
}


@Composable
fun TarjetaAlimentacion(
    navController: NavController,
    logo: Painter,
    title: String,
    slogan: String,
    clientName: String,
    totalMeals: Int = 30
) {
    var selectedMeals by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
            .padding(top = 100.dp)
            .padding(bottom = 100.dp)
            .background(Color.White, shape = RoundedCornerShape(15.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,

        )

        // Title
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )

        //slogan
        Text(
            text = "$slogan",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(8.dp)
        )

        // Client Name
        Text(
            text = "Cliente: $clientName",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Grid of Meals
        val rows = 6
        val columns = 5
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(rows) { rowIndex ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(columns) { columnIndex ->
                        val index = rowIndex * columns + columnIndex
                        if (index < totalMeals) {
                            MealSquare(
                                isSelected = index < selectedMeals,
                                onClick = {
                                    selectedMeals = if (index < selectedMeals) index else index + 1
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MealSquare(isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(
                if (isSelected) Color.Red else Color.LightGray,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center


    ) {
        if (isSelected) {
            Canvas(modifier = Modifier.size(24.dp)) {
                drawLine(
                    color = Color.White,
                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                    strokeWidth = 4f
                )
                drawLine(
                    color = Color.White,
                    start = androidx.compose.ui.geometry.Offset(size.width, 0f),
                    end = androidx.compose.ui.geometry.Offset(0f, size.height),
                    strokeWidth = 4f
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaAlimentacionPreview() {
    val navController = rememberNavController()
    CardScreen(navController = navController)

}


