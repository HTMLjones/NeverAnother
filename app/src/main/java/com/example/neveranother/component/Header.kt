package com.example.neveranother.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.navigation.NavController
import com.example.neveranother.R


//Kena & Simon - We struggled & Pair programming.
@Composable
fun HeaderTitleLogo(
    modifier: Modifier = Modifier
){
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painterResource(id = R.drawable.neveranotherlogo),
            contentDescription = "Never Another logo",
            modifier = Modifier.width(220.dp).height(80.dp),
            contentScale = ContentScale.Fit
        )
    }
}
@Composable
fun HeaderWithReturn( navController: NavController){
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(max=70.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

    ) {
        // Box til tilbage knappen.
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .clickable {

                    navController.popBackStack()
                }
                .weight(1f),
                    contentAlignment = Alignment.CenterStart,
        ){
            Icon(
                modifier = Modifier
                    .padding(top = 5.dp),
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "Tilbage knap",
                tint = Color(0xFF1A1A1A)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(10f),
            contentAlignment = Alignment.Center,
        ){
            Image(
                painter = painterResource(id = R.drawable.neveranotherlogo),
                contentDescription = "Never Another logo",
                modifier = Modifier.width(220.dp).height(80.dp),
                contentScale = ContentScale.Fit
            )
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            contentAlignment = Alignment.CenterStart,
        ){}
    }

}