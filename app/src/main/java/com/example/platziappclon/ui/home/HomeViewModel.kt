package com.example.platziappclon.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.domain.GetAchievementsUseCase
import com.example.platziappclon.domain.GetLessonsUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val achievementsModel = MutableLiveData<List<AchievementsModel>>()
    val getAchievementsUseCase = GetAchievementsUseCase()
    val lessonsModel = MutableLiveData<List<LessonsModel>>()
    val getLessonsUseCase = GetLessonsUseCase()

    fun onCreate() {
        getAchievements()
        getLessons()
    }

    fun getAchievements(){
        viewModelScope.launch {
            val result = getAchievementsUseCase()

            if (!result.isNullOrEmpty()){
                achievementsModel.postValue(result!!)
            }
        }
    }

    fun getLessons(){
        viewModelScope.launch {
            val result = getLessonsUseCase()

            if (!result.isNullOrEmpty()){
                lessonsModel.postValue(result!!)
            }
        }
    }

}