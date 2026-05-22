package com.example.neveranother.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.classes.BhMeasurements

//Simon
@Composable
fun MeasureBox(
    title: String,
    onClick: () -> Unit,
    measurements: BhMeasurements,
    modifier: Modifier = Modifier
) {
    /*Denne værdi er den værdi som er gemt på det objekt af BhMeasurements,
    som hentes til hver boks. Forestiller mig at når databasen kommer op og
    vi poster det der, at dette vil virke */
    val measurementInput = measurements.measurementValue ?: 0.0

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFDCD8CB))
            .border(width = 2.dp, color = Color(0xFF8A887F), shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                color = Color(0xFF3D3F45),
                fontSize = 13.sp,
                lineHeight = 17.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                maxLines = 3
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFE7E5E0))
                .border(width = 2.dp, color = Color(0xFF8A887F), shape = RoundedCornerShape(8.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                //Boksens tekstfelt altså "0.0 CM"
                Text(
                    //Virker ikke fordi den henter fra viewmodel og dermed ikke bliver opdateret
                    // undervejs, men den skal vise de indtastede målinger når de bliver skrevet ind
                    text = measurementInput.toString(),
                    modifier = Modifier.weight(1f),
                    color = Color(0xFF8E8E8E),
                    fontSize = 18.sp
                )

                Text(
                    text = "CM",
                    color = Color(0xFF8E8E8E),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}