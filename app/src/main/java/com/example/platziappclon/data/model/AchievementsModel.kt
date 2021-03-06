package com.example.platziappclon.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AchievementsModel(
    @SerializedName("title")
    val title: String,

    @SerializedName("subtitle")
    val subtitle: String,

    @SerializedName("leftIcon")
    val leftIcon:String,

    @SerializedName("rightIcon")
    val rightIcon:String,
): Serializable
