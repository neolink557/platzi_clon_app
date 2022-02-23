package com.example.platziappclon.data.Repository

import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.data.network.lessons.LessonsService
import com.example.platziappclon.data.network.paths.PathsService

class PathsRepository {

    private val api = PathsService()

    suspend fun getAllPaths(): List<PathsModel> {
        val response: List<PathsModel> = api.getPaths()
        return response
    }

}