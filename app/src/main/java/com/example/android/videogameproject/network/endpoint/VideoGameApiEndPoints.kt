package com.example.android.videogameproject.network.endpoint

import com.example.android.videogameproject.network.data.VideoGameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoGameApiEndPoints {
    @GET("/api/games")
    suspend fun getGames(
        @Query("key") key: String
    ): Response<VideoGameResponse>
}
