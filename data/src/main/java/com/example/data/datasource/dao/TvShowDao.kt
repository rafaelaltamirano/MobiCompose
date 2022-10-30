package com.example.data.datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.datasource.entities.TvShowEntity
import com.example.domain.model.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(tvShow: TvShowEntity)

    @Query("DELETE from TvShowEntity")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM TvShowEntity")
    suspend fun getTvShows(): List<TvShowEntity>
}