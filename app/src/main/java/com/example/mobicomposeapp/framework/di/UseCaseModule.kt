package com.example.mobicomposeapp.framework.di

import com.example.domain.repostiory.TvShowsRepository
import com.example.usecases.HomeCase
import com.example.usecases.LoginCase
import com.example.usecases.MainCase
import com.example.usecases.TvShowUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providerMainCase(
    ): MainCase {
        return MainCase()
    }

    @Singleton
    @Provides
    fun providerLoginCase(
    ): LoginCase {
        return LoginCase(
        )
    }

//    @Singleton
//    @Provides
//    fun providerHomeCase(
//        tvShowRepo: TvShowsRepository
//    ) = HomeCase(tvShowRepo)


    @Singleton
    @Provides
    fun provideTvShowUseCases(
        tvShowRepo: TvShowsRepository
    ) = TvShowUseCases(getTvShows = HomeCase(tvShowRepo))


}