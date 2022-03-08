package com.example.platziappclon.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LessonsModuleModel(
    @SerializedName("title")
    val title: String,

    @SerializedName("lessons")
    val lessons: List<LessonsListModel>

): Serializable

