package com.example.mobicomposeapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.datasource.dao.TvShowDao
import com.example.data.datasource.entities.TvShowEntity

@Database(
    entities = [TvShowEntity::class],
    version = 2,
    exportSchema = false)

abstract class MubiDatabase : RoomDatabase() {
    abstract fun tvShowDao(): TvShowDao
}