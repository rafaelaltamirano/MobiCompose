package com.example.mobicomposeapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.TvShowDao
import com.example.data.dao.TvShowRemoteKeysDao
import com.example.domain.model.TvShow
import com.example.domain.model.TvShowRemoteKeys

@Database(
    entities = [TvShow::class, TvShowRemoteKeys::class],
    version = 3,
    exportSchema = false)

abstract class MubiDatabase : RoomDatabase() {
    abstract fun tvShowDao(): TvShowDao
    abstract fun tvShowRemoteKeysDao(): TvShowRemoteKeysDao
}