package com.example.platziappclon.ui.lessons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.data.model.LessonsModuleModel
import com.example.platziappclon.domain.GetLessonsDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LessonsSyllabusFragmentViewModel @Inject constructor(
    private val getLessonsUseCase: GetLessonsDetailUseCase,
) : ViewModel() {

    val lessonsDetailModel = MutableLiveData<List<LessonsModuleModel>>()

    fun getLessonsDetail(){
        viewModelScope.launch {
            val result = getLessonsUseCase()

            if (!result.isNullOrEmpty()){
               lessonsDetailModel.postValue(result)
            }
        }
    }

}