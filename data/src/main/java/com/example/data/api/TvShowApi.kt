package com.example.data.api

import com.example.data.dto.ResponseWrapper
import com.example.data.dto.TvShowDto
import com.example.domain.model.TvShow
import com.example.domain.model.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface TvShowApi {
//    @GET("tv/top_rated")
    @GET
    suspend fun getTvShowsByUrl(
        @Url url: String,
        @Query("api_key") api_key: String,
        @Query("page") page: Int = 1,
    ): Response<ResponseWrapper<List<TvShowDto>>>
//            Response<ResponseWrapper<List<TvShowResponse>>>
}