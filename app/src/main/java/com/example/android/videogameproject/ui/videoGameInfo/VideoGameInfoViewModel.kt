package com.example.android.videogameproject.ui.videoGameInfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.android.videogameproject.network.data.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoGameInfoViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {
    lateinit var videoGame: Results
}
