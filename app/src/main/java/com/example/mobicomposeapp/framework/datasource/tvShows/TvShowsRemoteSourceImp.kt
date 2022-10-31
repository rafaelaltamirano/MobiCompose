package com.example.mobicomposeapp.framework.datasource.tvShows

import android.content.Context
import com.example.data.datasource.repository.TvShowsRemoteSource
import com.example.domain.model.TvShow
import com.example.mobicomposeapp.AppConstants
import com.example.mobicomposeapp.framework.api.TvShowApi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TvShowsRemoteSourceImp @Inject constructor(
    private val api: TvShowApi,
    @ApplicationContext val context: Context
) : TvShowsRemoteSource {
    override suspend fun requestTvShows(url:String): List<TvShow> {
        val res = api.getTvShowsByUrl(api_key = AppConstants.API_KEY, url = "tv/$url")
//        ApiTools.validateResponseOrFail(res)
        return res.body()!!.results.map { it.toEntity() }
    }


}