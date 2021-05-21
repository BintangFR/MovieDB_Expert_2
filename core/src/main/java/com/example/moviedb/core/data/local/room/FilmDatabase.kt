package com.example.moviedb.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviedb.core.data.local.entity.DataEntity

@Database(entities = [DataEntity::class], version = 1, exportSchema = false)
abstract class FilmDatabase : RoomDatabase() {

    abstract fun filmDao(): FilmDao

    companion object {

        @Volatile
        private var INSTANCE: FilmDatabase? = null

    }
}