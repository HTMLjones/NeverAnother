package com.example.neveranother.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neveranother.classes.GuideStates
import com.example.neveranother.component.VideoPlayer

//Jannik
@Composable
fun GuideScreen(

    selectedGuide: GuideStates,

    value: String,

    onValueChange: (String)->Unit,

    onContinue: () -> Unit,

    onBack: () -> Unit
) {

    val guide =
        selectedGuide.guide


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

            IconButton(
                onClick = onBack
            ) {

                Icon(
                    Icons.Default.ArrowBack,
                    null
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
            videoRes = guide.video
        )


        Spacer(Modifier.height(24.dp))


        /*
        DRAWED GUIDE + TEXT
        */

        Row {

            Image(
                painter =
                    painterResource(
                        guide.illustration
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
                    guide.title,

                    fontSize = 24.sp,

                    fontWeight =
                        FontWeight.SemiBold
                )

                Text(
                    guide.explanation
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

                value = value,

                onValueChange =
                    onValueChange,

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
                onClick =
                    onContinue
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
                guide.info
            )
        }
    }
}
