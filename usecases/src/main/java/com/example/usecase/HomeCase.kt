package com.example.usecase

import com.example.data.datasource.repository.TvShowsRepository
import com.example.domain.model.TvShow
import java.lang.Exception

class HomeCase(private val tvShowRepo : TvShowsRepository) {

    suspend fun requestTvShow(url:String): List<TvShow> {
        return try {
            tvShowRepo.requestTvShows(url)
        } catch (e: Exception) {
                throw Exception()
        }
    }
}