package com.example.moviedb.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviedb.core.data.NetworkBoundResource
import com.example.moviedb.core.data.local.LocalDataSource
import com.example.moviedb.core.data.local.entity.DataEntity
import com.example.moviedb.core.data.remote.RemoteDataSource
import com.example.moviedb.core.data.remote.response.*
import com.example.moviedb.core.utils.AppExecutors
import com.example.moviedb.core.vo.Resource
import com.example.moviedb.data.remote.response.*

class DummyFilmRepository constructor(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    com.example.moviedb.core.data.FilmDataSource {

    override fun getAllMovie(): LiveData<Resource<PagedList<DataEntity>>> {

        return object : NetworkBoundResource<PagedList<DataEntity>, List<MovieList>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<DataEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getListMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<DataEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieList>>> =
                remoteDataSource.getListMovie()

            override fun saveCallResult(data: List<MovieList>) {
                val movieList = ArrayList<DataEntity>()
                for (response in data) {
                    val movie = DataEntity(
                        id = response.id ?: 0,
                        title = response.title ?: "",
                        overview = null,
                        genre = null,
                        releaseDate = response.releaseDate ?: "",
                        score = response.score ?: 0.0,
                        poster = response.moviePoster ?: "",
                        type = "MOVIE"
                    )
                    movieList.add(movie)
                }
                localDataSource.insertData(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTVShows(): LiveData<Resource<PagedList<DataEntity>>> {

        return object :
            NetworkBoundResource<PagedList<DataEntity>, List<TVShowsList>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<DataEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getListTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<DataEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TVShowsList>>> =
                remoteDataSource.getListTv()

            override fun saveCallResult(data: List<TVShowsList>) {
                val tvList = ArrayList<DataEntity>()
                for (response in data) {
                    val tv = DataEntity(
                        id = response.id ?: 0,
                        title = response.title ?: "",
                        overview = null,
                        genre = null,
                        releaseDate = response.releaseDate ?: "",
                        score = response.score ?: 0.0,
                        poster = response.tvPoster ?: "",
                        type = "TVSHOWS"
                    )
                    tvList.add(tv)
                }
                localDataSource.insertData(tvList)
            }
        }.asLiveData()
    }

    override fun getMovieWithId(movieId: Int): LiveData<Resource<DataEntity>> {

        return object : NetworkBoundResource<DataEntity, MovieDetail>(appExecutors) {
            override fun loadFromDB(): LiveData<DataEntity> =
                localDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: DataEntity?): Boolean =
                data?.genre == null || data?.overview == null

            override fun createCall(): LiveData<ApiResponse<MovieDetail>> =
                remoteDataSource.getMovieDetail(movieId)

            override fun saveCallResult(data: MovieDetail) {
                val movieList = ArrayList<DataEntity>()
                var genre = ""
                for (i in 0 until data.genres.size) {
                    if (i < 2) genre += data.genres[i].genreName
                    if (i < 1) genre += " | "
                }
                val film = DataEntity(
                    id = data.id ?: 0,
                    title = data.title ?: "",
                    overview = data.overview ?: "",
                    genre = genre,
                    releaseDate = data.releaseDate ?: "",
                    score = data.score ?: 0.0,
                    poster = data.moviePoster ?: "",
                    type = "MOVIE"
                )
                movieList.add(film)

                localDataSource.insertData(movieList)
            }
        }.asLiveData()
    }

    override fun getTvWithId(tvId: Int): LiveData<Resource<DataEntity>> {

        return object : NetworkBoundResource<DataEntity, TVShowsDetail>(appExecutors) {
            override fun loadFromDB(): LiveData<DataEntity> =
                localDataSource.getDetailTvShow(tvId)

            override fun shouldFetch(data: DataEntity?): Boolean =
                data?.genre == null || data?.overview == null

            override fun createCall(): LiveData<ApiResponse<TVShowsDetail>> =
                remoteDataSource.getTvDetail(tvId)

            override fun saveCallResult(data: TVShowsDetail) {
                val tvList = ArrayList<DataEntity>()
                var genre = ""
                for (i in 0 until data.genres.size) {
                    if (i < 2) genre += data.genres[i].genreName
                    if (i < 1) genre += " | "
                }
                val tv = DataEntity(
                    id = data.id ?: 0,
                    title = data.title ?: "",
                    overview = data.overview ?: "",
                    genre = genre,
                    releaseDate = data.releaseDate ?: "",
                    score = data.score ?: 0.0,
                    poster = data.tvPoster ?: "",
                    type = "TVSHOWS"
                )
                tvList.add(tv)
                localDataSource.insertData(tvList)
            }

        }.asLiveData()
    }

    override fun setFavorite(dataEntity: DataEntity) {
        appExecutors.diskIO().execute { localDataSource.setFavorite(dataEntity) }
    }

    override fun getListFavoriteMovie(): LiveData<PagedList<DataEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getListFavoriteMovie(), config).build()
    }

    override fun getListFavoriteTvShow(): LiveData<PagedList<DataEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getListFavoriteTvShow(), config).build()
    }

}