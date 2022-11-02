package com.example.mobicomposeapp.framework.api

import com.example.domain.model.TvShow
import com.example.domain.model.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowApi {
    @GET("tv/popular")
    suspend fun getTvShowsByUrl(
//        @Url url : String,
        @Query("api_key") api_key: String,
        @Query("page") page: Int = 1,
    ): Response<TvShowList>
//            Response<ResponseWrapper<List<TvShowResponse>>>
}