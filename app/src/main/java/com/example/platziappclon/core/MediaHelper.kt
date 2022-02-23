package com.example.platziappclon.core

import android.media.MediaPlayer
import com.example.platziappclon.core.extensions.isNull

object MediaHelper {
    private var mediaPlayer:MediaPlayer? = null

    fun getMedia():MediaPlayer{
        if (mediaPlayer.isNull()){
            mediaPlayer = MediaPlayer()
        }
        return mediaPlayer as MediaPlayer
    }
}