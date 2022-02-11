package com.example.android.videogameproject.network.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoGameResponse (
    val results: List<Results>?
        ): Parcelable

@Parcelize
data class Results (
    val id: Int,
    val name: String,
    val released: String,
    val background_image: String,
    val esrb_rating: ESRBRating
        ): Parcelable

@Parcelize
data class ESRBRating (
    val name: String
        ): Parcelable
