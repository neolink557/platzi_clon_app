package com.example.platziappclon.data.model

import com.google.gson.annotations.SerializedName

data class PodcastsModel(
    @SerializedName("title")
    val title: String,

    @SerializedName("image")
    val image:String,

    @SerializedName("url")
    val url:String
)
