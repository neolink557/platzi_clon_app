package com.example.platziappclon.data.network.lessons

import com.example.platziappclon.data.model.LessonsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LessonsService @Inject constructor(private val api: LessonsApiClient) {

    suspend fun getLessons(): List<LessonsModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPaths()
            response.body() ?: emptyList()
        }
    }
}