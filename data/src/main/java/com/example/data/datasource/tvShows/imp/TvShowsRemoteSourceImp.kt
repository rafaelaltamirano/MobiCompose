package com.example.data.datasource.tvShows.imp

import com.example.data.AppConstants.API_KEY
import com.example.data.api.TvShowApi
import com.example.data.datasource.tvShows.TvShowsRemoteSource
import com.example.domain.model.TvShow
import javax.inject.Inject


class TvShowsRemoteSourceImp  @Inject constructor(
    private val api: TvShowApi
) : TvShowsRemoteSource {

    override suspend fun requestTvShows(page: Int,url:String): List<TvShow> {

            val res = api.getTvShowsByUrl(api_key = API_KEY, page = page, url = "tv/$url")
             return res.body()!!.results.map { it.toEntity() }



    }
}
