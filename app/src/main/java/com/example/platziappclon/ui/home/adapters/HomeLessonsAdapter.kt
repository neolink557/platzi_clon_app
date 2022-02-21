package com.example.platziappclon.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.data.LessonsModel
import com.example.platziappclon.databinding.LessonsCardItemLayoutBinding

class HomeLessonsAdapter(
    private val achievements:List<LessonsModel>
    ): RecyclerView.Adapter<HomeLessonsAdapter.ViewHolder>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val viewBinding = LessonsCardItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(mContext,viewBinding)
    }

    override fun getItemCount(): Int = achievements.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindData(achievements[position] as LessonsModel)

    class ViewHolder(private val context: Context, private val binding: LessonsCardItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: LessonsModel) {
            binding.textViewLessonsTittle.text = data.title
            binding.textViewLessonsSubTittle.text = data.subtitle
        }
    }


}