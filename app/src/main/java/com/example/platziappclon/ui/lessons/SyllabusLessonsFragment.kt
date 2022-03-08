package com.example.platziappclon.ui.lessons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platziappclon.R
import com.example.platziappclon.data.model.LessonsModuleModel
import com.example.platziappclon.databinding.FragmentBottomSheetDialogLessonsBinding
import com.example.platziappclon.databinding.FragmentSyllabusLessonsBinding
import com.example.platziappclon.databinding.SyllabusLessonsItemBinding
import com.example.platziappclon.ui.lessons.adapters.syllabus.SyllabusLessonsAdapter
import com.example.platziappclon.ui.lessons.adapters.syllabus.SyllabusLessonsItemAdapter
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SyllabusLessonsFragment @Inject constructor() : Fragment() {

    private val viewModel: LessonsSyllabusFragmentViewModel by viewModels()

    private val binding get() = _binding!!
    private var _binding: FragmentSyllabusLessonsBinding?= null

    lateinit var adapter:SyllabusLessonsAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSyllabusLessonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLessonsDetail()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.lessonsDetailModel.observe(this, { lessonsDetail ->
            setUpRecycler(lessonsDetail)
        })
    }

    private fun setUpRecycler(lessonsDetail:List<LessonsModuleModel>) {
       binding.apply {
           val layoutManager = LinearLayoutManager(
               requireContext(),
               LinearLayoutManager.VERTICAL,
               false
           )
           adapter = SyllabusLessonsAdapter(lessonsDetail)
           recyclerSyllabusLessons.layoutManager = layoutManager
           recyclerSyllabusLessons.adapter = adapter
       }
    }
}