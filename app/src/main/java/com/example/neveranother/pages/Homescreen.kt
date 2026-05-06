package com.example.neveranother.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.neveranother.viewModel.neverAnotherViewModel

@Composable
fun Homescreen(navController: NavController, viewModel: neverAnotherViewModel) {
    Column(Modifier.fillMaxSize()) {
        Button(onClick = {
            navController.navigate("test")
        }) {
            Text("Go to Test Screen")
        }
    }
}