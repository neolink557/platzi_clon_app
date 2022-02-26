package com.example.platziappclon.ui.home.adapters.podcasts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.core.extensions.load
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.databinding.PodcastCardItemLayoutBinding
import com.example.platziappclon.ui.home.adapters.achievements.HomeAchievementsViewHolder

class HomePodcastsAdapter(
    private val achievements: List<PodcastsModel>,
    private val onClickListener:(PodcastsModel)-> Unit
) : RecyclerView.Adapter<HomePodcastsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePodcastsViewHolder {
        val viewBinding =
            PodcastCardItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomePodcastsViewHolder(viewBinding.root, viewBinding)
    }

    override fun getItemCount(): Int = achievements.size

    override fun onBindViewHolder(holder: HomePodcastsViewHolder, position: Int) =
        holder.bindData(achievements[position], onClickListener)

}