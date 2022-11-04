package com.example.data.datasource.tvShows

import androidx.paging.PagingSource
import com.example.data.dao.TvShowDao
import com.example.data.dao.TvShowKeyDao
import com.example.domain.model.TvShow
import com.example.domain.model.TvShowKey

interface TvShowsLocalSource{
    suspend fun getTvShowsFromDB(): PagingSource<Int, TvShow>
    suspend fun getTvShowKeysFromDB(tvShowId: Long?):TvShowKey
    suspend fun deleteTvShowsFromDB()
    suspend fun deleteTvShowKeysFromDB()
    suspend fun insertTvShowsToDB(tvShows: List<TvShow>)
    suspend fun insertTvShowKeyToDB(tvShowKeysId: List<TvShowKey>)
     fun getTvShowDao(): TvShowDao
}