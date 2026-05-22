package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.R

@Composable
//Jonas Mørk Nielsen
fun ProfileGiftCardScreen(navController: NavController) {

    var giftcard by remember { mutableStateOf("") }

    val OrangeColor = Color(0xFFFF5F00)

    val krav = listOf(
        "Min. 10 tegn",
        "Kun tal og bogstaver (A-Z, 0-9)",
        "Ingen mellemrum",
        "Et special tegn (f.eks. ! @ & % # =)"
    )

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.neveranotherlogo),
            contentDescription = "Never Another Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                //Ændre i billede størrelsen
                .requiredSize(390.dp)
        )

        Spacer(Modifier.height(100.dp))

        Text("Gavekort")

        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = giftcard,
            onValueChange = { giftcard = it },
            placeholder = { Text("Indtast gavekort her!") },
            shape = RoundedCornerShape(3.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = (OrangeColor), unfocusedBorderColor = (OrangeColor)
            )
        )

        Spacer(Modifier.height(20.dp))

        Column(modifier = Modifier.wrapContentWidth()) {
            krav.forEach { Text(text = "✓ $it") }
        }


        Spacer(Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("profile-screen") },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6A00)
            ),
            modifier = Modifier.height(55.dp)
        ) {
            Text(
                text = "Indløs", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        }
    }
}