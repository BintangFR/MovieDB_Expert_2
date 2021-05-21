package com.example.moviedb.core.data.remote

import android.util.Log
import com.example.moviedb.core.BuildConfig.API_KEY
import com.example.moviedb.core.data.remote.api.ApiService
import com.example.moviedb.core.data.remote.response.*
import com.example.moviedb.core.utils.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    fun getListMovie(): Flow<ApiResponse<List<MovieList>>> {
        EspressoIdlingResource.increment()

        return flow {
            try {
                val resultFilm = apiService.getMovieList(API_KEY)
                val dataArray = resultFilm.result
                if (dataArray != null) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


    fun getListTv(): Flow<ApiResponse<List<TVShowsList>>> {
        EspressoIdlingResource.increment()

        return flow {
            try {
                val resultTv = apiService.getTvList(API_KEY)
                val dataArray = resultTv.result
                if (dataArray != null) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getMovieDetail(id: Int): Flow<ApiResponse<MovieDetail>> {
        EspressoIdlingResource.increment()

        return flow {
            try {
                val detailFilm = apiService.getMovieDetail(id, API_KEY)
                if (detailFilm.id != null) {
                    emit(ApiResponse.Success(detailFilm))
                } else {
                    emit(ApiResponse.Empty)
                }
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun getTvDetail(id: Int): Flow<ApiResponse<TVShowsDetail>> {
        EspressoIdlingResource.increment()
        return flow {
            try {
                val detailTv = apiService.getTvDetail(id, API_KEY)
                if (detailTv.id != null) {
                    emit(ApiResponse.Success(detailTv))
                } else {
                    emit(ApiResponse.Empty)
                }
                EspressoIdlingResource.decrement()
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }


    companion object {
        private val TAG = RemoteDataSource::class.java.simpleName

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(apiService: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(apiService).apply { instance = this }
            }
    }

}