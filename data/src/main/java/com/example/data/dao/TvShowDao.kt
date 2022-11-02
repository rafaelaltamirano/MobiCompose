package com.example.data.dao



import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(tvShow: List<TvShow>)

    @Query("DELETE from tv_shows")
    suspend fun deleteTvShows()

    @Query("SELECT * FROM tv_shows")
     fun getAllTvShows(): PagingSource<Int, TvShow>

    @Query("SELECT * FROM tv_shows WHERE tvShowId = :tvShowId")
    fun getTvShow(tvShowId: Int): Flow<TvShow>
}