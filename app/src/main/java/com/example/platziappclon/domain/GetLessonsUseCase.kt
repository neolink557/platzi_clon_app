package com.example.platziappclon.domain

import com.example.platziappclon.data.Repository.LessonsRepository
import com.example.platziappclon.data.model.LessonsModel

class GetLessonsUseCase {

    private val repository = LessonsRepository()

    suspend operator fun invoke(): List<LessonsModel> = repository.getAllLessons()

}