package com.example.android.videogameproject.network.repo

import com.example.android.videogameproject.network.data.VideoGameResponse
import com.example.android.videogameproject.network.networkmodel.ServiceResult

interface VideoGameRepo {
    suspend fun fetchVideoGames()
    : ServiceResult<VideoGameResponse?>
}
