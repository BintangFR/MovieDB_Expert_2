package com.example.moviedb.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class TVShowsResponse(
    @field:SerializedName("results") val result: List<TVShowsList>? = null
)

data class TVShowsList(
    @field:SerializedName("id") var id: Int? = 0,
    @field:SerializedName("name") var title: String? = null,
    @field:SerializedName("vote_average") var score: Double? = 0.0,
    @field:SerializedName("first_air_date") var releaseDate: String? = null,
    @field:SerializedName("poster_path") var tvPoster: String? = null
)

data class TVShowsDetail(
    @field:SerializedName("id") var id: Int? = 0,
    @field:SerializedName("name") var title: String? = null,
    @field:SerializedName("vote_average") var score: Double? = 0.0,
    @field:SerializedName("overview") var overview: String? = null,
    @field:SerializedName("first_air_date") var releaseDate: String? = null,
    @field:SerializedName("poster_path") var tvPoster: String? = null,
    @field:SerializedName("genres") var genres: ArrayList<Genre>,
)