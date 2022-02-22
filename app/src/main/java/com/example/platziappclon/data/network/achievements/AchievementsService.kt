package com.example.platziappclon.data.network.achievements

import com.example.platziappclon.core.RetrofitHelper.getRetrofit
import com.example.platziappclon.data.model.AchievementsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AchievementsService {

    private val retrofit = getRetrofit()

    suspend fun getAchievements(): List<AchievementsModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(AchievementsApiClient::class.java).getAllAchievements()
            response.body() ?: emptyList()
        }
    }
}