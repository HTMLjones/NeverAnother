package com.example.neveranother.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neveranother.classes.viewModel.MeasureViewModel

@Composable
fun CartScreen() {
    val viewModel = viewModel<MeasureViewModel>()

    //Bare fjern background color, jeg brugte det bare til spacing af siden.
    //Laver videre i morgen
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Segment 1: Overskrift
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
                .background(Color.Green)
        ) {

        }
        // Segment 2: Kurv indhold visuelt
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
                .background(Color.Yellow)
        ) {

        }
        // Segment 3: Profil information
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {
            // Navn mail adresse
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = Color.Red)
            ) {
                Text(
                    text = "Navn",
                    fontSize = 14.sp,
                    color = Color(0xFF4A4A4A)
                )
                Text(
                    text = "E-Mail",
                    fontSize = 14.sp,
                    color = Color(0xFF4A4A4A)
                )
                Text(
                    text = "Adresse",
                    fontSize = 14.sp,
                    color = Color(0xFF4A4A4A)
                )
            }
            // Profil data til højre
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = Color.Blue)
            ) {
                Text(
                    text = "Profil data skal hentes hertil",
                    fontSize = 14.sp,
                    color = Color(0xFF4A4A4A)
                )

            }
        }
        // Segment 4: Pris og subtotal
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .background(Color.Yellow)
        ) {

        }
        // Segment 5: Knap til betal
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f)
                .background(Color.Green)
        ) {

        }
    }
}