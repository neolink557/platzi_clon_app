package com.example.platziappclon.data.network.lessons

import com.example.platziappclon.data.model.LessonsModel
import retrofit2.Response
import retrofit2.http.GET

interface LessonsApiClient {
    @GET("Lessons/.json")
    suspend fun getAllAchievements():Response<List<LessonsModel>>
}