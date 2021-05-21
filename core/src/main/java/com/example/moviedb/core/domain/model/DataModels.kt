package com.example.moviedb.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataModels(

    var id: Int,
    val title: String,
    val genre: String?,
    val overview: String?,
    val score: Double?,
    val releaseDate: String?,
    val poster: String?,
    var favorite: Boolean = false,
    var type: String?

) : Parcelable