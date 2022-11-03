package com.example.usecases


import androidx.paging.PagingData
import com.example.data.repository.TvShowsRepository
import com.example.domain.model.TvShow
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

//data class TvShowUseCases(
//    val getTvShows: HomeCase,
//)

class HomeCase(private val tvShowRepo : TvShowsRepository) {

     fun requestTvShow(): Flow<PagingData<TvShow>> {
          return try {
               tvShowRepo.requestTvShows()

          }
          catch (e: Exception) {
               throw e
          }
     }

}