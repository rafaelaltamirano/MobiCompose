package com.example.mobicomposeapp.framework.di

import com.example.data.dao.TvShowDao
import com.example.data.tvShows.TvShowsLocalSource
import com.example.mobicomposeapp.framework.datasourceImp.tvShows.TvShowsLocalSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideLocalDataSource(tvShowDao: TvShowDao): TvShowsLocalSource =
        TvShowsLocalSourceImp(tvShowDao)
}