package com.example.platziappclon.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platziappclon.core.MediaHelper
import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.domain.*
import com.example.platziappclon.domain.podcasts.GetPodcastsUseCase
import com.example.platziappclon.domain.podcasts.ManageAudioPodcastUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val achievementsModel = MutableLiveData<List<AchievementsModel>>()
    val getAchievementsUseCase = GetAchievementsUseCase()
    val lessonsModel = MutableLiveData<List<LessonsModel>>()
    val getLessonsUseCase = GetLessonsUseCase()
    val pathsModel = MutableLiveData<List<PathsModel>>()
    val getPathsUseCase = GetPathsUseCase()
    val podcastsModel = MutableLiveData<List<PodcastsModel>>()
    val playAudioPodcastsUseCase = ManageAudioPodcastUseCase()
    val getPodcastsUseCase = GetPodcastsUseCase()
    val media = MediaHelper.getMedia()


    fun onCreate() {
        getAchievements()
        getLessons()
        getPaths()
        getPodcasts()
    }

    fun preparePodcast(){
        playAudioPodcastsUseCase.preparePodcasts("https://firebasestorage.googleapis.com/v0/b/platziclonrepo.appspot.com/o/los-verdaderos-retos-de-un-fundador-de-startup-christian-van-der-henst.mp3?alt=media&token=4c9679ac-614b-4bbf-9191-c4a351244e31")
        media.setOnPreparedListener {
            viewModelScope.launch {
                playAudioPodcastsUseCase.toggleAudio()
            }
        }
    }

    fun togglePodcast(){
        viewModelScope.launch {
            playAudioPodcastsUseCase.toggleAudio()
        }
    }

    private fun getAchievements(){
        viewModelScope.launch {
            val result = getAchievementsUseCase()

            if (!result.isNullOrEmpty()){
                achievementsModel.postValue(result)
            }
        }
    }

    private fun getLessons(){
        viewModelScope.launch {
            val result = getLessonsUseCase()

            if (!result.isNullOrEmpty()){
                lessonsModel.postValue(result)
            }
        }
    }

    private fun getPaths(){
        viewModelScope.launch {
            val result = getPathsUseCase()

            if (!result.isNullOrEmpty()){
                pathsModel.postValue(result)
            }
        }
    }

    private fun getPodcasts(){
        viewModelScope.launch {
            val result = getPodcastsUseCase()

            if (!result.isNullOrEmpty()){
                podcastsModel.postValue(result)
            }
        }
    }

}