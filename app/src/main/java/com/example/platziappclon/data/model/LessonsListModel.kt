package com.example.platziappclon.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LessonsListModel(
    @SerializedName("title")
    val title: String,

    @SerializedName("duration")
    val duration: String

): Serializable