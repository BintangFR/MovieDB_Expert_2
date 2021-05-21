package com.example.moviedb.core.data

import com.example.moviedb.core.data.local.LocalDataSource
import com.example.moviedb.core.data.local.entity.DataEntity
import com.example.moviedb.core.data.remote.RemoteDataSource
import com.example.moviedb.core.data.remote.response.*
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.domain.repository.IFilmRepository
import com.example.moviedb.core.utils.AppExecutors
import com.example.moviedb.core.utils.DataMapper
import com.example.moviedb.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FilmRepository(
    private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    IFilmRepository {

    override fun getAllMovie(): Flow<Resource<List<DataModels>>> {

        return object :
            com.example.moviedb.core.data.NetworkBoundResource<List<DataModels>, List<MovieList>>() {
            override fun loadFromDB(): Flow<List<DataModels>> {
                return localDataSource.getListMovie().map {
                    DataMapper.mapDataEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<DataModels>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MovieList>>> =
                remoteDataSource.getListMovie()

            override suspend fun saveCallResult(data: List<MovieList>) {
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
        }.asFlow()
    }

    override fun getAllTVShows(): Flow<Resource<List<DataModels>>> {

        return object :
            com.example.moviedb.core.data.NetworkBoundResource<List<DataModels>, List<TVShowsList>>() {
            override fun loadFromDB(): Flow<List<DataModels>> {
                return localDataSource.getListTvShow().map {
                    DataMapper.mapDataEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<DataModels>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TVShowsList>>> =
                remoteDataSource.getListTv()

            override suspend fun saveCallResult(data: List<TVShowsList>) {
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
        }.asFlow()
    }

    override fun getMovieWithId(movieId: Int): Flow<Resource<DataModels>> {

        return object :
            com.example.moviedb.core.data.NetworkBoundResource<DataModels, MovieDetail>() {
            override fun loadFromDB(): Flow<DataModels> {
                return localDataSource.getDetailMovie(movieId).map {
                    DataMapper.mapDetail(it)
                }
            }


            override fun shouldFetch(data: DataModels?): Boolean =
                data?.genre == null || data?.overview == null

            override suspend fun createCall(): Flow<ApiResponse<MovieDetail>> =
                remoteDataSource.getMovieDetail(movieId)

            override suspend fun saveCallResult(data: MovieDetail) {
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
        }.asFlow()
    }

    override fun getTvWithId(tvId: Int): Flow<Resource<DataModels>> {

        return object :
            com.example.moviedb.core.data.NetworkBoundResource<DataModels, TVShowsDetail>() {
            override fun loadFromDB(): Flow<DataModels> {
                return localDataSource.getDetailTvShow(tvId).map {
                    DataMapper.mapDetail(it)
                }
            }

            override fun shouldFetch(data: DataModels?): Boolean =
                data?.genre == null || data?.overview == null

            override suspend fun createCall(): Flow<ApiResponse<TVShowsDetail>> =
                remoteDataSource.getTvDetail(tvId)

            override suspend fun saveCallResult(data: TVShowsDetail) {
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

        }.asFlow()
    }

    override fun setFavorite(dataModels: DataModels) {
        val movieEntity = DataMapper.mapDomainToDataEntities(dataModels)
        appExecutors.diskIO().execute { localDataSource.setFavorite(movieEntity) }
    }

    override fun getListFavoriteMovie(): Flow<List<DataModels>> {
        return localDataSource.getListFavoriteMovie().map {
            DataMapper.mapDataEntitiesToDomain(it)
        }
    }

    override fun getListFavoriteTvShow(): Flow<List<DataModels>> {
        return localDataSource.getListFavoriteTvShow().map {
            DataMapper.mapDataEntitiesToDomain(it)
        }
    }

    companion object {
        @Volatile
        private var instance: IFilmRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): IFilmRepository =
            com.example.moviedb.core.data.FilmRepository.Companion.instance ?: synchronized(this) {
                com.example.moviedb.core.data.FilmRepository.Companion.instance
                    ?: com.example.moviedb.core.data.FilmRepository(
                        remoteData,
                        localData,
                        appExecutors
                    ).apply {
                        com.example.moviedb.core.data.FilmRepository.Companion.instance = this
                    }
            }
    }
}