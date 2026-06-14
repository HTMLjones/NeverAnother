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
import com.example.neveranother.classes.viewModel.MeasureViewModel
import com.example.neveranother.classes.viewModel.ProfilViewModel
import com.example.neveranother.component.BottomNavBar
import com.example.neveranother.pages.CartScreen
import com.example.neveranother.pages.GuideScreen
import com.example.neveranother.pages.HomeScreen
import com.example.neveranother.pages.LoginScreen
import com.example.neveranother.pages.MeasurementScreen
import com.example.neveranother.pages.ProfileGiftCardScreen
import com.example.neveranother.pages.ProfileMeasurementsScreen
import com.example.neveranother.pages.ProfileScreen
import com.example.neveranother.pages.ProfileShippingScreen
import com.example.neveranother.pages.ProfileStartScreen
import com.example.neveranother.pages.ResultScreen
import com.example.neveranother.pages.registerProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val measurementViewModel = viewModel<MeasureViewModel>()
            val profilViewModel = viewModel<ProfilViewModel>()
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
                    composable("home-screen") {
                        HomeScreen(navController)
                    }

                    composable("cart-screen") {
                        CartScreen(navController)
                    }

                    composable("guide-screen") {
                        GuideScreen(navController)
                    }

                    composable("measurement-screen") {
                        MeasurementScreen(navController, measurementViewModel)
                    }

                    composable("result-screen") {
                        ResultScreen(navController, measurementViewModel)
                    }

                    composable("profile-start-screen") {
                        ProfileStartScreen(navController)
                    }

                    composable("register") {
                        registerProfileScreen(navController, profilViewModel)
                    }

                    composable("Login") {
                        LoginScreen(navController, profilViewModel)
                    }

                    composable("profile-screen") {
                        ProfileScreen(navController, profilViewModel)
                    }

                    composable("profile-shipping-screen") {
                        ProfileShippingScreen(navController, profilViewModel)
                    }

                    composable("shipping") {
                        ProfileShippingScreen(navController, profilViewModel)
                    }

                    composable("profile-measurements-screen") {
                        ProfileMeasurementsScreen(navController, profilViewModel)
                    }

                    composable("gavekort") {
                        ProfileGiftCardScreen(navController, profilViewModel)
                    }
                }


            }
        }
    }
}
