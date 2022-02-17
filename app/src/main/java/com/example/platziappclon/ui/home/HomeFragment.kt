package com.example.platziappclon.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platziappclon.MainActivity
import com.example.platziappclon.R
import com.example.platziappclon.data.AchievementsModel
import com.example.platziappclon.databinding.FragmentHomeBinding
import com.example.platziappclon.ui.home.adapters.HomeAchievementsAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: HomeAchievementsAdapter
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        val achievement = AchievementsModel("You Have Studied 55 Minutes","of your goal of 7 hours","d","f")
        val myList = listOf<AchievementsModel>(achievement,achievement,achievement,achievement)
        adapter = HomeAchievementsAdapter(myList)
       // activity as MainActivity.setActionBarTittle("hi wohe")


        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.apply{
            recyclerViewAchievementsHome.layoutManager = layoutManager
            recyclerViewAchievementsHome.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}