package com.example.platziappclon.data.network.paths

import com.example.platziappclon.data.model.PathsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PathsService @Inject constructor(private val api: PathsApiClient) {

    suspend fun getPaths(): List<PathsModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPaths()
            response.body() ?: emptyList()
        }
    }
}