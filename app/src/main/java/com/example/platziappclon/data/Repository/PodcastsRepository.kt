package com.example.platziappclon.data.Repository

import android.content.Context
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.data.network.Podcasts.PodcastsService
import javax.inject.Inject

class PodcastsRepository @Inject constructor(
    private val api: PodcastsService
) {

    suspend fun getAllPodcasts(): List<PodcastsModel> {
        return api.getPodcasts()
    }

    fun preparePodcast(context: Context, url: String): String {
        //api.preparePodcast(url) firebase couta exceeded ಥ_ಥ
        return "android.resource://" + context.packageName.toString() + "/raw/$url"
    }

}