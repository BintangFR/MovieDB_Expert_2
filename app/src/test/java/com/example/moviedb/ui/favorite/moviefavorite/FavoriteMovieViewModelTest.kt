package com.example.moviedb.ui.favorite.moviefavorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviedb.core.data.local.entity.DataEntity
import junit.framework.Assert
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteFilmViewModelTest {

    private lateinit var viewModel: com.example.moviedb.favorite.moviefavorite.FavoriteMovieViewModel

    @get:Rule
    var instantTaskExcecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: com.example.moviedb.core.data.FilmRepository

    @Mock
    private lateinit var observer: Observer<PagedList<DataEntity>>

    @Mock
    private lateinit var pagedList: PagedList<DataEntity>

    @Before
    fun setUp() {
        viewModel =
            com.example.moviedb.favorite.moviefavorite.FavoriteMovieViewModel(filmRepository)
    }

    @Test
    fun favoriteFilm() {
        val dummyFilm = pagedList
        Mockito.`when`(dummyFilm.size).thenReturn(5)
        val film = MutableLiveData<PagedList<DataEntity>>()
        film.value = dummyFilm

        Mockito.`when`(filmRepository.getListFavoriteMovie()).thenReturn(film)
        val filmEntities = viewModel.getFavoriteMovie().value
        Mockito.verify<com.example.moviedb.core.data.FilmRepository>(filmRepository)
            .getListFavoriteMovie()
        Assert.assertNotNull(filmEntities)
        TestCase.assertEquals(5, filmEntities?.size)

        viewModel.getFavoriteMovie().observeForever(observer)
        Mockito.verify(observer).onChanged(filmEntities)
    }

}