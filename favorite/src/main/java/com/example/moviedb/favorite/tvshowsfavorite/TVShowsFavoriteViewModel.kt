package com.example.moviedb.favorite.tvshowsfavorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.domain.usecase.FilmUseCase

class TVShowsFavoriteViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {

    fun getFavoriteTv(): LiveData<List<DataModels>> =
        filmUseCase.getListFavoriteTvShow().asLiveData()
}