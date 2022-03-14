package com.example.platziappclon.data.providers.categories

import com.example.platziappclon.data.model.CategoriesModel
import com.example.platziappclon.data.model.LessonsModuleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoriesService @Inject constructor(private val api: CategoriesProvider) {

    suspend fun getCategories(): List<CategoriesModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getCategories()
            response
        }
    }
}