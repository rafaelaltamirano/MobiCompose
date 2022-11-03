package com.example.mobicomposeapp.framework.di

import com.example.data.datasource.tvShows.TvShowsLocalSource
import com.example.data.datasource.tvShows.TvShowsRemoteSource
import com.example.data.datasource.tvShows.imp.TvShowsLocalSourceImp
import com.example.data.datasource.tvShows.imp.TvShowsRemoteSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class DataSourceModule {
//
//    @Binds
//    @Singleton
//    abstract fun bindTvShowRemoteSource(imp: TvShowsRemoteSourceImp): TvShowsRemoteSource
//
//    @Binds
//    @Singleton
//    abstract fun bindTvShowLocalSource(imp: TvShowsLocalSourceImp): TvShowsLocalSource
//
//
//}