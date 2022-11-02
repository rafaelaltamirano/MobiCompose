package com.example.mobicomposeapp.framework.api.schemas.response

import com.example.domain.model.TvShow


data class TvShowResponse(
    val backdrop_path: String? = "",
    val original_name: String = "",
    val vote_average: Float = 100.0f
) : Response<TvShow> {
    //    override fun toEntity() = TvShow(
//        poster = backdrop_path,
//        name = original_name,
//        rating = vote_average / 2F
//    )
    override fun toEntity(): TvShow {
        TODO("Not yet implemented")
    }
}
