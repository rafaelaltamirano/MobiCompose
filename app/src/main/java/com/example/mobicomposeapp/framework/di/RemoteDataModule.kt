package com.example.mobicomposeapp.framework.di

import com.example.data.tvShows.TvShowsRemoteSource
import com.example.mobicomposeapp.framework.api.TvShowApi
import com.example.mobicomposeapp.framework.datasourceImp.tvShows.TvShowsRemoteSourceImp
import com.example.mobicomposeapp.framework.db.MubiDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideMoviesRemoteDataSource(tvShowApi: TvShowApi, mobiDb: MubiDatabase) : TvShowsRemoteSource =
        TvShowsRemoteSourceImp(tvShowApi,mobiDb)
}