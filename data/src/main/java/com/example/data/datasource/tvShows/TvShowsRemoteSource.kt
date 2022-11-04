package com.example.data.datasource.tvShows

import com.example.domain.model.TvShow

interface TvShowsRemoteSource {
suspend fun requestTvShows(page: Int,url :String): List<TvShow>
}