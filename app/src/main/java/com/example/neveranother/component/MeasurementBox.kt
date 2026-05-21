package com.example.neveranother.component

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Jannik
@Composable
fun MeasurementBox(
    title: String,
    value: String,
    unit: String = "CM",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier
            .width(110.dp)
            .border(
                1.dp,
                Color(0xFF9A8F7A),
                RoundedCornerShape(4.dp)
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = title,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = value,
            onValueChange = { newValue ->
                if (
                    newValue.count { it == '.' } <= 1 &&
                    newValue.all { it.isDigit() || it == '.' }
                ) {
                    onValueChange(newValue)
                }
            },

            singleLine = true,

            trailingIcon = {
                Text(unit)
            },

            modifier = Modifier.height(50.dp)
        )
    }
}