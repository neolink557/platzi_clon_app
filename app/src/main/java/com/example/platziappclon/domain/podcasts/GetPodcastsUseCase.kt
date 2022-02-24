package com.example.platziappclon.domain.podcasts

import com.example.platziappclon.data.Repository.PodcastsRepository
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.data.model.PodcastsModel
import javax.inject.Inject

class GetPodcastsUseCase @Inject constructor(private val repository: PodcastsRepository) {

    suspend operator fun invoke(): List<PodcastsModel> = repository.getAllPodcasts()
}