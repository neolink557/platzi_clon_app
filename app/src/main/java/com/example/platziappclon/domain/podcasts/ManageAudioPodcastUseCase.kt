package com.example.platziappclon.domain.podcasts

import android.media.AudioManager
import android.media.MediaPlayer
import com.example.platziappclon.data.Repository.PodcastsRepository
import com.example.platziappclon.data.model.PodcastsModel
import java.io.IOException

class ManageAudioPodcastUseCase {

    private val repository = PodcastsRepository()


      fun preparePodcasts(url:String) = repository.preparePodcast(url)
      suspend fun toggleAudio() = repository.togglePodcast()
}

