package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.neveranother.R

//Simon
@Composable
fun ResultScreen(
    navController: NavController
) {
    val screenBackground = Color(0xFFF5EFE3)
    val primaryText = Color(0xFF2F3136)
    val secondaryText = Color(0xFF4A4A4A)
    val divider = Color(0xFFD3CBC0)
    val actionOrange = Color(0xFFFF6A00)

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
                modifier = Modifier.size(35.dp)
                    .clickable { navController.popBackStack() }
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
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Omfang over brystet", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = secondaryText)
                    Text(
                        text = "0.00 placeholder",
                        fontSize = 16.sp,
                        color = secondaryText,
                        modifier = Modifier.padding(top = 18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Omfang under brystet", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = secondaryText)
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
            )/*
            Anden row resultater
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Volumen type", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = secondaryText)
                    Text(
                        text = "Type selected placeholder",
                        fontSize = 14.sp,
                        color = secondaryText,
                        modifier = Modifier.padding(top = 18.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Brystbredde", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = secondaryText)
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
            )/*
            Tredje row resultater
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Bryst højde", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = secondaryText)
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
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }/*
        Tekst under logo
         */
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.55f)
                .padding(horizontal = 24.dp)
                .padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Baseret på dine mål har vi fundet et BH-design, der passer til din krop.",
                fontSize = 16.sp,
                color = secondaryText
            )
        }/*
        Knapperne
        */
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            /*
            Havde problemer med Button function, så jeg har brugt box istedet
            AI hjalp med layoutstyling så det lignede de knapper som var der før
             */
            val buttonShape = RoundedCornerShape(8.dp)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)
                    .clip(buttonShape)
                    .border(width = 1.dp, color = actionOrange, shape = buttonShape)
                    .clickable { navController.navigate("measurement-screen") },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Gem mine mål",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    softWrap = false,
                    color = actionOrange
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .weight(2f)
                    .height(56.dp)
                    .clip(buttonShape)
                    .background(actionOrange)
                    .clickable { navController.navigate("cart-screen") },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Tilføj til kurv",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
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