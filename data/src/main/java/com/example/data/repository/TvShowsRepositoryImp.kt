package com.example.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.datasource.tvShows.TvShowsRemoteSource
import com.example.data.paging.UnsplashRemoteMediator
import com.example.data.room.MubiDatabase
import com.example.domain.model.TvShow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsRepository  @Inject constructor (
    private val tvShowsRemoteSource: TvShowsRemoteSource,
    private val mobiDatabase: MubiDatabase,
) {
    private val tbShowDao = mobiDatabase.tvShowDao()

    @OptIn(ExperimentalPagingApi::class)
     fun requestTvShows(url : String): Flow<PagingData<TvShow>> {
        val pagingSourceFactory = { tbShowDao.getAllTvShows() }
        return Pager(
            config = PagingConfig(pageSize = 30),
            remoteMediator = UnsplashRemoteMediator(
                tvShowsRemoteSource,
                mobiDatabase,
                url
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}

