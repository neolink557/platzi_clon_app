package com.example.platziappclon.ui.podcasts

import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.domain.podcasts.ManageAudioPodcastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PodcastsViewModel @Inject constructor(
    private val playAudioPodcastsUseCase: ManageAudioPodcastUseCase,
    private val media: MediaPlayer
) : ViewModel() {

    val podcastsModel = MutableLiveData<List<PodcastsModel>>()

    val isLoading = MutableLiveData<Boolean>()

    fun preparePodcast(url:String) {
        isLoading.postValue(true)
        playAudioPodcastsUseCase.preparePodcasts(url)
        media.setOnPreparedListener {
            viewModelScope.launch {
                isLoading.postValue(false)
                playAudioPodcastsUseCase.toggleAudio()
            }
        }
    }

    fun togglePodcast() {
        viewModelScope.launch {
            playAudioPodcastsUseCase.toggleAudio()
        }
    }
}