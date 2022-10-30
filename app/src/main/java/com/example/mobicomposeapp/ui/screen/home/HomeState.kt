package com.example.mobicomposeapp.ui.screen.home

import com.example.domain.model.TvShow

data class HomeState(
    val category: List<String> = listOf("Top Rated","Popular","On Tv", "Airing Today"),
    val tvShows: List<TvShow> = emptyList()


)