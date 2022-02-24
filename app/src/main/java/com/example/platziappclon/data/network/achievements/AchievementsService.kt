package com.example.platziappclon.data.network.achievements

import com.example.platziappclon.data.model.AchievementsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AchievementsService @Inject constructor(private val api: AchievementsApiClient) {

    suspend fun getAchievements(): List<AchievementsModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllAchievements()
            response.body() ?: emptyList()
        }
    }
}