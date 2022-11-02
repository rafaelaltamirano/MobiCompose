package com.example.data.repository

import com.example.data.tvShows.TvShowsLocalSource
import com.example.data.tvShows.TvShowsRemoteSource
import com.example.domain.model.TvShow
import com.example.domain.repostiory.TvShowsRepository
import kotlinx.coroutines.flow.Flow

class TvShowsRepositoryImp(
    private val remote: TvShowsRemoteSource,
    private val local: TvShowsLocalSource
) : TvShowsRepository {
    override fun getTvShows() = remote.requestTvShows()

    override fun getTvShowsFromDB(tvShowId: Int): Flow<TvShow> = local.getTvShowsFromDB(tvShowId)
}

