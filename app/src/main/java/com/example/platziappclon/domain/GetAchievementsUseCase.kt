package com.example.platziappclon.domain

import com.example.platziappclon.data.Repository.AchievementsRepository
import com.example.platziappclon.data.model.AchievementsModel
import javax.inject.Inject

class GetAchievementsUseCase @Inject constructor(private val repository: AchievementsRepository) {

    suspend operator fun invoke(): List<AchievementsModel>? = repository.getAllAchievements()

}