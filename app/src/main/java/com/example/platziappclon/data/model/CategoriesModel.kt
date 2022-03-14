package com.example.platziappclon.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CategoriesModel(
    @SerializedName("title")
    val title: String,

    @SerializedName("color")
    val color:String,

    @SerializedName("icon")
    val icon:String

): Serializable
