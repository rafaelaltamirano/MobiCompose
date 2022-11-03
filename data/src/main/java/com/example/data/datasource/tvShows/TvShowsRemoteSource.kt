package com.example.data.datasource.tvShows

import com.example.data.Resource
import com.example.domain.model.TvShow

interface TvShowsRemoteSource {
suspend fun requestTvShows(page: Int): Resource<List<TvShow>>
}