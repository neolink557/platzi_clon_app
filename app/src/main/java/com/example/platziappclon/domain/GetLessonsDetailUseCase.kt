package com.example.platziappclon.domain

import com.example.platziappclon.data.Repository.LessonsRepository
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.LessonsModuleModel
import javax.inject.Inject

class GetLessonsDetailUseCase @Inject constructor(private val repository: LessonsRepository) {

    suspend operator fun invoke(): List<LessonsModuleModel> = repository.getModules()

}