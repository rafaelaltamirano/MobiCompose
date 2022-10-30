package com.example.data.datasource.repository

import com.example.data.datasource.LocalSource
import com.example.domain.model.TvShow

class TvShowsRepository(
    private val remote: TvShowsRemoteSource,
    private val local: TvShowsLocalSource
) : LocalSource<List<TvShow>> {

    var tvShow: List<TvShow> = emptyList()
        private set

    suspend fun requestTvShows() = remote.requestTvShows().also {
        save(it)
    }
    override suspend fun save(t: List<TvShow>) {
        this.tvShow = t
        local.save(t)
    }

    override suspend fun load(): List<TvShow> = (local.load() ?: emptyList()).also {
        this.tvShow = it
    }

    override suspend fun clear() = local.clear().also { this.tvShow = emptyList() }

}

interface TvShowsRemoteSource {

    suspend fun requestTvShows(): List<TvShow>

}

interface TvShowsLocalSource : LocalSource<List<TvShow>>