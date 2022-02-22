package com.example.platziappclon.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.databinding.PodcastCardItemLayoutBinding

class HomePodcastsAdapter(
    private val achievements:List<PodcastsModel>
    ): RecyclerView.Adapter<HomePodcastsAdapter.ViewHolder>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val viewBinding = PodcastCardItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(mContext,viewBinding)
    }

    override fun getItemCount(): Int = achievements.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindData(achievements[position] as PodcastsModel)

    class ViewHolder(private val context: Context, private val binding: PodcastCardItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: PodcastsModel) {
            binding.textViewPodcastsTittle.text = data.title
        }
    }


}