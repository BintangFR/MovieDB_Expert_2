package com.example.moviedb.core.di

import com.example.moviedb.core.domain.usecase.FilmInteractor
import com.example.moviedb.core.domain.usecase.FilmUseCase
import com.example.moviedb.ui.details.DetailsViewModel
import com.example.moviedb.ui.movies.MovieViewModel
import com.example.moviedb.ui.tvshows.TVShowsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<FilmUseCase> { FilmInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TVShowsViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}