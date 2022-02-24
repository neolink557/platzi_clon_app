package com.example.platziappclon.data.Repository

import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.network.lessons.LessonsService
import javax.inject.Inject

class LessonsRepository @Inject constructor(private val api: LessonsService) {

    suspend fun getAllLessons(): List<LessonsModel> {
        return api.getLessons()
    }

}