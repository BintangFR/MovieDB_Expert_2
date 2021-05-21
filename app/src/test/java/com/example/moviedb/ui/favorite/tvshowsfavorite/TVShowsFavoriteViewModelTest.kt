package com.example.moviedb.ui.favorite.tvshowsfavorite

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
class FavoriteTvViewModelTest {

    private lateinit var viewModel: com.example.moviedb.favorite.tvshowsfavorite.TVShowsFavoriteViewModel

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
            com.example.moviedb.favorite.tvshowsfavorite.TVShowsFavoriteViewModel(filmRepository)
    }

    @Test
    fun favoriteTv() {
        val dummyTv = pagedList
        Mockito.`when`(dummyTv.size).thenReturn(5)
        val tv = MutableLiveData<PagedList<DataEntity>>()
        tv.value = dummyTv

        Mockito.`when`(filmRepository.getListFavoriteTvShow()).thenReturn(tv)
        val tvEntities = viewModel.getFavoriteTv().value
        Mockito.verify<com.example.moviedb.core.data.FilmRepository>(filmRepository)
            .getListFavoriteTvShow()
        Assert.assertNotNull(tvEntities)
        TestCase.assertEquals(5, tvEntities?.size)

        viewModel.getFavoriteTv().observeForever(observer)
        Mockito.verify(observer).onChanged(tvEntities)
    }

}