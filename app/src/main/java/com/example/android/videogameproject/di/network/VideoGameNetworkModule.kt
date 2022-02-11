package com.example.android.videogameproject.di.network

import com.example.android.videogameproject.network.data.VideoGameResponse
import com.example.android.videogameproject.network.endpoint.VideoGameApiEndPoints
import com.example.android.videogameproject.network.networkmodel.ServiceResult
import com.example.android.videogameproject.network.repo.VideoGameRepo
import com.example.android.videogameproject.network.repoImpl.VideoGameRepoImpl
import com.example.android.videogameproject.network.retrofit.RetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object VideoGameNetworkModule {
    private const val VideoGameBaseUrl = "https://api.rawg.io/"

    @Singleton
    @Provides
    fun provideVideoGameRetrofit(): VideoGameApiEndPoints {
        return RetrofitFactory.retrofitProvider(
            VideoGameApiEndPoints::class.java,
            VideoGameBaseUrl
        )
    }

    @Singleton
    @Provides
    fun provideVideoGameRepo(
        dispatcher: Dispatchers,
        retroObject: VideoGameApiEndPoints
    ): VideoGameRepo {
        return VideoGameRepoImpl(dispatcher, retroObject)
    }
}
