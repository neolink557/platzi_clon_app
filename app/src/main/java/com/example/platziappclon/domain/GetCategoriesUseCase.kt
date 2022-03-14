package com.example.platziappclon.domain

import com.example.platziappclon.data.Repository.AchievementsRepository
import com.example.platziappclon.data.Repository.CategoriesRepository
import com.example.platziappclon.data.model.CategoriesModel
import com.example.platziappclon.data.model.LessonsModuleModel
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(private val repository: CategoriesRepository){
    suspend operator fun invoke(): List<CategoriesModel> = repository.getAllCategories()
}