package com.example.platziappclon.data.Repository

import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.LessonsModuleModel
import com.example.platziappclon.data.network.lessons.LessonsService
import com.example.platziappclon.data.providers.lessonsdetail.LessonsDetailService
import javax.inject.Inject

class LessonsRepository @Inject constructor(private val api: LessonsService,private val apiDetail: LessonsDetailService) {

    suspend fun getAllLessons(): List<LessonsModel> {
        return api.getLessons()
    }

    suspend fun getModules(): List<LessonsModuleModel> {
        return apiDetail.getLessons()
    }
}
