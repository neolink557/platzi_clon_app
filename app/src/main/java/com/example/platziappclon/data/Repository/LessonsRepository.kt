package com.example.platziappclon.data.Repository

import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.network.lessons.LessonsService

class LessonsRepository {

    private val api = LessonsService()

    suspend fun getAllLessons(): List<LessonsModel> {
        val response: List<LessonsModel> = api.getLessons()
        return response
    }

}