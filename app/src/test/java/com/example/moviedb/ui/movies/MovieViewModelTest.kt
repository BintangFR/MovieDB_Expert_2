package com.example.moviedb.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviedb.core.data.local.entity.DataEntity
import com.example.moviedb.core.vo.Resource
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExcecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: com.example.moviedb.core.data.FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<DataEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<DataEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(filmRepository)
    }

    @Test
    fun testGetMovies() {
        val dummyMovies = Resource.success(pagedList)
        Mockito.`when`(dummyMovies.data?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<DataEntity>>>()
        movies.value = dummyMovies

        Mockito.`when`(filmRepository.getAllMovie()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value?.data
        Mockito.verify<com.example.moviedb.core.data.FilmRepository>(filmRepository).getAllMovie()
        TestCase.assertNotNull(movieEntities)
        TestCase.assertEquals(5, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyMovies)
    }
}