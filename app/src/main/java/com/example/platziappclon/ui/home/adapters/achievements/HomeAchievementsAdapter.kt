package com.example.platziappclon.ui.home.adapters.achievements

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.R
import com.example.platziappclon.core.extensions.changePartTextColor
import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.databinding.AchievementsCardItemLayoutBinding

class HomeAchievementsAdapter(
    private val achievements: List<AchievementsModel>
) : RecyclerView.Adapter<HomeAchievementsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAchievementsViewHolder {
        val viewBinding = AchievementsCardItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeAchievementsViewHolder(viewBinding.root, viewBinding)
    }

    override fun getItemCount(): Int = achievements.size

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: HomeAchievementsViewHolder, position: Int) =
        holder.bindData(achievements[position] as AchievementsModel)

}