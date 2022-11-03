package com.example.mobicomposeapp.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.domain.model.TvShow
import com.example.mobicomposeapp.ui.screen.ViewModelWithStatus
import com.example.usecases.HomeCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeModel @Inject constructor(
    private val homeCase: HomeCase
) : ViewModelWithStatus() {

    init {
        requestTvShows()
    }

    var state by mutableStateOf(HomeState())
        private set

    private fun setTvShows(tvShows: Flow<PagingData<TvShow>>) {
        state = state.copy(tvShows = tvShows)
    }

    fun requestTvShows() = viewModelScope.launch {
        try {
         withContext(IO) {homeCase.requestTvShow()}  .also { setTvShows(it) }
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
        }
    }



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