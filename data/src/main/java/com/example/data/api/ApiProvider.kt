package com.example.data.api


//object ApiProvider {
//    fun getTvShowApi(baseUrl: String, client: OkHttpClient? = null): TvShowApi {
//        val builder = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//        client?.also(builder::client)
//        return builder.build().create(TvShowApi::class.java)
//    }
//}