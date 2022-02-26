package com.example.platziappclon.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PathsModel(
    @SerializedName("title")
    val title: String,

    @SerializedName("color")
    val color: String,

    @SerializedName("image")
    val image:String,

    @SerializedName("percentage")
    val percentage:Int,

    @SerializedName("courses")
    val courses:Int
):Serializable
