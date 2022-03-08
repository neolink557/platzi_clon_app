package com.example.platziappclon.ui.lessons.adapters.syllabus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.data.model.LessonsListModel
import com.example.platziappclon.data.model.LessonsModuleModel
import com.example.platziappclon.databinding.SyllabusLessonsItemBinding
import com.example.platziappclon.databinding.SyllabusLessonsItemRecyclerBinding

class SyllabusLessonsItemAdapter(
    private val lessons: List<LessonsListModel>
) : RecyclerView.Adapter<SyllabusLessonsItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SyllabusLessonsItemViewHolder {
        val viewBinding =
            SyllabusLessonsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SyllabusLessonsItemViewHolder(viewBinding.root, viewBinding)
    }

    override fun getItemCount(): Int = lessons.size

    override fun onBindViewHolder(holderItem: SyllabusLessonsItemViewHolder, position: Int) =
        holderItem.bindData(lessons[position])

}