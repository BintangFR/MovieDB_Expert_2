package com.example.moviedb.core.domain.repository

import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface IFilmRepository {
    fun getAllMovie(): Flow<Resource<List<DataModels>>>

    fun getAllTVShows(): Flow<Resource<List<DataModels>>>

    fun getMovieWithId(movieId: Int): Flow<Resource<DataModels>>

    fun getTvWithId(tvShowsId: Int): Flow<Resource<DataModels>>

    fun getListFavoriteMovie(): Flow<List<DataModels>>

    fun getListFavoriteTvShow(): Flow<List<DataModels>>

    fun setFavorite(data: DataModels)
}