package com.example.platziappclon.ui.explore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platziappclon.data.model.CategoriesModel
import com.example.platziappclon.domain.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(private val getCategoriesUseCase: GetCategoriesUseCase) :
    ViewModel() {

    val categories = MutableLiveData<List<CategoriesModel>>()

    fun getAllCategories() {
        viewModelScope.launch {
            categories.postValue(getCategoriesUseCase()!!)
        }
    }
}