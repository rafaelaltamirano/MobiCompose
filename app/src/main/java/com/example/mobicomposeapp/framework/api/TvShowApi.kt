package com.example.mobicomposeapp.framework.api

import com.example.mobicomposeapp.framework.api.schemas.response.ResponseWrapper
import com.example.mobicomposeapp.framework.api.schemas.response.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TvShowApi {
    @GET("tv/popular")
    @Headers("Content-Type: application/json; charset=UTF-8")
    suspend fun getPopularShows(
        @Query("api_key") api_key: String,
    ): Response<ResponseWrapper<List<TvShowResponse>>>
}