package com.example.platziappclon.domain

import com.example.platziappclon.data.Repository.LessonsRepository
import com.example.platziappclon.data.model.LessonsModel
import javax.inject.Inject

class GetLessonsUseCase @Inject constructor(private val repository: LessonsRepository) {

    suspend operator fun invoke(): List<LessonsModel> = repository.getAllLessons()

}