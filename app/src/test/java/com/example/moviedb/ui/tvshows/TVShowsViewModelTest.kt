package com.example.moviedb.ui.tvshows

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
class TVShowsViewModelTest {

    private lateinit var viewModel: TVShowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: com.example.moviedb.core.data.FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<DataEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<DataEntity>

    @Before
    fun setUp() {
        viewModel = TVShowsViewModel(filmRepository)
    }

    @Test
    fun testGetTv() {
        val dummyTv = Resource.success(pagedList)
        Mockito.`when`(dummyTv.data?.size).thenReturn(5)
        val tv = MutableLiveData<Resource<PagedList<DataEntity>>>()
        tv.value = dummyTv

        Mockito.`when`(filmRepository.getAllTVShows()).thenReturn(tv)
        val tvEntity = viewModel.getTVShows().value?.data
        Mockito.verify<com.example.moviedb.core.data.FilmRepository>(filmRepository).getAllTVShows()
        TestCase.assertNotNull(tv)
        TestCase.assertEquals(5, tvEntity?.size)

        viewModel.getTVShows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTv)
    }

}