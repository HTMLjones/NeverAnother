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
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neveranother.R
import java.sql.Date

@Preview
@Composable
fun profileMeasurements() {
    val OrangeColor = Color(0xFFFF5F00)

    var omfangOverBryst by remember { mutableStateOf("") }
    var omfangUnderBryst by remember { mutableStateOf("") }
    var volumeType by remember { mutableStateOf("") }
    var brystBredde by remember { mutableStateOf("") }
    var brystHøjde by remember { mutableStateOf("") }
    var dato by remember { mutableStateOf("") }



    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.neveranotherlogo),
            contentDescription = "Never Another Logo",
            modifier = Modifier.fillMaxWidth()
                .height(180.dp)
                //Ændre i billede størrelsen
                .requiredSize(390.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.modelpictureprofile),
            contentDescription = "Never Another Model Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(450.dp)
                .width(350.dp)
                .border(
                    width = 3.dp,
                    color = (OrangeColor),
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
                        text = omfangOverBryst.ifEmpty { "0.00 CM" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text("Omfang under brystet")
                    Text(
                        text = omfangUnderBryst.ifEmpty { "0.00 CM" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            // Anden række
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Volume Type")
                    Text(
                        text = volumeType.ifEmpty { "*SELECTED TYPE*" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text("Brystbredde")
                    Text(
                        text = brystBredde.ifEmpty { "0.00 CM" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Brysthøjde")
                    Text(
                        text = brystHøjde.ifEmpty { "0.00 CM" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text("Dato for mål")
                    Text(
                        text = dato.ifEmpty { "xx/xx/xx" },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Tekst over knapper
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Dine Mål",
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Mål selv",
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Knapper
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = (OrangeColor))
                ) {
                    Text("Slet mål")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = { },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = (OrangeColor))
                ) {
                    Text("Bestil")
                }
            }
        }
    }
    }
