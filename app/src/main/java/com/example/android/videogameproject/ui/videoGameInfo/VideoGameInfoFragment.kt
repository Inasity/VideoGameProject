package com.example.android.videogameproject.ui.videoGameInfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.android.videogameproject.R
import com.example.android.videogameproject.databinding.VideoGameInfoFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoGameInfoFragment : Fragment() {

    private val videoGameInfoFragmentArgs by navArgs<VideoGameInfoFragmentArgs>()

    private val viewModel: VideoGameInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.videoGame = videoGameInfoFragmentArgs.videoGame

        val binding = VideoGameInfoFragmentBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }

}
