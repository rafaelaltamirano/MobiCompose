package com.example.mobicomposeapp.framework.di

import com.example.data.api.TvShowApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }

//    @Singleton
//    @Provides
//    fun providerTvShowsApi(
//        client: OkHttpClient
//    ): TvShowApi {
//        val baseURL = BASE_URL
//        return getTvShowApi(baseURL, client)
//    }

    @Provides
    @Singleton
    fun providerTvShowsApi(retrofit: Retrofit): TvShowApi {
        return retrofit.create(TvShowApi::class.java)
    }
}