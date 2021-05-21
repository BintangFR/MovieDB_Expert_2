package com.example.moviedb.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.domain.usecase.FilmUseCase
import com.example.moviedb.core.vo.Resource

class MovieViewModel(private val filmUseCase: FilmUseCase) : ViewModel() {

    fun getMovies(): LiveData<Resource<List<DataModels>>> = filmUseCase.getAllMovie().asLiveData()
}
