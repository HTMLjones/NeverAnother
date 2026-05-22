package com.example.neveranother.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

//Jannik
@Composable
fun VideoPlayer(
    videoRes: Int
) {

    val context =
        LocalContext.current


    val exoPlayer =
        remember {

            ExoPlayer.Builder(context)
                .build()
                .apply {

                    val uri =
                        "android.resource://${context.packageName}/$videoRes".toUri()

                    val mediaItem =
                        MediaItem.fromUri(uri)

                    setMediaItem(mediaItem)

                    prepare()

                    playWhenReady = false
                }
        }


    DisposableEffect(Unit) {

        onDispose {

            exoPlayer.release()
        }
    }



    AndroidView(

        modifier =
            Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 2.5f),

        factory = {

            PlayerView(context).apply {

                player =
                    exoPlayer

                useController =
                    true
            }
        }
    )
}