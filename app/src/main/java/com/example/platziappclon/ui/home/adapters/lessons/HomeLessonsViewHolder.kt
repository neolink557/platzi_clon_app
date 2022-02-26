package com.example.platziappclon.ui.home.adapters.lessons

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.core.extensions.load
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.databinding.LessonsCardItemLayoutBinding

class HomeLessonsViewHolder(view: View, private val binding: LessonsCardItemLayoutBinding) :
    RecyclerView.ViewHolder(view) {

    fun bindData(data: LessonsModel) {
        binding.apply {
            textViewLessonsTittle.text = data.title
            roundedImageViewLessonsItem.load(data.image)
            textViewLessonsSubTittle.text = data.subtitle
        }

    }

}