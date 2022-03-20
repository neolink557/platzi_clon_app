package com.example.platziappclon.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.platziappclon.R
import com.example.platziappclon.databinding.FragmentExploreBinding
import com.example.platziappclon.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentProfileBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        binding.apply {
            Glide.with(requireContext()).load(getString(R.string.url)).circleCrop().into(imageViewProfile)
            Glide.with(requireContext()).load(getString(R.string.url_badge)).circleCrop().into(imageViewBadge)
        }
    }
}