package com.example.platziappclon.ui.lessons.adapters.syllabus

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.data.model.LessonsModuleModel
import com.example.platziappclon.databinding.SyllabusLessonsItemRecyclerBinding

class SyllabusLessonsViewHolder(
    view: View,
    private val binding: SyllabusLessonsItemRecyclerBinding
) :
    RecyclerView.ViewHolder(view) {

    lateinit var adapter: SyllabusLessonsItemAdapter

    fun bindData(data: LessonsModuleModel) {
        binding.apply {
            textViewTittleLessonsBSDRecycler.text = data.title
            val layoutManager = LinearLayoutManager(
                textViewTittleLessonsBSDRecycler.context,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = SyllabusLessonsItemAdapter(data.lessons)
            recyclerViewBSDLessons.layoutManager = layoutManager
            recyclerViewBSDLessons.adapter = adapter
        }
    }

}