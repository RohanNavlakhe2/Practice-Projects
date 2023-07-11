package com.example.pip

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.C.CONTENT_TYPE_HLS
import com.google.android.exoplayer2.C.CONTENT_TYPE_OTHER
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class MainActivity : AppCompatActivity() {

    private val url = "https://content.jwplatform.com/manifests/yp34SRmf.m3u8"

    private lateinit var playerView:StyledPlayerView

    private lateinit var exoPlayer:ExoPlayer
    private var videoCurrentPosition = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerView = findViewById(R.id.player_view)
    }

    override fun onStart() {
        super.onStart()
        initializePlayer()
    }

    override fun onResume() {
        super.onResume()
        playerView.useController = true
    }


    private fun initializePlayer(){
        exoPlayer = ExoPlayer.Builder(this).build()
        playerView.player = exoPlayer
        val dataSourceFactory: DefaultDataSource.Factory = DefaultDataSource.Factory(this)

        when (Util.inferContentType(Uri.parse(url))) {
            CONTENT_TYPE_HLS -> {
                val mediaSource = HlsMediaSource.Factory(dataSourceFactory).createMediaSource(
                    MediaItem.fromUri(Uri.parse(url)))
                exoPlayer.setMediaSource(mediaSource)
                exoPlayer.prepare()
            }

            CONTENT_TYPE_OTHER -> {
                Log.d(TAG,"Content Type Other")
               /* val mediaSource = ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(
                    Uri.parse(url))
                exoPlayer.prepare(mediaSource)*/
            }

            else -> {
                Log.d(TAG,"Content Type Else")
                //This is to catch SmoothStreaming and DASH types which are not supported currently
                /*setResult(Activity.RESULT_CANCELED)
                finish()*/
            }
        }

        exoPlayer.playWhenReady = true

    }

    override fun onPause() {
        videoCurrentPosition = exoPlayer.currentPosition
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        playerView.player = null
        exoPlayer.release()


    }

    companion object {
        const val TAG = "MainActivity"
    }
}