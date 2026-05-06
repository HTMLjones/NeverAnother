package com.example.neveranother.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.MainActivity
import com.example.neveranother.pages.Homescreen
import com.example.neveranother.pages.test
import com.example.neveranother.viewModel.neverAnotherViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: neverAnotherViewModel = viewModel()

    NavHost(navController = navController, startDestination = "homescreen") {
        composable("homescreen") {
            Homescreen(navController = navController, viewModel = viewModel)
        }
        composable("test") {
            test(navController = navController, viewModel = viewModel)
        }
    }
}