package com.example.moviedb.core.data.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tb_data")
@Parcelize
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,
    @NonNull
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "genre")
    val genre: String?,
    @ColumnInfo(name = "overview")
    val overview: String?,
    @ColumnInfo(name = "score")
    val score: Double?,
    @ColumnInfo(name = "releaseDate")
    val releaseDate: String?,
    @ColumnInfo(name = "poster")
    val poster: String?,
    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,
    @ColumnInfo(name = "type")
    var type: String?

) : Parcelable
