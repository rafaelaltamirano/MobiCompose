package com.example.mobicomposeapp.framework.datasourceImp.tvShows

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.tvShows.TvShowsRemoteSource
import com.example.domain.model.TvShow
import com.example.mobicomposeapp.framework.api.TvShowApi
import com.example.mobicomposeapp.framework.db.MubiDatabase
import com.example.mobicomposeapp.framework.paging.TvShowsRemoteMediator
import kotlinx.coroutines.flow.Flow

class TvShowsRemoteSourceImp (
    private val api: TvShowApi,
    private val mubiDB: MubiDatabase
) : TvShowsRemoteSource {

    private val tbShowDao = mubiDB.tvShowDao()

    @OptIn(ExperimentalPagingApi::class)
    override fun requestTvShows() : Flow<PagingData<TvShow>> {
        val pagingSourceFactory = { tbShowDao.getAllTvShows() }
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = TvShowsRemoteMediator(
                api,
                mubiDB
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }
}