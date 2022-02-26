package com.example.platziappclon.ui.home

import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.domain.*
import com.example.platziappclon.domain.podcasts.GetPodcastsUseCase
import com.example.platziappclon.domain.podcasts.ManageAudioPodcastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAchievementsUseCase:GetAchievementsUseCase,
    private val getLessonsUseCase:GetLessonsUseCase,
    private val getPathsUseCase:GetPathsUseCase,
    private val getPodcastsUseCase:GetPodcastsUseCase
): ViewModel() {

    val achievementsModel = MutableLiveData<List<AchievementsModel>>()

    val lessonsModel = MutableLiveData<List<LessonsModel>>()

    val pathsModel = MutableLiveData<List<PathsModel>>()

    val podcastsModel = MutableLiveData<List<PodcastsModel>>()

    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        getAchievements()
        getLessons()
        getPaths()
        getPodcasts()
    }

    private fun getLessons(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getLessonsUseCase()

            if (!result.isNullOrEmpty()){
                lessonsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun getPaths(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPathsUseCase()

            if (!result.isNullOrEmpty()){
                pathsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun getPodcasts(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPodcastsUseCase()

            if (!result.isNullOrEmpty()){
                podcastsModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    private fun getAchievements(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAchievementsUseCase()

            if (!result.isNullOrEmpty()){
                achievementsModel.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

}