package com.example.platziappclon.data.Repository

import com.example.platziappclon.data.model.CategoriesModel
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.network.lessons.LessonsService
import com.example.platziappclon.data.providers.categories.CategoriesService
import com.example.platziappclon.data.providers.lessonsdetail.LessonsDetailService
import javax.inject.Inject

class CategoriesRepository @Inject constructor(private val api: CategoriesService){

    suspend fun getAllCategories(): List<CategoriesModel> {
        return api.getCategories()
    }
}