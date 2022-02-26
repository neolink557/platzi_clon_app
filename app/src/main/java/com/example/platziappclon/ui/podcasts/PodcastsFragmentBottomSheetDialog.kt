package com.example.platziappclon.ui.podcasts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.platziappclon.databinding.PodcastsFragmentBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.app.Activity
import android.util.DisplayMetrics
import com.google.android.material.bottomsheet.BottomSheetBehavior
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.example.platziappclon.R
import com.example.platziappclon.core.extensions.load
import com.example.platziappclon.ui.ActivityController
import javax.inject.Inject
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ClassCastException

@AndroidEntryPoint
class PodcastsFragmentBottomSheetDialog @Inject constructor(): BottomSheetDialogFragment() {

    private val viewModel: PodcastsViewModel by viewModels()

    private var isPaused = true
    private lateinit var behavior: BottomSheetBehavior<*>
    val args:PodcastsFragmentBottomSheetDialogArgs by navArgs()

    private val binding get() = _binding!!
    private var _binding: PodcastsFragmentBottomSheetDialogBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PodcastsFragmentBottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpObservers()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        findNavController().navigate(R.id.action_podcastsFragment2_to_navigation_study)
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

    private fun setUpObservers() {
        viewModel.isLoading.observe(this, { isLoading ->
            if (isLoading) {
                binding.bottomSheetDialogPodcasts.disabled = true
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.bottomSheetDialogPodcasts.disabled = false
                binding.progressBar.visibility = View.GONE
            }
        })
    }


    private fun setUpView() {
        binding.apply {
            collapseImageButton.setOnClickListener {
                dismiss()
            }

            materialPlayButton.setOnClickListener {
                viewModel.togglePodcast()

                isPaused = !isPaused
                if (isPaused){
                    materialPlayButton.icon = ContextCompat.getDrawable(materialPlayButton.context,R.drawable.ic_play)
                }else{
                    materialPlayButton.icon = ContextCompat.getDrawable(materialPlayButton.context,R.drawable.ic_pause)
                }

            }


            roundedImageViewPodcastsItemBSD.load(args.podcast.image)
            textViewPodcastsTittleBTD.text = args.podcast.title
        }
        viewModel.preparePodcast(args.podcast.url)
    }

    private fun setUpScrolling() {
        behavior.setBottomSheetCallback(object : BottomSheetCallback() {
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