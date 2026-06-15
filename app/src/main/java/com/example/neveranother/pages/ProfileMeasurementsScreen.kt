package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.neveranother.R
import com.example.neveranother.classes.viewModel.MeasureViewModel
import com.example.neveranother.classes.viewModel.ProfilViewModel
import com.example.neveranother.component.HeaderWithReturn

@Composable
fun ProfileMeasurementsScreen(navController: NavController, viewModel: MeasureViewModel, profileViewModel: ProfilViewModel) {

    val orangeColor = Color(0xFFFF5F00)

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        // ← Tilbage-knap
        HeaderWithReturn(navController = navController)

        Image(
            painter = painterResource(id = R.drawable.modelpictureprofile),
            contentDescription = "Never Another Model Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(450.dp)
                .width(350.dp)
                .border(
                    width = 3.dp,
                    color = orangeColor,
                    shape = RoundedCornerShape(5.dp)
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // Første række
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Omfang over brystet")
                    Text(
                        text = viewModel.measurements[0].getMeasurementValue().ifEmpty { "0.00 CM" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Omfang under brystet")
                    Text(
                        text = viewModel.measurements[1].getMeasurementValue().ifEmpty { "0.00 CM" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            // Anden række
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Volume Type")
                    Text(
                        text = viewModel.measurements[2].getMeasurementValue().ifEmpty { "0.00 CM" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Brystbredde")
                    Text(
                        text = viewModel.measurements[3].getMeasurementValue().ifEmpty { "0.00 CM" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            // Tredje række
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Brysthøjde")
                    Text(
                        text = viewModel.measurements[4].getMeasurementValue().ifEmpty { "0.00 CM" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Dato for mål")
                    Text(
                        text = profileViewModel.datoForMaal.ifEmpty { "xx/xx/xx" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Tekst over knapper
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Dine Mål", modifier = Modifier.weight(1f))
                Text(text = "Mål selv", modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Knapper
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = orangeColor)
                ) {
                    Text("Slet mål")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = orangeColor)
                ) {
                    Text("Bestil")
                }
            }
        }
    }
}