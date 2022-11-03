package com.example.data.dto

import com.example.domain.model.TvShow


data class TvShowDto(
    val backdrop_path: String? = "",
    val original_name: String = "",
    val vote_average: Float = 100.0f
) : Response<TvShow> {
        override fun toEntity() = TvShow(

        poster = backdrop_path,
        name = original_name,
        rating = Math.round((vote_average/ 2F) * 10.0) / 10.0 .toFloat()
    )
}
