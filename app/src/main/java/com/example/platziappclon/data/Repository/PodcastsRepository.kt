package com.example.platziappclon.data.Repository

import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.data.network.Podcasts.PodcastsService
import javax.inject.Inject

class PodcastsRepository @Inject constructor(
    private val api: PodcastsService
) {

    suspend fun getAllPodcasts(): List<PodcastsModel> {
        return api.getPodcasts()
    }

    fun preparePodcast(url: String) {
        api.preparePodcast(url)
    }

}