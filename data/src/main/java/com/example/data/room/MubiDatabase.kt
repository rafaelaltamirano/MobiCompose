package com.example.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.TvShowDao
import com.example.data.dao.TvShowKeyDao
import com.example.domain.model.TvShow
import com.example.domain.model.TvShowKey

@Database(
    entities = [TvShow::class, TvShowKey::class],
    version = 4,
    exportSchema = false)

abstract class MubiDatabase : RoomDatabase() {
    abstract fun tvShowDao(): TvShowDao
    abstract fun tvShowKeysDao(): TvShowKeyDao
}