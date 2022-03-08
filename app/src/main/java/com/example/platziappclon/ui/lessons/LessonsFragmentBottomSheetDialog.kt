package com.example.platziappclon.ui.lessons

import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.platziappclon.R
import com.example.platziappclon.databinding.FragmentBottomSheetDialogLessonsBinding
import com.example.platziappclon.ui.lessons.adapters.ViewPagerLessonsBSDAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LessonsFragmentBottomSheetDialog @Inject constructor() : BottomSheetDialogFragment() {

    val args: LessonsFragmentBottomSheetDialogArgs by navArgs()
    private lateinit var behavior: BottomSheetBehavior<*>

    private val binding get() = _binding!!
    private var _binding: FragmentBottomSheetDialogLessonsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetDialogLessonsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog = dialogInterface as BottomSheetDialog
            setupFullHeight(bottomSheetDialog)
            setUpScrolling()
        }

        return dialog
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpVideoPlayer()
        setUpView()
        setUpViewpager()
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.apply {
            imageViewGoBackLessonsBSD.setOnClickListener {
                dismiss()
            }
        }
    }

    private fun setUpViewpager() {
        binding.apply {
            viewPagerLessonsBSD.adapter = ViewPagerLessonsBSDAdapter(
                requireActivity(),
                listOf(
                    SyllabusLessonsFragment(),
                    ResourcesLessonsFragment(),
                    CommunityLessonsFragment()
                )
            )
            TabLayoutMediator(tabLayoutLessonsBSD,viewPagerLessonsBSD){tab,position ->
                when(position){
                    0 -> tab.text = "Syllabus"
                    1 -> tab.text = "Resources"
                    2 -> tab.text = "Community"
                }
            }.attach()
        }
    }

    private fun setUpView() {
        binding.apply {
            textViewTittleLessonsBSD.text = args.lessons.title
            textViewLessonTittleLessonsBSD.text = args.lessons.subtitle
            textViewCoursesTittleLessonsBSD.text = args.lessons.course

        }
    }

    private fun setUpVideoPlayer() {
        binding.apply {
            val iFramePlayerOptions: IFramePlayerOptions = IFramePlayerOptions.Builder()
                .controls(1)
                .build()
            requireActivity().lifecycle.addObserver(videoPlayerLessons)
            videoPlayerLessons.initialize(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    super.onReady(youTubePlayer)
                    youTubePlayer.loadVideo(args.lessons.url, 0f)
                }
            },true,iFramePlayerOptions)
        }
    }

    private fun setUpScrolling() {
        behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }


    private fun setupFullHeight(bottomSheetDialog: BottomSheetDialog) {
        val bottomSheet =
            bottomSheetDialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout
        behavior = BottomSheetBehavior.from(bottomSheet)
        val layoutParams = bottomSheet.layoutParams
        val windowHeight = getWindowHeight()
        if (layoutParams != null) {
            layoutParams.height = windowHeight
        }
        bottomSheet.layoutParams = layoutParams
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun getWindowHeight(): Int {
        // Calculate window height for fullscreen use
        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

}