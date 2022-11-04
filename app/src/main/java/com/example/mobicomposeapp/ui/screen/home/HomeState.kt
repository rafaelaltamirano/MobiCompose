package com.example.mobicomposeapp.ui.screen.home

import androidx.paging.PagingData
import com.example.domain.model.TvShow
import com.example.mobicomposeapp.ui.screen.home.TvShowTypes.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

//enum class TvShowTypes(val type: String) {
//    TOP_RATED("Top Rated"),
//    POPULAR("Popular"),
//    ON_TV("On Tv"),
//    AIRING_TODAY("Airing Today")
//}

enum class TvShowTypes(val url: String) {
    TOP_RATED("top_rated"),
    POPULAR("popular"),
    ON_TV("on_the_air"),
    AIRING_TODAY("airing_today")
}

data class HomeState(
    val category: Map<TvShowTypes, String> = mapOf(
        TOP_RATED to "Top Rated",
        POPULAR to "Popular",
        ON_TV to "On Tv",
        AIRING_TODAY to "Airing Today"
    ),
//    val category: List<TvShowTypes> = listOf(TOP_RATED, POPULAR, ON_TV,AIRING_TODAY),
    val tvShows: Flow<PagingData<TvShow>> = emptyFlow(),
    val loading: Boolean = false,
    val mediator: Boolean = false,


    )
