package com.example.platziappclon.domain

import com.example.platziappclon.data.Repository.PathsRepository
import com.example.platziappclon.data.model.PathsModel

class GetPathsUseCase {

    private val repository = PathsRepository()

    suspend operator fun invoke(): List<PathsModel> = repository.getAllPaths()
}