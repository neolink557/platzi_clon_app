package com.example.platziappclon.ui.home.adapters.achievements

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.R
import com.example.platziappclon.core.extensions.changePartTextColor
import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.databinding.AchievementsCardItemLayoutBinding

class HomeAchievementsViewHolder(
    view: View,
    private val binding: AchievementsCardItemLayoutBinding
) : RecyclerView.ViewHolder(view) {

    @RequiresApi(Build.VERSION_CODES.M)
    fun bindData(achievement: AchievementsModel) {
        binding.apply {
            textViewAchievementsItemTittle.text = achievement.title
            textViewAchievementsItemSubTittle.text = achievement.subtitle
            textViewAchievementsItemSubTittle.changePartTextColor(
                "7 hours",
                textViewAchievementsItemSubTittle.context.getColor(R.color.non_straight_blue)
            )
        }
    }
}