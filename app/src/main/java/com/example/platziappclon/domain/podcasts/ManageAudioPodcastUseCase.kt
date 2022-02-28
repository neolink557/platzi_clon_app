package com.example.platziappclon.domain.podcasts

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import com.example.platziappclon.data.Repository.PodcastsRepository
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ManageAudioPodcastUseCase @Inject constructor(
    private var mediaPlayer: MediaPlayer,
    private val repository: PodcastsRepository
) {

    fun preparePodcasts(context: Context, url: String) {
        //firebase couta exceeded ಥ_ಥ
        val filename = repository.preparePodcast(context, url)
        try {
            mediaPlayer.setDataSource(context, Uri.parse(filename))
        } catch (e: Exception) {
        }
        try {
            mediaPlayer.prepare()
        } catch (e: Exception) {
        }
    }

    fun toggleAudio() {
        try {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()

            } else {
                mediaPlayer.pause()
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun goBack(time: Int = 5000) {
        mediaPlayer.seekTo(mediaPlayer.currentPosition - time)
    }

    fun goForward(time: Int = 5000) {
        mediaPlayer.seekTo(mediaPlayer.currentPosition + time)
    }

    fun killAudio() {
        mediaPlayer.stop()
        mediaPlayer.reset()
    }

    fun setPosition(position: Int) {
        mediaPlayer.seekTo(position)
    }


    fun getActualDuration(): List<Any> {
        val time = mediaPlayer.currentPosition
        val timeFormatted = convertFormat(time.toLong())
        return listOf<Any>(timeFormatted, time)
    }


    fun getDuration(): List<Any> {
        val time = mediaPlayer.duration
        val timeFormatted = convertFormat(time.toLong())
        return listOf<Any>(timeFormatted, time)
    }

    private fun convertFormat(time: Long): String {
        return String.format(
            "%02d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(time),
            TimeUnit.MILLISECONDS.toSeconds(time),
            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))
        )

    }
}

