package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.R

/* Jazmin */

@Composable
fun ProfileShippingScreen() {

    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var addressComponent by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF9F6))
            .padding(horizontal = 32.dp, vertical = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = R.drawable.neveranotherlogo),
            contentDescription = "Never Another logo",
            modifier = Modifier
                .width(260.dp)
                .height(100.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        ShippingInputField(
            title = "Navn",
            value = name,
            placeholder = "Fulde navn",
            onValueChange = { name = it }
        )

        ShippingInputField(
            title = "Adresse",
            value = address,
            placeholder = "Gade og husnummer",
            onValueChange = { address = it }
        )

        ShippingInputField(
            title = "Adresse Komponent",
            value = addressComponent,
            placeholder = "Etage/dør",
            onValueChange = { addressComponent = it }
        )

        ShippingInputField(
            title = "Postnummer",
            value = postalCode,
            placeholder = "f.eks. 1473",
            onValueChange = { postalCode = it }
        )

        ShippingInputField(
            title = "Telefon",
            value = phone,
            placeholder = "+45 00 00 00 00",
            onValueChange = { phone = it }
        )

        Spacer(modifier = Modifier.height(22.dp))

        Button(
            onClick = {
                // Her kan du senere navigere videre
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF5A00)
            ),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .width(130.dp)
                .height(52.dp)
        ) {
            Text(
                text = "Fortsæt",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ShippingInputField(
    title: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    Text(
        text = title,
        color = Color.Black,
        fontSize = 18.sp,
        modifier = Modifier.padding(bottom = 6.dp)
    )

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray,
                fontSize = 13.sp
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFFAF9F6),
            unfocusedContainerColor = Color(0xFFFAF9F6),
            focusedIndicatorColor = Color(0xFFFF5A00),
            unfocusedIndicatorColor = Color(0xFFFF5A00),
            cursorColor = Color(0xFFFF5A00)
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .width(220.dp)
            .height(54.dp)
    )

    Spacer(modifier = Modifier.height(8.dp))
}

