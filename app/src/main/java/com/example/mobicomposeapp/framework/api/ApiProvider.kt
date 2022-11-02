package com.example.mobicomposeapp.framework.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object ApiProvider {
//    fun getTvShowApi(baseUrl: String, client: OkHttpClient? = null): TvShowApi {
//        val builder = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//        client?.also(builder::client)
//        return builder.build().create(TvShowApi::class.java)
//    }
//}