package com.example.moviedb.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.domain.usecase.FilmUseCase
import com.example.moviedb.core.vo.Resource

class TVShowsViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {

    fun getTVShows(): LiveData<Resource<List<DataModels>>> =
        filmUseCase.getAllTVShows().asLiveData()
}