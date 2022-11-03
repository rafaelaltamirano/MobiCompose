package com.example.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.example.data.Resource
import com.example.data.datasource.tvShows.TvShowsLocalSource
import com.example.data.datasource.tvShows.TvShowsRemoteSource
import com.example.domain.model.TvShow
import com.example.domain.model.TvShowKey
import javax.inject.Inject


@OptIn(ExperimentalPagingApi::class)
class TvShowMediator @Inject constructor(
    private val tvShowsRemoteSource: TvShowsRemoteSource,
    private val tvShowsLocalSource: TvShowsLocalSource,
    private val initialPage: Int = 1,
) : RemoteMediator<Int, TvShow>() {

    override suspend fun load(loadType: LoadType, state: PagingState<Int, TvShow>): MediatorResult {

        return try {

            val page: Int = when (loadType) {
                LoadType.APPEND -> {
                    val remoteKeys = getLastKey(state)
                    remoteKeys?.nextPage ?: return MediatorResult.Success(true)
                }
                LoadType.PREPEND -> {
                    return MediatorResult.Success(true)
                }
                LoadType.REFRESH -> {
                    val remoteKeys = getClosetKey(state)
                    remoteKeys?.nextPage?.minus(1) ?: initialPage

                }
            }

            val response = tvShowsRemoteSource.requestTvShows(page = page)
            val endOfPagination = response.data?.size!! < state.config.pageSize

            when (response) {
                is Resource.Success -> {
                    val body = response.data

                    if (loadType == LoadType.REFRESH) {
                        tvShowsLocalSource.deleteTvShowKeysFromDB()
                        tvShowsLocalSource.deleteTvShowsFromDB()
                    }

                    val prev = if (page == initialPage) initialPage else page - 1
                    val next = if (endOfPagination) null else page + 1

                    val list = body.map {
                        TvShowKey(id = it.id, prev, next)
                    }
                    list.let { tvShowsLocalSource.insertTvShowKeyToDB(list) }
                    body.let { tvShowsLocalSource.insertTvShowsToDB(body) }


                }
                is Resource.Error -> {
                    MediatorResult.Error(Exception())

                }

                else -> {}
            }

            if (response is Resource.Success) {
                if (endOfPagination) {
                    MediatorResult.Success(true)

                } else {
                    MediatorResult.Success(false)
                }
            } else {
                MediatorResult.Success(true)
            }


        } catch (E: Exception) {

            MediatorResult.Error(E)

        }
    }

    private suspend fun getLastKey(state: PagingState<Int, TvShow>): TvShowKey? {
        return state.lastItemOrNull()?.let {
            tvShowsLocalSource.getTvShowKeysFromDB(it.id)
        }
    }

    private suspend fun getClosetKey(state: PagingState<Int, TvShow>): TvShowKey? {
        return state.anchorPosition?.let {
            state.closestItemToPosition(it)?.let { tvShow ->
                tvShowsLocalSource.getTvShowKeysFromDB(tvShow.id)
            }
        }
    }

}





