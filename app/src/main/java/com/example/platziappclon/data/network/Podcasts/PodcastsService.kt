package com.example.platziappclon.data.network.Podcasts

import android.media.MediaPlayer
import com.example.platziappclon.data.model.PodcastsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class PodcastsService @Inject constructor(
    private val api: PodcastsApiClient
) {

    suspend fun getPodcasts(): List<PodcastsModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPodcasts()
            response.body() ?: emptyList()
        }
    }

    /*fun preparePodcast(url: String) {
        if (!mediaPlayer.isPlaying) {
            try {
                mediaPlayer.setDataSource(url)
                mediaPlayer.prepareAsync()

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }*/

}