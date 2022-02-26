package com.example.platziappclon.ui.home.adapters.podcasts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.core.extensions.load
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.databinding.PodcastCardItemLayoutBinding

class HomePodcastsViewHolder(view: View, private val binding: PodcastCardItemLayoutBinding) :
    RecyclerView.ViewHolder(view) {

    fun bindData(podcast: PodcastsModel,onClickListener:(PodcastsModel) -> Unit) {

        binding.apply {
            binding.roundedImageViewPodcastsItem.load(podcast.image)
            binding.textViewPodcastsTittle.text = podcast.title
        }

        itemView.setOnClickListener {
            onClickListener(podcast)
        }
    }

}