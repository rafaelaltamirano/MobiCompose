package com.example.data.tvShows

import com.example.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowsLocalSource{
    fun getTvShowsFromDB(tvShowId : Int): Flow<TvShow>
}