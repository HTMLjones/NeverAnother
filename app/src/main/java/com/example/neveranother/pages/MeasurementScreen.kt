package com.example.neveranother.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neveranother.classes.viewModel.MeasureViewModel
import com.example.neveranother.component.MeasureBox

@Composable
fun MeasurementScreen() {
    val measureViewModel = viewModel<MeasureViewModel>()
    //Det er sådan jeg kan finde ud af at gøre det, der findes nok en bedre måde :)
    val measurements = measureViewModel.measurements.take(6)
    //Brugerens input
    val measurementValues = measureViewModel.measurementValues
    var selectedMeasurement by remember { mutableStateOf(measurements.first()) }
    val measurementRows = measurements.chunked(3)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Segment 1: overskrift
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Tilbage knap",
                    tint = Color(0xFF1A1A1A)
                )
            }
            Text(
                text = "Lav dine målinger digitalt",
                modifier = Modifier.weight(4f),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
        }

        // Segment 2: billede
        Image(
            painter = painterResource(selectedMeasurement.image),
            contentDescription = "Measurement focus billede",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
                .padding(horizontal = 16.dp)
        )

        // Segment 3: measurementName
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp, end = 16.dp, top = 10.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = selectedMeasurement.measurementName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A)
            )
        }

        // Segment 4: measurementDescription
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = selectedMeasurement.measurementDescription,
                fontSize = 14.sp,
                color = Color(0xFF4A4A4A)
            )
        }

        // Segment 5: textfelt
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            OutlinedTextField(
                value = measurementValues[selectedMeasurement.measurementId] ?: "",
                onValueChange = { measurementValues[selectedMeasurement.measurementId] = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Skriv målingen her") },
                singleLine = true
            )
        }

        // Segment 6: bokse (2 rækker x 3 kolonner)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4.5f)
                .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 6.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Bottom)
        ) {
            measurementRows.forEach { rowMeasurements ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    rowMeasurements.forEach { measurement ->
                        MeasureBox(
                            title = measurement.measurementName,
                            onClick = { selectedMeasurement = measurement },
                            measurements = measurement,
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1.35f)
                        )
                    }
                }
            }
        }
    }
}