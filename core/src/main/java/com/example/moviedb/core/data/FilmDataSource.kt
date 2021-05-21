package com.example.moviedb.core.data

import androidx.lifecycle.LiveData
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.vo.Resource

interface FilmDataSource {
    fun getAllMovie(): LiveData<Resource<List<DataModels>>>

    fun getAllTVShows(): LiveData<Resource<List<DataModels>>>

    fun getMovieWithId(movieId: Int): LiveData<Resource<DataModels>>

    fun getTvWithId(tvShowsId: Int): LiveData<Resource<DataModels>>

    fun getListFavoriteMovie(): LiveData<List<DataModels>>

    fun getListFavoriteTvShow(): LiveData<List<DataModels>>

    fun setFavorite(data: DataModels)
}