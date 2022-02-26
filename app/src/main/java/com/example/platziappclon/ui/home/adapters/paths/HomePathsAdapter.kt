package com.example.platziappclon.ui.home.adapters.paths

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.R
import com.example.platziappclon.core.extensions.load
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.databinding.PathsCardItemLayoutBinding

class HomePathsAdapter(
    private val achievements: List<PathsModel>
) : RecyclerView.Adapter<HomePathsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePathsViewHolder {
        val viewBinding =
            PathsCardItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomePathsViewHolder(viewBinding.root, viewBinding)
    }

    override fun getItemCount(): Int = achievements.size

    override fun onBindViewHolder(holder: HomePathsViewHolder, position: Int) =
        holder.bindData(achievements[position])

}