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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.classes.viewModel.HomeViewModel
import com.example.neveranother.component.BottomNavBar
import com.example.neveranother.pages.CartScreen
import com.example.neveranother.pages.GuideScreen
import com.example.neveranother.pages.HomeScreen
import com.example.neveranother.pages.ProfileScreen
import com.example.neveranother.pages.ProfileShippingScreen
import com.example.neveranother.pages.MeasurementScreen
import com.example.neveranother.pages.ProfileMeasurementsScreen
import com.example.neveranother.pages.ResultScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val homeViewModel = viewModel<HomeViewModel>()
            val navController = rememberNavController()
            Scaffold(
                containerColor = Color(0xFFFFFFFF),
                contentWindowInsets = WindowInsets(0.dp),
                bottomBar = { BottomNavBar(navController) }) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "home-screen",
                    modifier = Modifier.padding(innerPadding)
                ) {
                    //Home screen
                    composable("cart-screen") {
                        CartScreen()
                    }
                    composable("home-screen") {
                        HomeScreen(navController)
                    }
                    composable("profile-screen") {
                        ProfileScreen(navController)
                    }
                    composable(route = "profile-shipping-screen") {
                        ProfileShippingScreen()
                    }
                    composable(route = "profile-measurements-screen") {
                        ProfileMeasurementsScreen()
                    }
                    //Measurement start screen
                    composable("measure-screen") {
                        MeasurementScreen(
                            navController =
                                navController
                        )
                    }
                    composable("result-screen") {
                        ResultScreen()
                    }
                    composable("guide-screen") {

                        GuideScreen(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}