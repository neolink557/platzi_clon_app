package com.example.platziappclon.data.Repository

import android.media.AudioManager
import android.media.MediaPlayer
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.data.network.Podcasts.PodcastsService
import java.io.IOException

class PodcastsRepository {

    private val api = PodcastsService()

    suspend fun getAllPodcasts(): List<PodcastsModel>{
        val response: List<PodcastsModel> = api.getPodcasts()
        return response
    }

    fun preparePodcast(url:String){
        api.preparePodcast(url)
    }

    suspend fun togglePodcast(){
        api.togglePodcast()
    }
}