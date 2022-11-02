package com.example.data.tvShows

import androidx.paging.PagingData
import com.example.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowsRemoteSource {
//    suspend fun requestTvShows(url: String): Flow<PagingData<TvShow>>
 fun requestTvShows(): Flow<PagingData<TvShow>>
}