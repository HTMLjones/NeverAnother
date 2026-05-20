package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.neveranother.R

@Preview
@Composable
fun profileMeasurements() {
    val OrangeColor = Color(0xFFFF5F00)

    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.neveranotherlogo),
            contentDescription = "Never Another Logo",
            modifier = Modifier.fillMaxWidth()
                .height(250.dp)
                //Ændre i billede størrelsen
                .requiredSize(390.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.personicon),
            contentDescription = "Never Another Logo",
            modifier = Modifier.fillMaxWidth()
                .height(250.dp)
                //Ændre i billede størrelsen
                .requiredSize(390.dp)
        )
    }
}