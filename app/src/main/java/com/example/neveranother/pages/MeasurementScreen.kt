package com.example.neveranother.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.neveranother.classes.viewModel.MeasureViewModel
import com.example.neveranother.component.MeasureBox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.IconButton
import com.example.neveranother.classes.viewModel.GuideViewModel

//Simon
@Composable
fun MeasurementScreen(
    navController:
    NavController
) {
    val measureViewModel = viewModel<MeasureViewModel>()
    //Det er sådan jeg kan finde ud af at gøre det, der findes nok en bedre måde :)
    val measurements = measureViewModel.measurements.take(6)

    /*TODO lav en starter istedet for measurements.first, så den kan start på nummer 0
    *  Der mangler nemlig stadig en forside, eller ihvertfald den startside som vi har i figma
    *
    * */

    /*Input fra brugeren, bliver ført ind i measurementValue, men siden vi kører med predefined
     list of measurements fra MeasureViewModel, dette forestiller jeg
     mig bliver fikset når vi får sat databasen op, da værdierne bliver hentet fra objektet,
      som så skal opdateres hver gang der bliver indtastet en ny værdi
      */
    val measurementValues = measureViewModel.measurementValues
    val guideViewModel =
        viewModel<GuideViewModel>()
    var selectedMeasurement by remember { mutableStateOf(measurements.first()) }
    /*
    Bliver nødt til at lave en selectedMeasurementHistory for at kunne holde track
    på hvad tilbage på siden. Kommer til at tænke på om det ikke havde været nemmere at lave
    en screen til hver af measurement siderne, så den også kan opdatere værdierne tastet ind
    fra view model
     */
    val selectedMeasurementHistory = remember { mutableListOf<Int>() }
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
                .weight(1.2f)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        if (selectedMeasurementHistory.isNotEmpty()) {
                            val previousMeasurementId =
                                selectedMeasurementHistory.removeAt(selectedMeasurementHistory.lastIndex)
                            measurements.firstOrNull { it.measurementId == previousMeasurementId }?.let {
                                selectedMeasurement = it
                            }
                        } else {
                            navController.popBackStack()
                        }
                    },
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
                fontSize = 22.sp,
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
                .weight(6f)
                .padding(horizontal = 16.dp)
        )

        // Segment 3: measurementName
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .padding(start = 16.dp, end = 16.dp, top = 10.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = selectedMeasurement.measurementName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A)
            )
        }

        //Simon Segment 4: measurementDescription
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Text(
                text = selectedMeasurement.measurementDescription,
                fontSize = 14.sp,
                color = Color(0xFF4A4A4A)
            )
        }

        //Simon Segment 5: inputfelt
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            OutlinedTextField(
                value = measurementValues[selectedMeasurement.measurementId] ?: "",
                onValueChange = { measurementValues[selectedMeasurement.measurementId] = it },//it refers to value
                modifier = Modifier.fillMaxWidth(0.5f),
                placeholder = {
                    Text(
                        text = "0.00",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFB0B0B0),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A),
                    textAlign = TextAlign.Center
                ),
                trailingIcon = {
                    Text(
                        text = "CM",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFFB0B0B0),
                        modifier = Modifier.padding(end = 8.dp)
                    )
                },
                singleLine = true,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFE07B39),
                    unfocusedBorderColor = Color(0xFFE07B39),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            //Jannik
            IconButton(
                modifier =
                    Modifier
                        .offset(
                            x = 130.dp,
                            y = (-2).dp
                        ),

                onClick = {

                    GuideViewModel.selectedGuideId =
                        selectedMeasurement.measurementId


                    navController.navigate(
                        "guide-screen"
                    )
                }

            ) {

                Icon(

                    imageVector =
                        Icons.Default.Info,

                    contentDescription =
                        "Guide",

                    tint =
                        Color(0xFFE07B39)
                )
            }
        }


        //Simon Segment 6: bokse (2 rækker x 3 kolonner)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3.5f)
                .padding(start = 16.dp, end = 16.dp, top = 26.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Bottom)
        ) {
            measurementRows.forEach { rowMeasurements ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowMeasurements.forEach { measurement ->
                        if (measurement.measurementId == 6) {
                            // Burde laves som component men nu er den sidste box en knap istedet for en MeasureBox
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1.35f)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFFDCD8CB))
                                    .border(width = 2.dp, color = Color(0xFF8A887F), shape = RoundedCornerShape(10.dp))
                                    .clickable { navController.navigate("result-screen") },
                                /*
                                Tænker vi skal tilføje en guidepath til hvert measure sådan så vi kan
                                lave selectedMeasurement = measurement.measurementGuidePath agtigt for navigation
                                men kigger på det i morgen.

                                For at gøre det nemmere burde hjælp knappen være oppe ved siden af inputfeltet
                                så vi kan holde "brug for hjælp knappen til "færdig" og så komme til resultat
                                 */
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Indsend",
                                    color = Color(0xFF3D3F45),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                                )
                            }
                        } else {
                            MeasureBox(
                                title = measurement.measurementName,
                                onClick = {
                                    if (selectedMeasurement.measurementId != measurement.measurementId) {
                                        selectedMeasurementHistory.add(selectedMeasurement.measurementId)
                                        selectedMeasurement = measurement
                                    }
                                },
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
}
