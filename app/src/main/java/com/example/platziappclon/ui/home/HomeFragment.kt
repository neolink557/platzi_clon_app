package com.example.platziappclon.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.databinding.FragmentHomeBinding
import com.example.platziappclon.ui.home.adapters.HomeAchievementsAdapter
import com.example.platziappclon.ui.home.adapters.HomeLessonsAdapter
import com.example.platziappclon.ui.home.adapters.HomePathsAdapter
import com.example.platziappclon.ui.home.adapters.HomePodcastsAdapter

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var adapterAchievements: HomeAchievementsAdapter
    private lateinit var adapterLessons: HomeLessonsAdapter
    private lateinit var adapterPaths: HomePathsAdapter
    private lateinit var adapterPodcasts: HomePodcastsAdapter
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel.onCreate()

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        homeViewModel.achievementsModel.observe(this, Observer {achievementsList ->
            setUpAchievementsAdapter(achievementsList)
        })

        homeViewModel.lessonsModel.observe(this, Observer {lessonsList ->
            setUpLessonsAdapter(lessonsList)
        })

        val podcasts = PodcastsModel("¿Qué hemos estado haciendo? ¡Un episodio sobre", "d", "0")
        val paths = PathsModel("English School", "#5sdasd", "d", 50, 9)
        val myListPaths = listOf<PathsModel>(paths, paths, paths)
        val myListPodcasts = listOf<PodcastsModel>(podcasts, podcasts, podcasts, podcasts, podcasts)

        adapterPaths = HomePathsAdapter(myListPaths)
        adapterPodcasts = HomePodcastsAdapter(myListPodcasts)
        //TODO find the way to change the tittle of actionBar


        val layoutManagerPaths = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val layoutManagerPodcasts = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val layoutManagerInterests = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )


        binding.apply {

            recyclerViewPathsHome.layoutManager = layoutManagerPaths
            recyclerViewPathsHome.adapter = adapterPaths
            adapterPaths.notifyDataSetChanged()

            recyclerViewPodcastHome.layoutManager = layoutManagerPodcasts
            recyclerViewPodcastHome.adapter = adapterPodcasts
            adapterPaths.notifyDataSetChanged()

            recyclerViewInterestHome.layoutManager = layoutManagerInterests
            recyclerViewInterestHome.adapter = adapterPaths
        }
    }

    private fun setUpAchievementsAdapter(achievements:List<AchievementsModel>){
        adapterAchievements = HomeAchievementsAdapter(achievements)

        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.apply {
            recyclerViewAchievementsHome.layoutManager = layoutManager
            recyclerViewAchievementsHome.adapter = adapterAchievements
            adapterAchievements.notifyDataSetChanged()

        }

    }

    private fun setUpLessonsAdapter(lessons:List<LessonsModel>){
        adapterLessons = HomeLessonsAdapter(lessons)

        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.apply {
            recyclerViewLessonsHome.layoutManager = layoutManager
            recyclerViewLessonsHome.adapter = adapterLessons
            adapterLessons.notifyDataSetChanged()

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