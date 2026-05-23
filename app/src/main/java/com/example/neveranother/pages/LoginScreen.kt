package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import com.example.neveranother.classes.viewModel.ProfilViewModel

/*Jazmin*/

@Composable
fun LoginScreen(navController: NavController, viewModel: ProfilViewModel) {

    val orange = Color(0xFFFF5A00)
    val backgroundColor = Color(0xFFF8F7F4)
    val textColor = Color(0xFF1F1F1F)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .imePadding()
                .padding(top = 55.dp, bottom = 30.dp),
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
                    .width(290.dp)
                    .height(90.dp)
            )

            Spacer(modifier = Modifier.height(80.dp))

            Text(text = "Email", fontSize = 20.sp, color = textColor)

            Spacer(modifier = Modifier.height(8.dp))

            LoginInputField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                placeholder = "din@email.com",
                isPassword = false
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(text = "Adgangskode", fontSize = 20.sp, color = textColor)

            Spacer(modifier = Modifier.height(8.dp))

            LoginInputField(
                value = viewModel.adgangskode,
                onValueChange = { viewModel.adgangskode = it },
                placeholder = "Asdasd123",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(120.dp))

            Button(
                onClick = { navController.navigate("profile-screen") },
                colors = ButtonDefaults.buttonColors(containerColor = orange),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.width(135.dp).height(55.dp)
            ) {
                Text(
                    text = "Log Ind",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Mål selv",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 13.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 28.dp, bottom = 20.dp)
            )
        }
    }
}

@Composable
fun LoginInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean
) {
    Box(
        modifier = Modifier
            .width(210.dp)
            .height(34.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White)
            .border(
                width = 1.5.dp,
                color = Color(0xFFFF5A00),
                shape = RoundedCornerShape(4.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            ),
            decorationBox = { innerTextField ->
                Box(contentAlignment = Alignment.Center) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = Color.Gray.copy(alpha = 0.7f),
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}