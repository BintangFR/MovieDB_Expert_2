package com.example.moviedb.core.data.remote.api

import com.example.moviedb.core.data.remote.response.MovieDetail
import com.example.moviedb.core.data.remote.response.MovieResponse
import com.example.moviedb.core.data.remote.response.TVShowsDetail
import com.example.moviedb.core.data.remote.response.TVShowsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    suspend fun getMovieList(@Query("api_key") api_key: String): MovieResponse

    @GET("tv/on_the_air")
    suspend fun getTvList(@Query("api_key") api_key: String): TVShowsResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") id: Int, @Query("api_key") api_key: String)
            : MovieDetail

    @GET("tv/{tv_id}")
    suspend fun getTvDetail(@Path("tv_id") id: Int, @Query("api_key") api_key: String)
            : TVShowsDetail
}