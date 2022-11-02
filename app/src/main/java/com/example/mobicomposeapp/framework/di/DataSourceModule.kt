package com.example.mobicomposeapp.framework.di

import com.example.data.tvShows.TvShowsLocalSource
import com.example.data.tvShows.TvShowsRemoteSource
import com.example.mobicomposeapp.framework.datasourceImp.tvShows.TvShowsLocalSourceImp
import com.example.mobicomposeapp.framework.datasourceImp.tvShows.TvShowsRemoteSourceImp
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