package com.example.platziappclon.ui.lessons.adapters.syllabus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.data.model.LessonsModuleModel
import com.example.platziappclon.databinding.SyllabusLessonsItemRecyclerBinding

class SyllabusLessonsAdapter(
    private val lessons: List<LessonsModuleModel>
) : RecyclerView.Adapter<SyllabusLessonsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SyllabusLessonsViewHolder {
        val viewBinding =
            SyllabusLessonsItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SyllabusLessonsViewHolder(viewBinding.root, viewBinding)
    }

    override fun getItemCount(): Int = lessons.size

    override fun onBindViewHolder(holderItem: SyllabusLessonsViewHolder, position: Int) =
        holderItem.bindData(lessons[position])

}