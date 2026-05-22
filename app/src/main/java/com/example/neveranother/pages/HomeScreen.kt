package com.example.neveranother.pages



import android.R.attr.repeatMode
import android.annotation.SuppressLint
import android.graphics.Paint
import com.example.neveranother.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.net.Uri
import android.os.Looper.prepare
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import androidx.media3.common.C
import androidx.media3.common.util.UnstableApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val videoUri = //Mangler video i \res\raw\homescreenvideo.. derfor har jeg lagt anden video ind som placeholder til videoen er med i git
                //Uri.parse("android.resource://${context.packageName}/${R.raw.neveranother_homescreenvideoforbedret}")
                Uri.parse("android.resource://${context.packageName}/${R.raw.homescreenvideo}")

            val mediaItem = MediaItem.fromUri(videoUri)
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
            repeatMode = Player.REPEAT_MODE_ONE
            volume = 0f
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Scaffold(
        bottomBar = {}
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // NeverAnother logo, på toppen af skærmen.
            Image(
                painter = painterResource(id = R.drawable.neveranotherlogo),
                contentDescription = "Never Another logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Til videoen fik jeg lidt hjælp, af AI pga. videoen ikke måtte være en res drawable,
            // men en res raw, hvilket skulle gøres lidt anderledes især til kode delen.
            // Her bruges der ikke image(), painter = painterResource()
            Card(
                modifier = Modifier
                .fillMaxWidth()
                .height(420.dp)
                .border(2.dp,Color(0xFFFF6A00), RoundedCornerShape(12.dp))

            ) {
                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp)
                )  {
                    AndroidView(
                        factory = {
                            PlayerView(it).apply {
                                player = exoPlayer
                                useController = false
                                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                                setShowBuffering(PlayerView.SHOW_BUFFERING_NEVER)
                                setShutterBackgroundColor(android.graphics.Color.TRANSPARENT)
                                setKeepContentOnPlayerReset(true)
                            }
                        },
                        modifier = Modifier
                            .fillMaxSize()
                    )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Den rigtige video er ikke pushet, så har lige lagt guide video ind som placeholder så vi kan køre appen" +
                                "Skabt til dig. Ikke til standardmål.",
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Mål\nSkab\nDigitalt",
                        color = Color.White,
                        fontSize = 22.sp
                    )
                }
                }
            }
            Spacer(modifier = Modifier.height(100.dp))

            Button(
                onClick = { navController.navigate("measure-screen") }, //Lagt navigation ind på knappen
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(52.dp)
                    .fillMaxWidth(0.65f),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6A00),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Skab din BH",
                    fontSize = 18.sp
                )
            }
        }
    }
}

