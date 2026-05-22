package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.R
import com.example.neveranother.classes.viewModel.MeasureViewModel

@Composable
fun ResultScreen() {
    val viewModel = viewModel<MeasureViewModel>()
    val navController = rememberNavController()

    //Bare fjern background color, jeg brugte det bare til spacing af siden.
    //Laver videre i morgen
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Segment 1: Overskrift
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Tilbage knap",
                    tint = Color(0xFF1A1A1A)
                )
            }
            Text(
                text = "Her er dine resultater",
                modifier = Modifier.weight(4f),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
        // Segment 2: Data fra measurement
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
                .background(Color.Yellow)
        ) {
            //Venstre side over volume result
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = Color.Yellow)
            ) {
                //Over
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(start = 16.dp, end = 16.dp, top = 10.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(
                            text = "Omfang over brystet",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(start = 16.dp, end = 16.dp, top = 10.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(
                            text = "0.00 placeholder",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                }
                //Volumen
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Red)
                    ) {
                        Text(
                            text = "Volumen type",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Cyan)
                    ) {
                        Text(
                            text = "Type selected placeholder",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                }
                //Højde
                Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Green)
                        ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Red)
                    ) {
                        Text(
                            text = "Bryst højde",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Cyan)
                    ) {
                        Text(
                            text = "0.00 placeholder",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                }

            }
            //Højre side under bredde logo
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = Color.Blue)
            ) {
                //Under
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Yellow)
                    ) {
                        Text(
                            text = "Omfang under brystet",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Blue)
                    ) {
                        Text(
                            text = "0.00 placeholder",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                }
                //Bredde
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Yellow)
                    ) {
                        Text(
                            text = "Brystbredde",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Blue)
                    ) {
                        Text(
                            text = "0.00 placeholder",
                            fontSize = 14.sp,
                            color = Color(0xFF4A4A4A)
                        )
                    }
                }
                //Logo
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color.Green)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Yellow)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logoudentekst),
                            contentDescription = "Logo",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp)
                        )
                    }
                }

            }

        }
        //Tekst "Baseret på dine mål...."
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(Color.Green)
        ) {
            Text(
                text = "Baseret på dine mål har vi fundet et BH-design, der passer til din krop.",
                fontSize = 14.sp,
                color = Color(0xFF4A4A4A)
            )
        }
        // Segment 3: Start forfra og Tilføj til kurv
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            // Navn mail adresse
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = Color.Yellow)
            ) {
                Button(
                    onClick = { navController.navigate("measure-screen") },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(52.dp)
                        .fillMaxWidth(0.65f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF6A00),
                        contentColor = Color.White
                    ),
                    content = {
                        Text(
                            text = "Start forfra",
                            fontSize = 18.sp
                        )
                    }
                )
            }
            // Profil data til højre
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = Color.Green)
            ) {
                Button(
                    onClick = { navController.navigate("cart-screen") },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(52.dp)
                        .fillMaxWidth(0.65f),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF6A00),
                        contentColor = Color.White
                    ),
                    content = {
                        Text(
                            text = "Tilføj til kurv",
                            fontSize = 18.sp
                        )
                    }
                )

            }
        }
        // Segment 4: Result image
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.resultimage),
                contentDescription = "Measurement focus billede",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(6f)
                    .padding(horizontal = 16.dp)
            )

        }
    }
}