package com.example.neveranother.pages
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.R

/*Lavet Af Jazmin*/

@Composable
fun ProfileStartScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F6F2))
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(70.dp))

        Image(
            painter = painterResource(id = R.drawable.neveranotherlogo),
            contentDescription = "Never Another logo",
            modifier = Modifier
                .width(300.dp)
                .height(90.dp)
        )

        Spacer(modifier = Modifier.height(240.dp))

        Button(
            onClick = {
                navController.navigate("register-screen")
            },
            modifier = Modifier
                .width(255.dp)
                .height(48.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF5A00),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Opsæt din profil",
                fontSize = 17.sp
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Har du allerede en bruger?",
            fontSize = 15.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.clickable {
                navController.navigate("login-screen")
            },
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Log ind ",
                fontSize = 15.sp,
                color = Color.Black
            )

            Text(
                text = "her",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}