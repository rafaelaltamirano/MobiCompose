package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.TvShowKey

@Dao
interface TvShowKeyDao {

    @Query("SELECT * FROM tv_show_keys WHERE id = :tvShowId")
    suspend fun getTvShowKeys(tvShowId: Long?): TvShowKey

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTvShowKeys(tvShowKeys : List<TvShowKey>)

    @Query("DELETE FROM tv_show_keys")
    suspend fun deleteAllTvShowKeys()
}