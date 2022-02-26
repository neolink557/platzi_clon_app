package com.example.platziappclon.domain.podcasts

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.lifecycle.viewModelScope
import com.example.platziappclon.data.Repository.PodcastsRepository
import com.example.platziappclon.data.model.PodcastsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class ManageAudioPodcastUseCase @Inject constructor(
    private var mediaPlayer: MediaPlayer,
    private val repository: PodcastsRepository
) {

    fun preparePodcasts(url: String) {
        repository.preparePodcast(url)
    }

    suspend fun toggleAudio() {
        return withContext(Dispatchers.IO) {
            try {
                if (!mediaPlayer.isPlaying) {
                    mediaPlayer.setOnPreparedListener {
                        mediaPlayer.start()
                    }
                } else {
                    mediaPlayer.setOnCompletionListener {
                        mediaPlayer.stop()
                    }
                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}

