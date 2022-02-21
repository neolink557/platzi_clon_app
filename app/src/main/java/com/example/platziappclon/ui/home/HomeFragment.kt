package com.example.platziappclon.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platziappclon.data.AchievementsModel
import com.example.platziappclon.data.LessonsModel
import com.example.platziappclon.data.PathsModel
import com.example.platziappclon.data.PodcastsModel
import com.example.platziappclon.databinding.FragmentHomeBinding
import com.example.platziappclon.ui.home.adapters.HomeAchievementsAdapter
import com.example.platziappclon.ui.home.adapters.HomeLessonsAdapter
import com.example.platziappclon.ui.home.adapters.HomePathsAdapter
import com.example.platziappclon.ui.home.adapters.HomePodcastsAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
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
        val podcasts = PodcastsModel("¿Qué hemos estado haciendo? ¡Un episodio sobre","d")
        val lessons = LessonsModel("Simple Present: Verb To Be and otr","Curso de ingles Básico","d")
        val paths = PathsModel("English School","#5sdasd","d",50,9)
        val myList = listOf<AchievementsModel>(achievement,achievement,achievement,achievement)
        val myListLessons = listOf<LessonsModel>(lessons,lessons)
        val myListPaths = listOf<PathsModel>(paths,paths,paths)
        val myListPodcasts = listOf<PodcastsModel>(podcasts,podcasts,podcasts,podcasts,podcasts)
        adapterAchievements = HomeAchievementsAdapter(myList)
        adapterLessons = HomeLessonsAdapter(myListLessons)
        adapterPaths = HomePathsAdapter(myListPaths)
        adapterPodcasts = HomePodcastsAdapter(myListPodcasts)
       //TODO find the way to change the tittle of actionBar

        val layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val layoutManagerLessons = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )

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


        binding.apply{
            recyclerViewAchievementsHome.layoutManager = layoutManager
            recyclerViewAchievementsHome.adapter = adapterAchievements
            adapterAchievements.notifyDataSetChanged()

            recyclerViewLessonsHome.layoutManager = layoutManagerLessons
            recyclerViewLessonsHome.adapter = adapterLessons
            adapterLessons.notifyDataSetChanged()

            recyclerViewPathsHome.layoutManager = layoutManagerPaths
            recyclerViewPathsHome.adapter = adapterPaths
            adapterPaths.notifyDataSetChanged()

            recyclerViewPodcastHome.layoutManager = layoutManagerPodcasts
            recyclerViewPodcastHome.adapter = adapterPodcasts
            adapterPaths.notifyDataSetChanged()

            recyclerViewInterestHome.layoutManager = layoutManagerInterests
            recyclerViewInterestHome.adapter = adapterPaths
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