package com.example.platziappclon.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        homeViewModel.onCreate()

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.homeFAB.shrink()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpListeners()
    }


    private fun setUpListeners() {
        binding.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                homeScrollView.setOnScrollChangeListener { _, _, i2, _, _ ->
                    if (500 < i2) {
                        homeFAB.extend()
                    } else {
                        homeFAB.shrink()
                    }

                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setUpObservers() {
        homeViewModel.achievementsModel.observe(this, { achievementsList ->
            setUpAchievementsAdapter(achievementsList)
        })

        homeViewModel.lessonsModel.observe(this, { lessonsList ->
            setUpLessonsAdapter(lessonsList)
        })

        homeViewModel.pathsModel.observe(this, { pathsList ->
            setUpPathsAdapter(pathsList)
            setUpInterestsAdapter(pathsList)
        })

        homeViewModel.podcastsModel.observe(this, { podcastsList ->
            setUpPodcastsAdapter(podcastsList)
        })

        //TODO find the way to change the tittle of actionBar

    }


    private fun setUpPodcastsAdapter(podcasts: List<PodcastsModel>) {
        adapterPodcasts = HomePodcastsAdapter(podcasts)

        val layoutManager= LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.apply {
            recyclerViewPodcastHome.layoutManager = layoutManager
            recyclerViewPodcastHome.adapter = adapterPodcasts
        }
    }

    private fun setUpAchievementsAdapter(achievements: List<AchievementsModel>) {
        adapterAchievements = HomeAchievementsAdapter(achievements)

        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.apply {
            recyclerViewAchievementsHome.layoutManager = layoutManager
            recyclerViewAchievementsHome.adapter = adapterAchievements
        }

    }

    private fun setUpLessonsAdapter(lessons: List<LessonsModel>) {
        adapterLessons = HomeLessonsAdapter(lessons)

        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.apply {
            recyclerViewLessonsHome.layoutManager = layoutManager
            recyclerViewLessonsHome.adapter = adapterLessons

        }

    }

    private fun setUpInterestsAdapter(interests: List<PathsModel>) {
        adapterPaths = HomePathsAdapter(interests)

        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        binding.apply {

            recyclerViewInterestHome.layoutManager = layoutManager
            recyclerViewInterestHome.adapter = adapterPaths
        }

    }

    private fun setUpPathsAdapter(paths: List<PathsModel>) {
        adapterPaths = HomePathsAdapter(paths)

        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )


        binding.apply {
            recyclerViewPathsHome.layoutManager = layoutManager
            recyclerViewPathsHome.adapter = adapterPaths
        }

    }




}