package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.neveranother.R

@Composable
fun ResultScreen(
    navController: NavController
) {
    val navController = rememberNavController()
    val screenBackground = Color(0xFFF5EFE3)
    val primaryText = Color(0xFF2F3136)
    val secondaryText = Color(0xFF4A4A4A)
    val divider = Color(0xFFD3CBC0)
    val actionOrange = Color(0xFFFF6A00)

    //Bare fjern background color, jeg brugte det bare til spacing af siden.
    //Laver videre i morgen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(screenBackground)
    ) {
        // Segment 1: Overskrift
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .padding(start = 24.dp, end = 24.dp, top = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "Tilbage knap",
                tint = primaryText,
                modifier = Modifier.size(38.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Her er dine resultater",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = primaryText,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2.6f)
                .padding(horizontal = 24.dp)
        ) {
            /*
            Første row resultater
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Omfang over brystet", fontSize = 14.sp, color = secondaryText)
                    Text(
                        text = "0.00 placeholder",
                        fontSize = 16.sp,
                        color = secondaryText,
                        modifier = Modifier.padding(top = 18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Omfang under brystet", fontSize = 14.sp, color = secondaryText)
                    Text(
                        text = "0.00 placeholder",
                        fontSize = 16.sp,
                        color = secondaryText,
                        modifier = Modifier.padding(top = 18.dp)
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                color = divider,
                thickness = 1.dp
            )
            /*
            Anden row resultater
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Volumen type", fontSize = 14.sp, color = secondaryText)
                    Text(
                        text = "Type selected placeholder",
                        fontSize = 14.sp,
                        color = secondaryText,
                        modifier = Modifier.padding(top = 18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Brystbredde", fontSize = 14.sp, color = secondaryText)
                    Text(
                        text = "0.00 placeholder",
                        fontSize = 16.sp,
                        color = secondaryText,
                        modifier = Modifier.padding(top = 18.dp)
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                color = divider,
                thickness = 1.dp
            )
            /*
            Tredje row resultater
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(text = "Bryst højde", fontSize = 14.sp, color = secondaryText)
                    Text(
                        text = "0.00 placeholder",
                        fontSize = 16.sp,
                        color = secondaryText,
                        modifier = Modifier.padding(top = 18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.CenterEnd,

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logoudentekst),
                        contentDescription = "Logo",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.55f)
                .padding(horizontal = 24.dp)
                .padding(top = 8.dp)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Baseret på dine mål har vi fundet et BH-design, der passer til din krop.",
                fontSize = 14.sp,
                color = secondaryText
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 22.dp)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = { navController.navigate("measure-screen") },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, actionOrange),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = actionOrange
                )
            ) {
                Text(
                    text = "Start forfra",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    softWrap = false
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { navController.navigate("cart-screen") },
                modifier = Modifier
                    .weight(2f)
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = actionOrange,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Tilføj til kurv",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

            }
        }
        // Segment 4: Result image
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2.5f)
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