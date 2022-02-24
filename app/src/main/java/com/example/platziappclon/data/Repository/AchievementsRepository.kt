package com.example.platziappclon.data.Repository

import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.data.network.achievements.AchievementsService
import javax.inject.Inject

class AchievementsRepository @Inject constructor(private val api: AchievementsService) {

    suspend fun getAllAchievements(): List<AchievementsModel> {
        return api.getAchievements()
    }

}