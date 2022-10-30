package com.example.mobicomposeapp.framework.di


import com.example.data.datasource.repository.TvShowsLocalSource
import com.example.data.datasource.repository.TvShowsRemoteSource
import com.example.data.datasource.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providerTvShowsRepository(
        remote: TvShowsRemoteSource,
        local: TvShowsLocalSource
    ): TvShowsRepository {
        return TvShowsRepository(remote, local)
    }
}