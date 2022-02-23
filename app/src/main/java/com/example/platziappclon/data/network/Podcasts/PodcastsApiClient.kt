package com.example.platziappclon.data.network.Podcasts

import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.data.model.PodcastsModel
import retrofit2.Response
import retrofit2.http.GET

interface PodcastsApiClient {

    @GET("Podcasts/.json")
    suspend fun getAllPodcasts(): Response<List<PodcastsModel>>

}