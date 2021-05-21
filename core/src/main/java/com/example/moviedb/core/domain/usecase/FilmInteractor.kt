package com.example.moviedb.core.domain.usecase

import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.domain.repository.IFilmRepository
import com.example.moviedb.core.vo.Resource
import kotlinx.coroutines.flow.Flow

class FilmInteractor(private val iFilmRepository: IFilmRepository) : FilmUseCase {

    override fun getAllMovie(): Flow<Resource<List<DataModels>>> = iFilmRepository.getAllMovie()

    override fun getAllTVShows(): Flow<Resource<List<DataModels>>> =
        iFilmRepository.getAllTVShows()

    override fun getMovieWithId(movieId: Int): Flow<Resource<DataModels>> =
        iFilmRepository.getMovieWithId(movieId)

    override fun getTvWithId(tvShowsId: Int): Flow<Resource<DataModels>> =
        iFilmRepository.getTvWithId(tvShowsId)

    override fun getListFavoriteMovie(): Flow<List<DataModels>> =
        iFilmRepository.getListFavoriteMovie()

    override fun getListFavoriteTvShow(): Flow<List<DataModels>> =
        iFilmRepository.getListFavoriteTvShow()

    override fun setFavorite(data: DataModels) =
        iFilmRepository.setFavorite(data)
}