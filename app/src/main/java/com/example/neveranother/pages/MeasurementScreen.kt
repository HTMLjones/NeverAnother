package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.classes.viewModel.GuideViewModel
import com.example.neveranother.classes.viewModel.MeasureViewModel
import com.example.neveranother.component.MeasureBox

//Simon
@Composable
fun MeasurementScreen(
    navController: NavController,
    measurementViewModel: MeasureViewModel
) {
    val measurements = measurementViewModel.measurements.take(6)
    var selectedMeasurement by remember { mutableStateOf(measurements.first()) }
    val measurementRows = measurements.chunked(3)

/*
#####################Fik en del hjælp af AI til denne selectedMeasurementHistory
Tilbage knap kunne ikke være popBackstack da det kører på navcontrolleren og dermed ville gå tilbage til homepage
så måtte lave en historik i en liste som kan selecte prev element og vælge den igen
 */
    val selectedMeasurementHistory = remember { mutableListOf<Int>() }
//#########################

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Segment 1: overskrift
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(start = 24.dp, end = 24.dp, top = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "Tilbage knap",
                tint = Color(0xFF2F3136),
                modifier = Modifier
                    .size(35.dp)
                    .clickable {
//#####Fortsættelse af AI hjælp her til tilbage knap historik##################
                        if (selectedMeasurementHistory.isNotEmpty()) {
                            val previousMeasurementId =
                                selectedMeasurementHistory.removeAt(selectedMeasurementHistory.lastIndex)
                            measurements.firstOrNull { it.measurementId == previousMeasurementId }
                                ?.let {
                                    selectedMeasurement = it
                                }
                        } else {
                            navController.popBackStack()
                        }
//############################ Hertil ########################################
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Indtast dine mål",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2F3136),
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Segment 2: billede
        Image(
            painter = painterResource(selectedMeasurement.image),
            contentDescription = "Measurement focus billede",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(7f)
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
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.CenterStart
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
                .weight(1.5f)
                .padding(top = 10.dp), contentAlignment = Alignment.Center
        ) {
            OutlinedTextField(
                //Her er der også fejl ift measurement Value
                value = selectedMeasurement.getMeasurementValue(),
                onValueChange = {
                    selectedMeasurement.setMeasurementValue(it)
                },//it refers to value
                label = null,
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
                ),
                maxLines = 1
            )
            //Jannik
            IconButton(
                modifier = Modifier.offset(
                        x = 130.dp, y = (-2).dp
                    ),

                onClick = {

                    GuideViewModel.selectedGuideId = selectedMeasurement.measurementId


                    navController.navigate(
                        "guide-screen"
                    )
                }

            ) {

                Icon(

                    imageVector = Icons.Default.Info,

                    contentDescription = "Guide",

                    tint = Color(0xFFE07B39)
                )
            }
        }


        //Simon Segment 6: bokse (2 rækker x 3 kolonner)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
                .padding(start = 16.dp, end = 16.dp, top = 26.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp, Alignment.Bottom)
        ) {
            measurementRows.forEach { rowMeasurements ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
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
                                    .border(
                                        width = 2.dp,
                                        color = Color(0xFF8A887F),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .clickable { navController.navigate("result-screen") },/*
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