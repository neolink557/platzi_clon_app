package com.example.platziappclon.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.R
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.databinding.PathsCardItemLayoutBinding

class HomePathsAdapter(
    private val achievements:List<PathsModel>
    ): RecyclerView.Adapter<HomePathsAdapter.ViewHolder>() {

    private lateinit var mContext: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val viewBinding = PathsCardItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(mContext,viewBinding)
    }

    override fun getItemCount(): Int = achievements.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindData(achievements[position] as PathsModel)

    class ViewHolder(private val context: Context, private val binding: PathsCardItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: PathsModel) {
            binding.textViewPathsCoursesTitle.text = data.title
            binding.progressPathsCoursesPercentage.progress = data.percentage
            binding.textViewPathsCoursesPercentage.text = context.getString(R.string.courses_completed, data.percentage.toString(),"%")
            binding.textViewPathsCoursesQuantity.text = context.getString(R.string.courses_quantity, data.courses.toString())

        }
    }


}