package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.R
import com.example.neveranother.classes.viewModel.ProfilViewModel

/* Jazmin */

@Composable
fun ProfileScreen(navController: NavController, profilViewModel: ProfilViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F5))
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(horizontal = 34.dp)
            .padding(top = 42.dp, bottom = 110.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ← Tilbage-knap
        Box(
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.Start)
                .clickable { navController.popBackStack() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.size(30.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.neveranotherlogo),
            contentDescription = "Never Another logo",
            modifier = Modifier
                .width(310.dp)
                .height(65.dp)
        )

        Text(
            text = "Profil",
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 0.dp, bottom = 28.dp)
        )

        ProfileInputRow(
            label = "Navn",
            placeholder = "Fulde navn",
            value = profilViewModel.navn,
            onValueChange = { profilViewModel.navn = it }
        )
        Spacer(modifier = Modifier.height(20.dp))

        ProfileInputRow(
            label = "Adresse",
            placeholder = "Vej, By",
            value = profilViewModel.adresse,
            onValueChange = { profilViewModel.adresse = it }
        )
        Spacer(modifier = Modifier.height(20.dp))

        ProfileInputRow(
            label = "Telefon",
            placeholder = "+45 00 00 00 00",
            value = profilViewModel.telefon,
            onValueChange = { profilViewModel.telefon = it }
        )
        Spacer(modifier = Modifier.height(20.dp))

        ProfileInputRow(
            label = "Email",
            placeholder = "din@email.com",
            value = profilViewModel.email,
            onValueChange = { profilViewModel.email = it }
        )

        Spacer(modifier = Modifier.height(50.dp))

        OrangeLine()

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Ordre",
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp, bottom = 14.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OrderRow(label = "Dine bestillinger", buttonText = "Spor og administrér køb  >")

        Spacer(modifier = Modifier.height(12.dp))

        OrderRow(label = "Gave kort", buttonText = "Se saldo og indløs  >")

        Spacer(modifier = Modifier.height(30.dp))

        OrangeLine()

        Text(
            text = "Målinger",
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp, bottom = 28.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OrangeButton(
                text = "Dine Mål",
                onClick = { navController.navigate("profile-measurements-screen") }
            )
            OrangeButton(
                text = "Mål selv",
                onClick = { navController.navigate("measurement-screen") }
            )
        }
    }
}

@Composable
fun ProfileInputRow(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier.width(120.dp)
        )

        Box(
            modifier = Modifier
                .width(190.dp)
                .height(42.dp)
                .border(
                    width = 1.3.dp,
                    color = Color(0xFFFF5A00),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(horizontal = 18.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            BasicTextField(
                value = value,
                onValueChange = { onValueChange(it) },
                singleLine = true,
                textStyle = TextStyle(fontSize = 13.sp, color = Color.Black),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(text = placeholder, color = Color.LightGray, fontSize = 13.sp)
                    }
                    innerTextField()
                })
        }
    }
}

@Composable
fun OrderRow(label: String, buttonText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.width(190.dp)
        )
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(36.dp)
                .border(
                    width = 1.3.dp,
                    color = Color(0xFFFF5A00),
                    shape = RoundedCornerShape(3.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = buttonText,
                fontSize = 10.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
        }
    }
}

@Composable
fun OrangeButton(
    text: String, onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5A00)),
        shape = RoundedCornerShape(50.dp),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .width(135.dp)
            .height(45.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun OrangeLine() {
    Divider(
        color = Color(0xFFFF5A00),
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth()
    )
}