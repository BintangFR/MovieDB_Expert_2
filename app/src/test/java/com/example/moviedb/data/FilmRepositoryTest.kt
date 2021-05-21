package com.example.moviedb.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviedb.core.data.local.LocalDataSource
import com.example.moviedb.core.data.local.entity.DataEntity
import com.example.moviedb.core.data.remote.RemoteDataSource
import com.example.moviedb.core.utils.AppExecutors
import com.example.moviedb.core.utils.DataDummy
import com.example.moviedb.core.vo.Resource
import com.example.moviedb.utils.*
import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutor = Mockito.mock(AppExecutors::class.java)
    private val filmRepository = DummyFilmRepository(remote, local, appExecutor)
    private val testExecutor = AppExecutors(TestExecutor(), TestExecutor(), TestExecutor())

    private val filmResponse = DataDummy.generateDummyMoviesList()
    private val tvResponse = DataDummy.generateDummyTVShowsList()
    private val filmList = DataDummy.generateDummyMovie()
    private val tvList = DataDummy.generateDummyTVShows()
    private val filmId = filmList[0].id
    private val tvId = tvList[0].id

    @Test
    fun getAllMovie() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataEntity>
        Mockito.`when`(local.getListMovie()).thenReturn(dataSourceFactory)
        filmRepository.getAllMovie()

        val filmEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        Mockito.verify(local).getListMovie()
        TestCase.assertNotNull(filmEntities.data)
        assertEquals(filmResponse.size.toLong(), filmEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTVShows() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataEntity>
        Mockito.`when`(local.getListTvShow()).thenReturn(dataSourceFactory)
        filmRepository.getAllTVShows()

        val tvEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShows()))
        Mockito.verify(local).getListTvShow()
        TestCase.assertNotNull(tvEntities.data)
        assertEquals(tvResponse.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getMovieWithId() {
        val filmDummy = MutableLiveData<DataEntity>()
        filmDummy.value = filmList[0]
        Mockito.`when`(local.getDetailMovie(filmId!!)).thenReturn(filmDummy)

        val filmEntities = LiveDataTestUtil.getValue(filmRepository.getMovieWithId(filmList[0].id))

        Mockito.verify(local).getDetailMovie(filmId)
        TestCase.assertNotNull(filmEntities.data)
        assertEquals(filmId, filmEntities.data?.id)
    }

    @Test
    fun getTvWithId() {
        val tvDummy = MutableLiveData<DataEntity>()
        tvDummy.value = tvList[0]
        Mockito.`when`(local.getDetailTvShow(tvId!!)).thenReturn(tvDummy)

        val tvEntities = LiveDataTestUtil.getValue(filmRepository.getTvWithId(tvList[0].id))
        Mockito.verify(local).getDetailTvShow(tvId)
        TestCase.assertNotNull(tvEntities.data)
        assertEquals(tvId, tvEntities.data?.id)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSource =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataEntity>
        Mockito.`when`(local.getListFavoriteMovie()).thenReturn(dataSource)
        filmRepository.getListFavoriteMovie()

        val filmEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        Mockito.verify(local).getListFavoriteMovie()
        TestCase.assertNotNull(filmEntities)
        assertEquals(filmResponse.size.toLong(), filmEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTv() {
        val dataSource =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DataEntity>
        Mockito.`when`(local.getListFavoriteTvShow()).thenReturn(dataSource)
        filmRepository.getListFavoriteTvShow()

        val tvEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShows()))
        Mockito.verify(local).getListFavoriteTvShow()
        TestCase.assertNotNull(tvEntities)
        assertEquals(tvResponse.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun setFavoriteFilm() {
        Mockito.`when`(appExecutor.diskIO()).thenReturn(testExecutor.diskIO())
        Mockito.doNothing().`when`(local).setFavorite(filmList[0])
        filmRepository.setFavorite(filmList[0])
        Mockito.verify(local, Mockito.times(1)).setFavorite(filmList[0])
        TestCase.assertEquals(false, filmList[0].favorite)
    }

    @Test
    fun setFavoriteTv() {
        Mockito.`when`(appExecutor.diskIO()).thenReturn(testExecutor.diskIO())
        Mockito.doNothing().`when`(local).setFavorite(tvList[0])
        filmRepository.setFavorite(tvList[0])
        Mockito.verify(local, Mockito.times(1)).setFavorite(tvList[0])
        TestCase.assertEquals(false, tvList[0].favorite)
    }

}