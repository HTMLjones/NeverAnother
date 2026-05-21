package com.example.neveranother

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.component.BottomNavBar
import com.example.neveranother.pages.CartScreen
import com.example.neveranother.pages.HomeScreen
import com.example.neveranother.pages.MeasurementScreen
import com.example.neveranother.pages.ProfileScreen
import com.example.neveranother.pages.ResultScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold(
                containerColor = Color(0xFFFFFFFF),
                contentWindowInsets = WindowInsets(0.dp),
                bottomBar = { BottomNavBar(navController) }) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "measure-screen",
                    modifier = Modifier.padding(innerPadding)
                ) {
                    //Home screen
                    composable("cart-screen") {
                        CartScreen()
                    }
                    composable("home-screen") {
                        HomeScreen()
                    }
                    composable("profile-screen") {
                        ProfileScreen()
                    }
                    //Measurement start screen
                    composable("measure-screen") {
                        MeasurementScreen()
                    }
                    composable("result-screen") {
                        ResultScreen()
                    }
                }
            }
        }
    }
}