package com.example.usecases


import androidx.paging.PagingData
import com.example.data.repository.TvShowsRepository
import com.example.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

class HomeCase(private val tvShowRepo : TvShowsRepository) {

     fun requestTvShow(url: String): Flow<PagingData<TvShow>> = tvShowRepo.requestTvShows(url)
}