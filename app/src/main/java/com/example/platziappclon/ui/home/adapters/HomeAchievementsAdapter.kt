package com.example.platziappclon.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.databinding.AchievementsCardItemLayoutBinding

class HomeAchievementsAdapter(
    private val achievements:List<AchievementsModel>
    ): RecyclerView.Adapter<HomeAchievementsAdapter.ViewHolder>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val viewBinding = AchievementsCardItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(mContext,viewBinding)
    }

    override fun getItemCount(): Int = achievements.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindData(achievements[position] as AchievementsModel)

    class ViewHolder(private val context: Context, private val binding: AchievementsCardItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: AchievementsModel) {
            binding.textViewAchievementsItemTittle.text = data.title
            binding.textViewAchievementsItemSubTittle.text = data.subtitle
        }
    }


}