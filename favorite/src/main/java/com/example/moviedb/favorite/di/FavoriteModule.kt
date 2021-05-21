package com.example.moviedb.favorite.di

import com.example.moviedb.favorite.moviefavorite.FavoriteMovieViewModel
import com.example.moviedb.favorite.tvshowsfavorite.TVShowsFavoriteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { TVShowsFavoriteViewModel(get()) }
}