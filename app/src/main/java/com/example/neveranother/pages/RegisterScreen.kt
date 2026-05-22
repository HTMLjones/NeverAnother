package com.example.neveranother.pages

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.R
import com.example.neveranother.classes.controller.ProfilController



@Composable
// Jonas Mørk Nielsen
fun registerProfileScreen(navController: NavController) {

    val OrangeColor = Color(0xFFFF5F00)

    var email by remember { mutableStateOf("") }

    var adgangskode by remember { mutableStateOf("") }

    val krav = listOf(
        "Mindst 8 tegn",
        "Et stort bogstav",
        "Et tal",
        "Et special tegn (! @ & % # =)")

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.neveranotherlogo),
            contentDescription = "Never Another Logo",
            modifier = Modifier.fillMaxWidth()
                .height(250.dp)
                //Ændre i billede størrelsen
                .requiredSize(390.dp)
        )

        Spacer(Modifier.height(30.dp))

        Text("E-mail")

        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Email@gmail.com") },
            shape = RoundedCornerShape(3.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = (OrangeColor),
                unfocusedBorderColor = (OrangeColor)
            )
        )

        Spacer(Modifier.height(60.dp))

        Text("Adgangskode")

        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = adgangskode,
            onValueChange = { adgangskode = it },
            placeholder = { Text("Password") },
            shape = RoundedCornerShape(3.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = (OrangeColor),
                unfocusedBorderColor = (OrangeColor)
            )
        )

        Spacer(Modifier.height(20.dp))

        Column(modifier = Modifier.wrapContentWidth()) {
            krav.forEach { Text(text = "✓ $it") }
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = { },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6A00)
            ),
            modifier = Modifier
                .height(55.dp)
        ) {
            Text(
                text = "Fortsæt",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}

