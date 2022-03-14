package com.example.platziappclon.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platziappclon.data.model.CategoriesModel
import com.example.platziappclon.databinding.FragmentExploreBinding
import com.example.platziappclon.ui.explore.adapters.ExploreCategoriesAdapter
import com.example.platziappclon.ui.home.adapters.podcasts.HomePodcastsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ExploreFragment : Fragment() {

    private val viewModel: ExploreViewModel by viewModels()
    private lateinit var adapter: ExploreCategoriesAdapter


    private val binding get() = _binding!!
    private var _binding: FragmentExploreBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllCategories()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.categories.observe(this, Observer { categories ->
            setUpRecycler(categories)
        })
    }

    private fun setUpRecycler(categories: List<CategoriesModel>) {
        adapter = ExploreCategoriesAdapter(categories)

        val layoutManager = GridLayoutManager(requireContext(),2)

        binding.apply {
            recyclerExploreCategories.layoutManager = layoutManager
            recyclerExploreCategories.adapter = adapter
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}