package com.example.moviedb.core.utils

import com.example.moviedb.core.data.local.entity.DataEntity
import com.example.moviedb.core.domain.model.DataModels

object DataMapper {
    fun mapDataEntitiesToDomain(input: List<DataEntity>): List<DataModels> =
        input.map {
            DataModels(
                it.id,
                it.title,
                it.genre,
                it.overview,
                it.score,
                it.releaseDate,
                it.poster,
                it.favorite,
                it.type
            )
        }

    fun mapDomainToDataEntities(input: DataModels): DataEntity =
        DataEntity(
            input.id,
            input.title,
            input.genre,
            input.overview,
            input.score,
            input.releaseDate,
            input.poster,
            input.favorite,
            input.type
        )

    fun mapDetail(input: DataEntity): DataModels =
        DataModels(
            input.id,
            input.title,
            input.genre,
            input.overview,
            input.score,
            input.releaseDate,
            input.poster,
            input.favorite,
            input.type
        )
}