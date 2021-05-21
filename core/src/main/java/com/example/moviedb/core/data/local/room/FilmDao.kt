package com.example.moviedb.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.moviedb.core.data.local.entity.DataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @androidx.room.Query("SELECT * FROM tb_data WHERE type = 'MOVIE'")
    fun getListMovie(): Flow<List<DataEntity>>

    @androidx.room.Query("SELECT * FROM tb_data WHERE type = 'TVSHOWS'")
    fun getListTvShow(): Flow<List<DataEntity>>

    @androidx.room.Query("SELECT * FROM tb_data WHERE type = 'MOVIE' AND favorite = 1")
    fun getListFavoriteMovie(): Flow<List<DataEntity>>

    @androidx.room.Query("SELECT * FROM tb_data WHERE type = 'TVSHOWS' AND favorite = 1")
    fun getListFavoriteTvShow(): Flow<List<DataEntity>>

    @androidx.room.Query("SELECT * FROM tb_data WHERE id = :id AND type = 'MOVIE'")
    fun getDetailMovieById(id: Int): Flow<DataEntity>

    @androidx.room.Query("SELECT * FROM tb_data WHERE id = :id AND type = 'TVSHOWS'")
    fun getDetailTvShowById(id: Int): Flow<DataEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = DataEntity::class)
    suspend fun insertData(data: List<DataEntity>)

    @Update(entity = DataEntity::class)
    fun updateData(data: DataEntity)


}