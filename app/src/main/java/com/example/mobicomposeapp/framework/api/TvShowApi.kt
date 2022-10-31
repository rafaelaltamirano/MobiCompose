package com.example.mobicomposeapp.framework.api

import com.example.mobicomposeapp.framework.api.schemas.response.ResponseWrapper
import com.example.mobicomposeapp.framework.api.schemas.response.TvShowResponse
import retrofit2.Response
import retrofit2.http.*

interface TvShowApi {
    @GET
    @Headers("Content-Type: application/json; charset=UTF-8")
    suspend fun getTvShowsByUrl(
        @Url url : String,
        @Query("api_key") api_key: String
    ): Response<ResponseWrapper<List<TvShowResponse>>>
}