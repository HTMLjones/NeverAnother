package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.neveranother.classes.viewModel.GuideViewModel
import com.example.neveranother.component.VideoPlayer

//Jannik
@Composable
fun GuideScreen(
    navController: NavController
) {

    val guideViewModel =
        viewModel<GuideViewModel>()


    val guides =
        guideViewModel.guides.take(4)


    val guideValues =
        guideViewModel.measurementValues


    var selectedGuide by remember {

        mutableStateOf(

            guides.find {

                it.measurementId ==
                        GuideViewModel.selectedGuideId

            } ?: guides.first()
        )
    }


    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        /*
        HEADER
        */

        Row(
            verticalAlignment =
                Alignment.CenterVertically
        ) {

            Box(

                modifier =
                    Modifier
                        .size(56.dp)
                        .clickable {

                            navController.popBackStack()
                        },

                contentAlignment =
                    Alignment.Center
            ){
                Icon(
                    imageVector =
                        Icons.Default.ArrowBack,
                    contentDescription =
                        "Back",
                    modifier =
                        Modifier.size(
                            30.dp
                        )
                )
            }

            Text(
                "Video Guide",
                fontSize = 28.sp,
                fontWeight =
                    FontWeight.Bold
            )
        }

        Spacer(Modifier.height(20.dp))

        /*
        VIDEO
        */

        VideoPlayer(
            videoRes = selectedGuide.video
        )
        Spacer(Modifier.height(24.dp))

        /*
        DRAWED GUIDE + TEXT
        */
        Row {
            Image(
                painter =
                    painterResource(
                        selectedGuide.illustration
                    ),
                contentDescription = null,
                modifier =
                    Modifier.size(125.dp)
            )

            Spacer(
                Modifier.width(12.dp)
            )

            Column {
                Text(
                    selectedGuide.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    selectedGuide.explanation
                )
            }
        }

        Divider(
            Modifier.padding(
                vertical = 24.dp
            )
        )
        /*
        INPUT + BUTTON
        */

        Row {
            OutlinedTextField(
                value =
                    guideValues[
                        selectedGuide.measurementId
                    ] ?: "",

                onValueChange = {
                    guideValues[
                        selectedGuide.measurementId
                    ] = it
                },

                suffix = {
                    Text("CM")
                },

                modifier =
                    Modifier.weight(1f)
            )


            Spacer(
                Modifier.width(12.dp)
            )

            Button(
                onClick ={}
            ) {
                Text("Fortsæt")
            }
        }

        Spacer(
            Modifier.height(24.dp)
        )
        /*
        INFO SECTION
        */

        Row {
            Icon(
                Icons.Default.Info,
                null
            )
            Spacer(
                Modifier.width(8.dp)
            )
            Text(
                selectedGuide.info
            )
        }
    }
}
