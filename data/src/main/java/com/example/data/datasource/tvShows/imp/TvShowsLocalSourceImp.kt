package com.example.data.datasource.tvShows.imp

import androidx.paging.PagingSource
import com.example.data.dao.TvShowDao
import com.example.data.dao.TvShowKeyDao
import com.example.data.datasource.tvShows.TvShowsLocalSource
import com.example.domain.model.TvShow
import com.example.domain.model.TvShowKey


class TvShowsLocalSourceImp(
    private val tvShowDao: TvShowDao,
    private val tvShowKeysDao: TvShowKeyDao
) : TvShowsLocalSource {

    override fun getTvShowDao(): TvShowDao = tvShowDao

    override suspend fun getTvShowsFromDB(): PagingSource<Int, TvShow> = tvShowDao.getAllTvShows()
    override suspend fun getTvShowKeysFromDB(tvShowId: Long?): TvShowKey = tvShowKeysDao.getTvShowKeys(tvShowId)

    override suspend fun insertTvShowsToDB(tvShows: List<TvShow>) = tvShowDao.insertTvShow(tvShows)
    override suspend fun insertTvShowKeyToDB(tvShowKeysId: List<TvShowKey>) = tvShowKeysDao.insertAllTvShowKeys(tvShowKeysId)

    override suspend fun deleteTvShowsFromDB() = tvShowDao.deleteTvShows()
    override suspend fun deleteTvShowKeysFromDB() = tvShowKeysDao.deleteAllTvShowKeys()

}

