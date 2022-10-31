package com.example.mobicomposeapp.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.model.TvShow
import com.example.mobicomposeapp.ui.screen.ViewModelWithStatus
import com.example.usecase.HomeCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeModel @Inject constructor(
private val homeCase: HomeCase
) : ViewModelWithStatus() {

    init {
        requestTvShows("top_rated")
    }

    var state by mutableStateOf(HomeState())
        private set

    private fun setTvShows(tvShows: List<TvShow>) {
        state = state.copy(tvShows = tvShows)
    }

     fun requestTvShows(url:String) = viewModelScope.launch {
//        setLoadingMovements(true)
        try {
            withContext(Dispatchers.IO) {
                homeCase.requestTvShow(url)
            }.also(::setTvShows)
        } catch (e: Exception) {
            handleNetworkError(e)
        } finally {
//            setLoadingMovements(false)
        }
    }



}