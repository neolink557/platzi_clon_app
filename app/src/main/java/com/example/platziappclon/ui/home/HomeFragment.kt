package com.example.platziappclon.ui.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platziappclon.R
import com.example.platziappclon.data.model.AchievementsModel
import com.example.platziappclon.data.model.LessonsModel
import com.example.platziappclon.data.model.PathsModel
import com.example.platziappclon.data.model.PodcastsModel
import com.example.platziappclon.databinding.FragmentHomeBinding
import com.example.platziappclon.ui.ActivityController
import com.example.platziappclon.ui.home.adapters.achievements.HomeAchievementsAdapter
import com.example.platziappclon.ui.home.adapters.lessons.HomeLessonsAdapter
import com.example.platziappclon.ui.home.adapters.paths.HomePathsAdapter
import com.example.platziappclon.ui.home.adapters.podcasts.HomePodcastsAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ClassCastException

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var adapterAchievements: HomeAchievementsAdapter
    private lateinit var adapterLessons: HomeLessonsAdapter
    private lateinit var adapterPaths: HomePathsAdapter
    private lateinit var adapterPodcasts: HomePodcastsAdapter
    lateinit var listener: ActivityController


    private val binding get() = _binding!!
    private var _binding: FragmentHomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        homeViewModel.onCreate()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listener.setActionBarName("Hello, Brayan!")
        setUpObservers()
        setUpListeners()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            onBackPressed()
        }
    }


    private fun onBackPressed() {
        listener.setActionBarName("Hello, Brayan!")
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as ActivityController
        } catch (castException: ClassCastException) {
            /** The activity does not implement the listener.  */
        }
    }


    private fun setUpListeners() {
        binding.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                homeScrollView.setOnScrollChangeListener { _, _, i2, _, _ ->
                    if (500 > i2) {
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

        homeViewModel.isLoading.observe(this, { isLoading ->
            if (isLoading) {
                listener.turnToGrayscale(true)
                listener.showLoading(true)
            } else {
                listener.turnToGrayscale(false)
                listener.showLoading(false)
            }

        })

    }


    private fun setUpPodcastsAdapter(podcasts: List<PodcastsModel>) {
        adapterPodcasts = HomePodcastsAdapter(podcasts) { podcast -> onPodcastsItemClicked(podcast) }

        val layoutManager = LinearLayoutManager(
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
        adapterLessons = HomeLessonsAdapter(lessons){ lessons -> onLessonsItemClicked(lessons)}

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

    private fun onLessonsItemClicked(lessons: LessonsModel){
        val action = HomeFragmentDirections.actionNavigationStudyToLessonsFragmentBottomSheetDialog(lessons)
        findNavController().navigate(action)
    }

    private fun onPodcastsItemClicked(podcast: PodcastsModel){
        val action = HomeFragmentDirections.actionNavigationStudyToPodcastsFragment(podcast)
        findNavController().navigate(action)
    }
}