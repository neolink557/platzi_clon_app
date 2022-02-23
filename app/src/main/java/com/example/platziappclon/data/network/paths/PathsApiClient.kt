package com.example.platziappclon.data.network.paths

import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.PathsModel
import retrofit2.Response
import retrofit2.http.GET

interface PathsApiClient {

    @GET("Paths/.json")
    suspend fun getAllPaths(): Response<List<PathsModel>>

}