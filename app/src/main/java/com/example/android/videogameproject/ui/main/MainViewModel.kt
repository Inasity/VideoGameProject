package com.example.android.videogameproject.ui.main

import android.app.Application
import androidx.lifecycle.*
import com.example.android.videogameproject.network.data.Results
import com.example.android.videogameproject.network.networkmodel.ServiceResult
import com.example.android.videogameproject.network.repo.VideoGameRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repo: VideoGameRepo,
    private val dispatcher: Dispatchers
) : AndroidViewModel(application){

    private val _videoGameFeed = MutableLiveData<List<Results>?>()

    val videoGameFeed: LiveData<List<Results>?>
        get() = _videoGameFeed

    fun getVideoGames() {
        viewModelScope.launch(dispatcher.IO) {
            when(val response = repo.fetchVideoGames()) {
                is ServiceResult.Success -> {
                    _videoGameFeed.postValue(response.data?.results)
                    Timber.d("Got the video games baby. " + response.data?.results)
                }

                is ServiceResult.Error -> {
                    Timber.d("Error was found when calling the songs :: " + response.exception)
                }

                else -> {
                    Timber.d("Bro.")
                }
            }
        }
    }

}
