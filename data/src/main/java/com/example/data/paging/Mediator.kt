package com.example.data.paging


import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.data.datasource.tvShows.TvShowsRemoteSource
import com.example.data.room.MubiDatabase
import com.example.domain.model.TvShow
import com.example.domain.model.TvShowKey


@ExperimentalPagingApi
class UnsplashRemoteMediator(
    private val tvShowsRemoteSource: TvShowsRemoteSource,
    private val mobiDatabase: MubiDatabase,
    private val url: String,
) : RemoteMediator<Int, TvShow>() {

    private val tvShowDao = mobiDatabase.tvShowDao()
    private val tvShowKeysDao = mobiDatabase.tvShowKeysDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, TvShow>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
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

            val response = tvShowsRemoteSource.requestTvShows(page = currentPage, url = url)
            val endOfPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            mobiDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    tvShowDao.deleteTvShows()
                    tvShowKeysDao.deleteAllTvShowKeys()
                }
                val keys = response.map { unsplashImage ->
                    TvShowKey(
                        id = unsplashImage.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                tvShowKeysDao.insertAllTvShowKeys( keys)
                tvShowDao.insertTvShow(response)
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, TvShow>
    ): TvShowKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                tvShowKeysDao.getTvShowKeys( id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, TvShow>
    ): TvShowKey? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { unsplashImage ->
                tvShowKeysDao.getTvShowKeys(unsplashImage.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, TvShow>
    ): TvShowKey? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { tvShowImage ->
                tvShowKeysDao.getTvShowKeys(tvShowImage.id)
            }
    }

}