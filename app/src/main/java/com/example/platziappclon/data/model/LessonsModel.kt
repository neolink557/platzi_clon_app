package com.example.platziappclon.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LessonsModel(
    @SerializedName("title")
    val title: String,

    @SerializedName("subtitle")
    val subtitle: String,

    @SerializedName("image")
    val image:String,

    @SerializedName("url")
    val url:String,

    @SerializedName("course")
    val course:String

): Serializable
