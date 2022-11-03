package com.example.mobicomposeapp.framework.di

import com.example.data.api.TvShowApi
import com.example.data.dao.TvShowDao
import com.example.data.dao.TvShowKeyDao
import com.example.data.datasource.tvShows.TvShowsLocalSource
import com.example.data.datasource.tvShows.TvShowsRemoteSource
import com.example.data.datasource.tvShows.imp.TvShowsLocalSourceImp
import com.example.data.datasource.tvShows.imp.TvShowsRemoteSourceImp
import com.example.domain.model.TvShowKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    fun provideLocalDataSource(tvShowDao: TvShowDao,TvShowKeyDao:TvShowKeyDao): TvShowsLocalSource =
        TvShowsLocalSourceImp(tvShowDao,TvShowKeyDao)

    @Provides
    fun provideLocalRemoteSource(api: TvShowApi): TvShowsRemoteSource =
        TvShowsRemoteSourceImp(api)
}