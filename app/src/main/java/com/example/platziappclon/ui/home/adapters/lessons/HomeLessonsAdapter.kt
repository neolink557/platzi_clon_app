package com.example.platziappclon.ui.home.adapters.lessons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.core.extensions.load
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.databinding.LessonsCardItemLayoutBinding

class HomeLessonsAdapter(
    private val achievements: List<LessonsModel>
) : RecyclerView.Adapter<HomeLessonsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeLessonsViewHolder {
        val viewBinding =
            LessonsCardItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeLessonsViewHolder(viewBinding.root, viewBinding)
    }

    override fun getItemCount(): Int = achievements.size

    override fun onBindViewHolder(holder: HomeLessonsViewHolder, position: Int) =
        holder.bindData(achievements[position])

}