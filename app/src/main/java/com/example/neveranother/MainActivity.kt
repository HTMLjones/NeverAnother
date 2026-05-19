package com.example.neveranother

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.component.BottomNavBar
import com.example.neveranother.classes.viewModel.HomeViewModel
import com.example.neveranother.pages.CartScreen
import com.example.neveranother.pages.HomeScreen
import com.example.neveranother.pages.ProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val homeViewModel = viewModel<HomeViewModel>()
            val navController = rememberNavController()
            Scaffold(
                containerColor = Color(0xFFFFFFFF),
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
                        HomeScreen()
                    }
                    composable("profile-screen") {
                        ProfileScreen()
                    }
                }
            }
        }
    }
}