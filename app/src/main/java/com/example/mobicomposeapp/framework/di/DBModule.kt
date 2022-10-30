package com.example.mobicomposeapp.framework.di

import android.content.Context
import androidx.room.Room
import com.example.mobicomposeapp.framework.db.MubiDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DBModule {
    @Provides
    @Singleton
    fun provideMubiDatabaseDb(
        @ApplicationContext appContext: Context
    ): MubiDatabase {
        return Room.databaseBuilder(
            appContext,
            MubiDatabase::class.java,
            "mubi_database"
        ).build()
    }
}