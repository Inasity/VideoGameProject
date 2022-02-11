package com.example.android.videogameproject.network.repoImpl

import com.example.android.videogameproject.network.data.VideoGameResponse
import com.example.android.videogameproject.network.endpoint.VideoGameApiEndPoints
import com.example.android.videogameproject.network.networkmodel.ServiceResult
import com.example.android.videogameproject.network.repo.VideoGameRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class VideoGameRepoImpl @Inject constructor(
    private val dispatcher: Dispatchers,
    private val retroObject: VideoGameApiEndPoints
) : VideoGameRepo {
    override suspend fun fetchVideoGames(): ServiceResult<VideoGameResponse?> {
        return withContext(dispatcher.IO) {
            val dataResponse = retroObject.getGames(key = "815e6857ad50494ebaf1297c8289be1b")

            if(dataResponse.isSuccessful)
            {
                ServiceResult.Success(dataResponse.body())
            } else
            {
                ServiceResult.Error(Exception(dataResponse.errorBody().toString()))
            }
        }
    }
}
