package com.example.platziappclon.ui.podcasts

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.domain.podcasts.ManageAudioPodcastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PodcastsViewModel @Inject constructor(
    private val audioPodcastsUseCase: ManageAudioPodcastUseCase
) : ViewModel() {

    val podcastsModel = MutableLiveData<List<PodcastsModel>>()
    val podcastDuration = MutableLiveData<List<Any>>()
    val podcastActualDuration = MutableLiveData<List<Any>>()

    val isLoading = MutableLiveData<Boolean>()

    fun preparePodcast(context: Context, url: String) {
        isLoading.postValue(true)
        audioPodcastsUseCase.preparePodcasts(context, url)
        isLoading.postValue(false)
        audioPodcastsUseCase.toggleAudio()
        getDuration()
    }

    fun togglePodcast() {
        audioPodcastsUseCase.toggleAudio()
    }

    fun goBack(){
        audioPodcastsUseCase.goBack()
    }

    fun killAudio(){
        audioPodcastsUseCase.killAudio()
    }

    fun goForward(){
        audioPodcastsUseCase.goForward()
    }

    fun setPosition(position: Int) {
        audioPodcastsUseCase.setPosition(position)
    }

    private fun getDuration() {
        podcastDuration.postValue(audioPodcastsUseCase.getDuration())
    }

    fun getActualDuration() {
        podcastActualDuration.postValue(audioPodcastsUseCase.getActualDuration())
    }
}