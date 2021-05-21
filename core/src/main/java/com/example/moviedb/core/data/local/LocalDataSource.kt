package com.example.moviedb.core.data.local

import com.example.moviedb.core.data.local.entity.DataEntity
import com.example.moviedb.core.data.local.room.FilmDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val filmDao: FilmDao) {

    fun getListMovie(): Flow<List<DataEntity>> = filmDao.getListMovie()

    fun getListFavoriteMovie(): Flow<List<DataEntity>> =
        filmDao.getListFavoriteMovie()

    fun getDetailMovie(id: Int): Flow<DataEntity> = filmDao.getDetailMovieById(id)

    fun getListTvShow(): Flow<List<DataEntity>> = filmDao.getListTvShow()

    fun getListFavoriteTvShow(): Flow<List<DataEntity>> =
        filmDao.getListFavoriteTvShow()

    fun getDetailTvShow(id: Int): Flow<DataEntity> = filmDao.getDetailTvShowById(id)

    suspend fun insertData(data: List<DataEntity>) = filmDao.insertData(data)

    fun setFavorite(data: DataEntity) {
        data.favorite = !data.favorite
        filmDao.updateData(data)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

    }


}