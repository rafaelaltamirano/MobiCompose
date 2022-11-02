package com.example.usecases


import androidx.paging.PagingData
import com.example.domain.model.TvShow
import com.example.domain.repostiory.TvShowsRepository
import java.lang.Exception
import kotlinx.coroutines.flow.Flow

data class TvShowUseCases(
    val getTvShows: HomeCase,
)


class HomeCase(private val tvShowRepo : TvShowsRepository) {

    operator fun invoke() = tvShowRepo.getTvShows()

//     fun requestTvShow(): Flow<PagingData<TvShow>> {
//        return try {
//            tvShowRepo.getTvShows()
//        } catch (e: Exception) {
//                throw Exception()
//        }
//    }
}