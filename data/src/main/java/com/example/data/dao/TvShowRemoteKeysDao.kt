package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.TvShowRemoteKeys

@Dao
interface TvShowRemoteKeysDao {

    @Query("SELECT * FROM tv_show_remote_keys WHERE id = :tvShowId")
    suspend fun getTvShowRemoteKeys(tvShowId: Int): TvShowRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllMovieRemoteKeys(tvShowRemoteKeys : List<TvShowRemoteKeys>)

    @Query("DELETE FROM tv_show_remote_keys")
    suspend fun deleteAllTvShowRemoteKeys()
}