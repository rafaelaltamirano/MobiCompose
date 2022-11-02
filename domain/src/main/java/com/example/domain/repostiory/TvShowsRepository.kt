package com.example.domain.repostiory

import androidx.paging.PagingData
import com.example.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowsRepository {
     fun getTvShows(): Flow<PagingData<TvShow>>
     fun getTvShowsFromDB(tvShowId: Int): Flow<TvShow>
}
