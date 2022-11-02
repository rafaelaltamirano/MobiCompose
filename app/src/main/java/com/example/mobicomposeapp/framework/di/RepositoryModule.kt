package com.example.mobicomposeapp.framework.di


import com.example.data.tvShows.TvShowsLocalSource
import com.example.data.tvShows.TvShowsRemoteSource
import com.example.data.repository.TvShowsRepositoryImp
import com.example.domain.repostiory.TvShowsRepository
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
        return TvShowsRepositoryImp(remote, local)
    }
}