package com.example.mobicomposeapp.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.domain.model.TvShow
import com.example.mobicomposeapp.ui.screen.ViewModelWithStatus
import com.example.usecases.HomeCase
import com.example.usecases.TvShowUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeModel @Inject constructor(
    tvShowUseCases: TvShowUseCases
) : ViewModelWithStatus() {

    init {
//        requestTvShows("top_rated")
    }

    var state by mutableStateOf(HomeState())
        private set

    private fun setTvShows(tvShows: List<TvShow>) {
        state = state.copy(tvShows = tvShows)
    }

    val requestTvShows = tvShowUseCases.getTvShows()

//     fun requestTvShows() = viewModelScope.launch {
////        setLoadingMovements(true)
//        try {
//                homeCase.requestTvShow()
//        } catch (e: Exception) {
//            handleNetworkError(e)
//        } finally {
////            setLoadingMovements(false)
//        }
//    }



}