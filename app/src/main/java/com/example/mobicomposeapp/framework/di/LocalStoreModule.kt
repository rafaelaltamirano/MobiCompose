package com.example.mobicomposeapp.framework.di

import com.example.data.datasource.dao.TvShowDao
import com.example.mobicomposeapp.framework.db.MubiDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalStoreModule {

    @Singleton
    @Provides
    fun provideTvShowDao(mubiDatabase: MubiDatabase): TvShowDao = mubiDatabase.tvShowDao()

}