package com.example.moviedb.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.domain.usecase.FilmUseCase
import com.example.moviedb.core.vo.Resource

class DetailsViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {

    fun getMovie(movieId: Int): LiveData<Resource<DataModels>> =
        filmUseCase.getMovieWithId(movieId).asLiveData()

    fun getTv(tvId: Int): LiveData<Resource<DataModels>> =
        filmUseCase.getTvWithId(tvId).asLiveData()

    fun setFavorite(data: DataModels) {
        val newState = !data.favorite
        filmUseCase.setFavorite(data)
    }
}
