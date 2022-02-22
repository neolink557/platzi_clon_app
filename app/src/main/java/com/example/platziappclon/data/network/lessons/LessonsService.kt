package com.example.platziappclon.data.network.lessons

import com.example.platziappclon.core.RetrofitHelper.getRetrofit
import com.example.platziappclon.data.model.LessonsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LessonsService {
    private val retrofit = getRetrofit()

    suspend fun getLessons(): List<LessonsModel> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(LessonsApiClient::class.java).getAllAchievements()
            response.body() ?: emptyList()
        }
    }
}