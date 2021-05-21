package com.example.moviedb.ui.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviedb.core.data.local.entity.DataEntity
import com.example.moviedb.core.utils.DataDummy
import com.example.moviedb.core.vo.Resource
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailsViewModelTest {
    private lateinit var movieViewModel: DetailsViewModel
    private lateinit var tvViewModel: DetailsViewModel
    private val dummyMovies = DataDummy.generateDummyMovie()[0]
    private val moviesId = dummyMovies.id
    private val dummyTv = DataDummy.generateDummyTVShows()[0]
    private val tvId = dummyTv.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: com.example.moviedb.core.data.FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<DataEntity>>


    @Before
    fun setUp() {
        movieViewModel = DetailsViewModel(filmRepository)
        tvViewModel = DetailsViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val moviesId = dummyMovies.id
        val movies = MutableLiveData<Resource<DataEntity>>()
        movies.value = Resource.success(dummyMovies)

        Mockito.`when`(filmRepository.getMovieWithId(moviesId)).thenReturn(movies)

        val movieEntity = Resource.success(movieViewModel.getMovie(moviesId).value)

        TestCase.assertNotNull(movieEntity)
        assertEquals(dummyMovies.id, movieEntity.data?.data?.id)
        assertEquals(dummyMovies.title, movieEntity.data?.data?.title)
        assertEquals(dummyMovies.releaseDate, movieEntity.data?.data?.releaseDate)
        assertEquals(dummyMovies.genre, movieEntity.data?.data?.genre)
        assertEquals(dummyMovies.score, movieEntity.data?.data?.score)
        assertEquals(dummyMovies.overview, movieEntity.data?.data?.overview)
        assertEquals(dummyMovies.poster, movieEntity.data?.data?.poster)

        movieViewModel.getMovie(moviesId).observeForever(observer)

        Mockito.verify(observer).onChanged(Resource.success(dummyMovies))

    }

    @Test
    fun getTVShows() {
        val tvId = dummyTv.id
        val tv = MutableLiveData<Resource<DataEntity>>()
        tv.value = Resource.success(dummyTv)

        Mockito.`when`(filmRepository.getTvWithId(tvId)).thenReturn(tv)

        Resource.success(tvViewModel.getTv(tvId))
        val tvEntity = Resource.success(tvViewModel.getTv(tvId).value)

        TestCase.assertNotNull(tvEntity)
        assertEquals(dummyTv.id, tvEntity.data?.data?.id)
        assertEquals(dummyTv.title, tvEntity.data?.data?.title)
        assertEquals(dummyTv.releaseDate, tvEntity.data?.data?.releaseDate)
        assertEquals(dummyTv.genre, tvEntity.data?.data?.genre)
        assertEquals(dummyTv.score, tvEntity.data?.data?.score)
        assertEquals(dummyTv.overview, tvEntity.data?.data?.overview)
        assertEquals(dummyTv.poster, tvEntity.data?.data?.poster)

        tvViewModel.getTv(tvId).observeForever(observer)
        Mockito.verify(observer).onChanged(Resource.success(dummyTv))
    }

    @Test
    fun setFavoriteMovie() {
        val filmId = dummyMovies.id
        val filmDummy = MutableLiveData<Resource<DataEntity>>()
        filmDummy.value = Resource.success(dummyMovies)

        Mockito.`when`(filmRepository.getMovieWithId(filmId)).thenReturn(filmDummy)
        val film = Resource.success(movieViewModel.getMovie(filmId).value)
        movieViewModel.setFavorite(film.data?.data!!)
        Mockito.verify(filmRepository).setFavorite(film.data!!.data!!)
        verifyNoMoreInteractions(observer)
        TestCase.assertEquals(false, film.data?.data?.favorite)
    }

    @Test
    fun setFavoriteTv() {
        val tvId = dummyTv.id
        val tvDummy = MutableLiveData<Resource<DataEntity>>()
        tvDummy.value = Resource.success(dummyTv)

        Mockito.`when`(filmRepository.getTvWithId(tvId)).thenReturn(tvDummy)
        val tv = Resource.success(tvViewModel.getTv(tvId).value)
        tvViewModel.setFavorite(tv.data?.data!!)
        Mockito.verify(filmRepository).setFavorite(tv.data!!.data!!)
        verifyNoMoreInteractions(observer)
        TestCase.assertEquals(false, tv.data?.data?.favorite)
    }
}