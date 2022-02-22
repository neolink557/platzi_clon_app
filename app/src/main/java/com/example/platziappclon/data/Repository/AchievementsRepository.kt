package com.example.platziappclon.data.Repository

import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.data.network.achievements.AchievementsService

class AchievementsRepository {

    private val api = AchievementsService()

    suspend fun getAllAchievements(): List<AchievementsModel> {
        val response: List<AchievementsModel> = api.getAchievements()
        return response
    }

}