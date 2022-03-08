package com.example.platziappclon.ui.lessons.adapters.syllabus

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.core.extensions.load
import com.example.platziappclon.data.model.LessonsListModel
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.LessonsModuleModel
import com.example.platziappclon.databinding.LessonsCardItemLayoutBinding
import com.example.platziappclon.databinding.SyllabusLessonsItemBinding
import com.example.platziappclon.databinding.SyllabusLessonsItemRecyclerBinding

class SyllabusLessonsItemViewHolder(view: View, private val binding: SyllabusLessonsItemBinding) :
    RecyclerView.ViewHolder(view) {

    fun bindData(data: LessonsListModel) {
        binding.apply {
            textViewLessonsItem.text = data.title
            textViewTimeSyllabusLessonsItem.text = data.duration
        }
    }

}