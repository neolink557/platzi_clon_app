package com.example.platziappclon.ui.podcasts

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.platziappclon.R
import com.example.platziappclon.core.extensions.load
import com.example.platziappclon.databinding.PodcastsFragmentBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class PodcastsFragmentBottomSheetDialog @Inject constructor(): BottomSheetDialogFragment() {

    private val viewModel: PodcastsViewModel by viewModels()

    private var isPaused = false
    private lateinit var behavior: BottomSheetBehavior<*>
    val args: PodcastsFragmentBottomSheetDialogArgs by navArgs()
    lateinit var runnable: Runnable

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
        viewModel.killAudio()
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

        viewModel.podcastDuration.observe(this, { duration ->
            binding.textViewTimerFinal.text = duration[0] as String
            binding.seekBar.max = duration[1] as Int
            initialiseSeekBar()
        })

        viewModel.podcastActualDuration.observe(this, { duration ->
            binding.seekBar.progress = duration[1] as Int
            binding.textViewTimerInit.text = duration[0] as String
        })

    }


    private fun setUpView() {
        binding.apply {

            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(p0: SeekBar?, position: Int, p2: Boolean) {
                    if (p2) {
                        viewModel.setPosition(position)
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }

            })

            materialButtonBack.setOnClickListener {
                viewModel.goBack()
            }

            materialButtonAdvance.setOnClickListener {
                viewModel.goForward()
            }

            collapseImageButton.setOnClickListener {
                viewModel.killAudio()
                dismiss()
            }

            materialPlayButton.setOnClickListener {
                viewModel.togglePodcast()

                isPaused = !isPaused
                if (isPaused) {
                    materialPlayButton.icon =
                        ContextCompat.getDrawable(materialPlayButton.context, R.drawable.ic_play)
                } else {
                    materialPlayButton.icon =
                        ContextCompat.getDrawable(materialPlayButton.context, R.drawable.ic_pause)
                }

            }

            roundedImageViewPodcastsItemBSD.load(args.podcast.image)

            textViewPodcastsTittleBTD.text = args.podcast.title
        }

        viewModel.preparePodcast(requireContext(), args.podcast.url)
    }

    private fun initialiseSeekBar() {
        runnable = Runnable {
            viewModel.getActualDuration()
            Handler(Looper.getMainLooper()).postDelayed(runnable, 1000)
        }

        Handler(Looper.getMainLooper()).postDelayed(runnable, 1000)


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

    private fun convertFormat(time: Long): String {
        return String.format(
            "%02d:%02d",
            TimeUnit.MILLISECONDS.toMinutes(time),
            TimeUnit.MILLISECONDS.toSeconds(time),
            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))
        )
    }
}

