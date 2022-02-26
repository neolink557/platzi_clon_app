package com.example.platziappclon.ui.home.adapters.paths

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.R
import com.example.platziappclon.core.extensions.load
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.databinding.PathsCardItemLayoutBinding

class HomePathsViewHolder(view: View, private val binding: PathsCardItemLayoutBinding) :
    RecyclerView.ViewHolder(view) {

    fun bindData(data: PathsModel) {

        binding.apply {
            textViewPathsCoursesTitle.text = data.title
            progressPathsCoursesPercentage.progress = data.percentage
            layoutPathsItemBg.setBackgroundColor(Color.parseColor(data.color))
            imageViewPathsCourses.load(data.image)
            textViewPathsCoursesPercentage.text = textViewPathsCoursesPercentage.context.getString(
                R.string.courses_completed,
                data.percentage.toString(),
                "%"
            )
            textViewPathsCoursesQuantity.text = textViewPathsCoursesQuantity.context.getString(
                R.string.courses_quantity,
                data.courses.toString()
            )
        }

    }

}