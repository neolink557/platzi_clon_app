package com.example.platziappclon.data.network.paths

import com.example.platziappclon.core.RetrofitHelper
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.data.network.lessons.LessonsApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.GET

class PathsService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPaths(): List<PathsModel> {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(PathsApiClient::class.java).getAllPaths()
            response.body() ?: emptyList()
        }
    }
}