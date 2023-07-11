package com.example.pip

import android.app.PictureInPictureParams
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Rect
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v4.media.session.MediaSessionCompat
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class ExoPlayerActivity : AppCompatActivity(), Player.Listener {

    private lateinit var exoPlayer: ExoPlayer
    private var playbackPosition: Long = 0

    private val mp4Url = "https://html5demos.com/assets/dizzy.mp4"
    private val dashUrl = "https://storage.googleapis.com/wvmedia/clear/vp9/tears/tears_uhd.mpd"

    //PiP
    private lateinit var mediaSession: MediaSessionCompat
    var isPIPModeeEnabled:Boolean = true //Has the user disabled PIP mode in AppOpps?
    var isInPipMode:Boolean = false


    private val dataSourceFactory: DataSource.Factory by lazy {
        DefaultDataSourceFactory(this, "exoplayer-sample")
    }

    private lateinit var exoPlayerView: StyledPlayerView
    private lateinit var progressBar: ProgressBar
    private lateinit var view:View
    private lateinit var rootView:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exo_player)

        exoPlayerView = findViewById(R.id.exo_player_view)
        progressBar = findViewById(R.id.progrss_bar)
        rootView = findViewById(R.id.root_view)
        view = findViewById(R.id.view)

        //listenLayoutChange()

    }

    override fun onStart() {
        super.onStart()
        initializePlayer()

        //Use Media Session Connector from the EXT library to enable MediaSession Controls in PIP.
        mediaSession = MediaSessionCompat(this, packageName)
        val mediaSessionConnector = MediaSessionConnector(mediaSession)
        mediaSessionConnector.setPlayer(exoPlayer)
        mediaSession.isActive = true
    }

    private fun initializePlayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        preparePlayer(mp4Url)
        exoPlayerView.player = exoPlayer
        exoPlayer.seekTo(playbackPosition)
        exoPlayer.addListener(this)
    }


    private fun preparePlayer(url: String) {
        val uri = Uri.parse(url)
        val mediaSource = buildMediaSource(uri, "")
        exoPlayer.setMediaSource(mediaSource)
        exoPlayer.prepare()

    }

    private fun buildMediaSource(uri: Uri, type: String): MediaSource {

        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(uri))

        /* return if (type == "dash") {
             DashMediaSource.Factory(dataSourceFactory)
                 .createMediaSource(MediaItem.fromUri(uri))
         } else {
             ProgressiveMediaSource.Factory(dataSourceFactory)
                 .createMediaSource(MediaItem.fromUri(uri))
         }*/
    }

    override fun onPlayerError(error: PlaybackException) {
        Log.d("Streaming", "Error : ${error.message}")
    }

    override fun onPlaybackStateChanged(playbackState: Int) {
        if (playbackState == Player.STATE_BUFFERING)
            progressBar.visibility = View.VISIBLE
        else
            progressBar.visibility = View.INVISIBLE
    }

    override fun onPause() {
        playbackPosition = exoPlayer.currentPosition
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
        mediaSession.release()
        //PIPmode activity.finish() does not remove the activity from the recents stack.
        //Only finishAndRemoveTask does this.
        /*if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            && packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
            finishAndRemoveTask()
        }*/
    }

    private fun releasePlayer() {
        playbackPosition = exoPlayer.currentPosition
        exoPlayer.release()
    }

    //Called when the user touches the Home or Recents button to leave the app.
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        enterPIPMode()
    }

    @Suppress("DEPRECATION")
    fun enterPIPMode(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
            && packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) {
            playbackPosition = exoPlayer.currentPosition
            exoPlayerView.useController = false //false
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val params = PictureInPictureParams.Builder()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    params.setAutoEnterEnabled(true)
                }
                this.enterPictureInPictureMode(params.build())
            } else {
                this.enterPictureInPictureMode()
            }
            /* We need to check this because the system permission check is publically hidden for integers for non-manufacturer-built apps
               https://github.com/aosp-mirror/platform_frameworks_base/blob/studio-3.1.2/core/java/android/app/AppOpsManager.java#L1640

               ********* If we didn't have that problem *********
                val appOpsManager = getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
                if(appOpsManager.checkOpNoThrow(AppOpManager.OP_PICTURE_IN_PICTURE, packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA).uid, packageName) == AppOpsManager.MODE_ALLOWED)

                30MS window in even a restricted memory device (756mb+) is more than enough time to check, but also not have the system complain about holding an action hostage.
             */
            Handler().postDelayed({checkPIPPermission()}, 30)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun checkPIPPermission(){
        isPIPModeeEnabled = isInPictureInPictureMode
        if(!isInPictureInPictureMode){
            onBackPressed()
        }
    }

    override fun onBackPressed(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
            && packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)
            && isPIPModeeEnabled) {
            enterPIPMode()
        } else {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        if(playbackPosition > 0L && !isInPipMode){
            exoPlayer.seekTo(playbackPosition)
        }
        //Makes sure that the media controls pop up on resuming and when going between PIP and non-PIP states.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && !isInPictureInPictureMode)
           exoPlayerView.useController = true
    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration
    ) {
        playbackPosition = exoPlayer.currentPosition
        isInPipMode = !isInPictureInPictureMode

        if(isInPictureInPictureMode){
            view.visibility = View.GONE
            val lp = exoPlayerView.layoutParams
            lp.height = ViewGroup.LayoutParams.MATCH_PARENT
        } else{
            val lp = exoPlayerView.layoutParams
            lp.height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,400f,resources.displayMetrics)
                .toInt()
            view.visibility = View.VISIBLE
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        }else
            super.onPictureInPictureModeChanged(isInPictureInPictureMode)
    }

    private fun listenLayoutChange(){
       exoPlayerView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
           if (left != oldLeft || right != oldRight || top != oldTop
               || bottom != oldBottom) {
               // The playerView's bounds changed, update the source hint rect to
               // reflect its new bounds.
               val sourceRectHint = Rect()
               exoPlayerView.getGlobalVisibleRect(sourceRectHint)
               if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                   setPictureInPictureParams(
                       PictureInPictureParams.Builder()
                           .setSourceRectHint(sourceRectHint)
                           .build()
                   )
               }
           }
       }
    }

}