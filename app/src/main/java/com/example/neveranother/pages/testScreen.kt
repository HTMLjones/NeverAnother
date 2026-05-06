package com.example.neveranother.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.neveranother.viewModel.neverAnotherViewModel

@Composable
fun test(navController: NavController, viewModel: neverAnotherViewModel) {
    Column(Modifier.fillMaxSize()) {
        Text("You are on the Test Screen 🎉")
    }
}