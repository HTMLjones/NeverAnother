package com.example.neveranother.pages

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neveranother.classes.viewModel.MeasureViewModel

@Composable
fun ResultScreen(){
    val viewModel = viewModel<MeasureViewModel>()
}