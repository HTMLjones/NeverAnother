package com.example.neveranother.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neveranother.R
import com.example.neveranother.classes.viewModel.MeasureViewModel
import com.example.neveranother.component.MeasureBox

@Composable
fun MeasurementScreen(
    onMeasurementClick: (Int) -> Unit
){
    val measureViewModel = viewModel<MeasureViewModel>()
    val measurementRows = measureViewModel.measurements.take(6).chunked(3)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(R.drawable.neveranotherlogo),
            contentDescription = "Measurement header image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Mål selv",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A)
            )

            Text(
                text = "Tag et blødt målebånd og din bedst siddende BH frem, og indtast dine mål nedenfor, så vi kan finde den BH, der passer dig bedst.\n" +
                        "\n" +
                        "Lad os begynde med dit øvre omfang.",
                fontSize = 14.sp,
                color = Color(0xFF4A4A4A)
            )

            measurementRows.forEach { rowMeasurements ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    rowMeasurements.forEach { measurement ->
                        MeasureBox(
                            title = measurement.measurementName,
                            onClick = { onMeasurementClick(measurement.measurementId) },
                            measurements = measurement,
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                        )
                    }
                }
            }
        }
    }
}