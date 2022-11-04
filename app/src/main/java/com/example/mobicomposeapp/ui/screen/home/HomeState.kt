package com.example.mobicomposeapp.ui.screen.home

import androidx.paging.PagingData
import com.example.domain.model.TvShow
import com.example.mobicomposeapp.ui.screen.home.TvShowTypes.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

enum class TvShowTypes(val type: String) {
    TOP_RATED("Top Rated"),
    POPULAR("Popular"),
    ON_TV("On Tv"),
    AIRING_TODAY("Airing Today")
}

data class HomeState(
    val category: Map<TvShowTypes, String> = mapOf(
        TOP_RATED to "top_rated",
        POPULAR to "popular",
        ON_TV to "on_the_air",
        AIRING_TODAY to "airing_today"
    ),
//    val category: List<TvShowTypes> = listOf(TOP_RATED, POPULAR, ON_TV,AIRING_TODAY),
    val tvShows: Flow<PagingData<TvShow>> = emptyFlow(),
    val loading: Boolean = false,
    val mediator: Boolean = false,


    )
