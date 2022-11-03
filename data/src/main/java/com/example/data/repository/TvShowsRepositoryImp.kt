package com.example.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.datasource.tvShows.TvShowsLocalSource
import com.example.data.datasource.tvShows.TvShowsRemoteSource
import com.example.data.paging.TvShowMediator
import com.example.domain.model.TvShow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsRepository  @Inject constructor (
    private val tvShowsRemoteSource: TvShowsRemoteSource,
    private val tvShowsLocalSource: TvShowsLocalSource,
) {
    private val tbShowDao = tvShowsLocalSource.getTvShowDao()

    @OptIn(ExperimentalPagingApi::class)
    fun requestTvShows(): Flow<PagingData<TvShow>> {
        val pagingSourceFactory = { tbShowDao.getAllTvShows() }
        return Pager(
            config = PagingConfig(pageSize = 10),
            remoteMediator = TvShowMediator(
                tvShowsRemoteSource,
                tvShowsLocalSource
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}

