package com.example.mobicomposeapp.framework.di

import com.example.data.api.TvShowApi
import com.example.data.datasource.tvShows.TvShowsRemoteSource
import com.example.data.datasource.tvShows.imp.TvShowsRemoteSourceImp
import com.example.data.room.MubiDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//
//@Module
//@InstallIn(SingletonComponent::class)
//object RemoteDataModule {
//    @Provides
//    fun provideMoviesRemoteDataSource(tvShowApi: TvShowApi, mobiDb: MubiDatabase) : TvShowsRemoteSource =
//        TvShowsRemoteSourceImp(tvShowApi,mobiDb)
//}