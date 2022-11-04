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
    var state by mutableStateOf(HomeState())
        private set

    init {
        requestTvShows(TvShowTypes.TOP_RATED.url)
        setMediator(true)
    }

    private fun setTvShows(tvShows: Flow<PagingData<TvShow>>) {
        state = state.copy(tvShows = tvShows)
    }
    private fun setLoading(loading: Boolean) {
        state = state.copy(loading = loading)
    }
     fun setMediator(mediator: Boolean) {
        state = state.copy(mediator = mediator)
    }

    fun requestTvShows(url: String) = viewModelScope.launch {
        try {
            setLoading(true)
         withContext(IO) {homeCase.requestTvShow(url)}.also { setTvShows(it)}
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
            setLoading(false)
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