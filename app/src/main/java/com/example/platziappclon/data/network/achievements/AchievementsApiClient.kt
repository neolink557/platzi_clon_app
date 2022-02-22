package com.example.platziappclon.data.network.achievements

import com.example.platziappclon.data.model.AchievementsModel
import retrofit2.Response
import retrofit2.http.GET

interface AchievementsApiClient {
    @GET("Achievements/.json")
    suspend fun getAllAchievements() : Response<List<AchievementsModel>>
}