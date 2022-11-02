package com.example.mobicomposeapp.framework.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.domain.model.TvShow
import com.example.domain.model.TvShowRemoteKeys
import com.example.mobicomposeapp.AppConstants.API_KEY
import com.example.mobicomposeapp.framework.api.TvShowApi
import com.example.mobicomposeapp.framework.db.MubiDatabase


@OptIn(ExperimentalPagingApi::class)
class TvShowsRemoteMediator(
    private val api: TvShowApi,
    private val mubiDB: MubiDatabase): RemoteMediator<Int, TvShow>() {

    private val tvShowDao = mubiDB.tvShowDao()
    private val tvShowRemoteKeysDao = mubiDB.tvShowRemoteKeysDao()


    override suspend fun load(loadType: LoadType, state: PagingState<Int, TvShow>): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }
            val response = api.getTvShowsByUrl(api_key = API_KEY, page = page)
            var endOfPaginationReached = false
            if (response.isSuccessful) {
                val responseData = response.body()
                endOfPaginationReached = responseData == null
                responseData?.let {
                    mubiDB.withTransaction {
                        if (loadType == LoadType.REFRESH) {
                            tvShowDao.deleteTvShows()
                            tvShowRemoteKeysDao.deleteAllTvShowRemoteKeys()
                        }
                        var prevPage: Int?
                        var nextPage: Int

                        responseData.page.let { pageNumber ->
                            nextPage = pageNumber + 1
                            prevPage = if (pageNumber <= 1) null else pageNumber - 1
                        }

                        val keys = responseData.tvShows.map { tvShow ->
                            TvShowRemoteKeys(
                                id = tvShow.tvShowId,
                                prevPage = prevPage,
                                nextPage = nextPage,
                                lastUpdated = System.currentTimeMillis()
                            )
                        }
                        tvShowRemoteKeysDao.addAllMovieRemoteKeys(tvShowRemoteKeys = keys)
                        tvShowDao.insertTvShow(tvShow = responseData.tvShows)
                    }
                }

            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, TvShow>,
    ): TvShowRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.tvShowId?.let { id ->
                tvShowRemoteKeysDao.getTvShowRemoteKeys(tvShowId = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, TvShow>,
    ): TvShowRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { tvShow ->
                tvShowRemoteKeysDao.getTvShowRemoteKeys(tvShowId = tvShow.tvShowId)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, TvShow>,
    ): TvShowRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { tvShow ->
                tvShowRemoteKeysDao.getTvShowRemoteKeys(tvShowId = tvShow.tvShowId)
            }
    }
}