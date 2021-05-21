package com.example.moviedb.favorite.moviefavorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.domain.usecase.FilmUseCase

class FavoriteMovieViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {

    fun getFavoriteMovie(): LiveData<List<DataModels>> =
        filmUseCase.getListFavoriteMovie().asLiveData()
}