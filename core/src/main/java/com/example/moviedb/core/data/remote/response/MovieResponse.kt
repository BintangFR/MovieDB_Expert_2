package com.example.moviedb.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @field:SerializedName("results") val result: List<MovieList>? = null
)

data class MovieList(
    @field:SerializedName("id") var id: Int? = 0,
    @field:SerializedName("title") var title: String? = null,
    @field:SerializedName("vote_average") var score: Double? = 0.0,
    @field:SerializedName("release_date") var releaseDate: String? = null,
    @field:SerializedName("poster_path") var moviePoster: String? = null
)

data class MovieDetail(
    @field:SerializedName("id") var id: Int? = 0,
    @field:SerializedName("title") var title: String? = null,
    @field:SerializedName("vote_average") var score: Double? = 0.0,
    @field:SerializedName("overview") var overview: String? = null,
    @field:SerializedName("release_date") var releaseDate: String? = null,
    @field:SerializedName("poster_path") var moviePoster: String? = null,
    @field:SerializedName("genres") var genres: ArrayList<Genre>,
)