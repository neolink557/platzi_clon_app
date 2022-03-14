package com.example.platziappclon.data.providers.lessonsdetail

import com.example.platziappclon.data.model.LessonsModuleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LessonsDetailService @Inject constructor(private val api: LessonsDetailProvider) {

    suspend fun getLessons(): List<LessonsModuleModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getLessonsDetail()
            response
        }
    }
}