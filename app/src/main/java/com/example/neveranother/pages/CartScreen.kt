package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.neveranother.R
import com.example.neveranother.classes.viewModel.MeasureViewModel
import com.example.neveranother.component.HeaderWithReturn

//Kena
@Composable
fun CartScreen(navController: NavController) {
    viewModel<MeasureViewModel>()

    //Bare fjern background color, jeg brugte det bare til spacing af siden.
    //Laver videre i morgen
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Segment 1: Overskrift
        HeaderWithReturn(navController)
        // Segment 2: Kurv indhold visuelt
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f)

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                // Til produktet Bra No. 1 (hvid).
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.braonehvid),
                        contentDescription = "Bra no. 1 (Hvid)",
                        modifier = Modifier
                            .width(80.dp)
                            .height(110.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp)
                    ) {
                        Text(
                            text = "Bra no.1", fontSize = 14.sp, color = Color.Gray
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Hvid", fontSize = 14.sp, color = Color.Black
                        )
                        Text(
                            text = "799,00 kr", fontSize = 14.sp, color = Color.Gray
                        )
                    }

                    Text(
                        text = "1",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 2.dp, end = 8.dp)

                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Til produktet Bra No. 1 (hvid).
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.braonesort),
                        contentDescription = "Bra no. 1 (Sort)",
                        modifier = Modifier
                            .width(80.dp)
                            .height(110.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp)
                    ) {
                        Text(
                            text = "Bra no.1", fontSize = 14.sp, color = Color.Gray
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Sort", fontSize = 14.sp, color = Color.Black
                        )
                        Text(
                            text = "799,00 kr", fontSize = 14.sp, color = Color.Gray
                        )
                    }

                    Text(
                        text = "1",
                        fontSize = 16.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 2.dp, end = 8.dp)

                    )

                }
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = Color(0xFFFF6A00),
            thickness = 1.dp
        )
        // Segment 3: Profil information
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Navn", fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Fulde navn", fontSize = 14.sp, color = Color.Black)
            }
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "E-mail", fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "email@eksempel.dk", fontSize = 14.sp, color = Color.Black)
            }
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Adresse", fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Eksempelvej 12, 2100 København Ø",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            color = Color(0xFFFF6A00),
            thickness = 1.dp
        )
        // Segment 4: Pris og subtotal
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Subtotal", fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "1598,00 DKKR", fontSize = 14.sp, color = Color.Black)
            }
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Levering", fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "39,00 DKKR", fontSize = 14.sp, color = Color.Black)
            }
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Total", fontSize = 14.sp, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "1637,00 DKKR", fontSize = 14.sp, color = Color.Black)
            }
        }
        // Segment 5: Knap til betal
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.5f),

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth(0.65f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6A00), contentColor = Color.White
                )
            ) {
                Text(
                    text = "Betal nu", fontSize = 18.sp
                )
            }
        }
    }
}