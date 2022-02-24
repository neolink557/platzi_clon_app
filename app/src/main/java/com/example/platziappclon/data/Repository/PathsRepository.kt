package com.example.platziappclon.data.Repository

import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.data.network.paths.PathsService
import javax.inject.Inject

class PathsRepository @Inject constructor(private val api: PathsService) {

    suspend fun getAllPaths(): List<PathsModel> {
        return api.getPaths()
    }

}