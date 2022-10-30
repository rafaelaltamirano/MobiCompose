package com.example.mobicomposeapp.framework.di

import com.example.mobicomposeapp.AppConstants.BASE_URL
import com.example.mobicomposeapp.framework.api.TvShowApi
import com.example.mobicomposeapp.framework.api.ApiProvider.getTvShowApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor {
                val builder = it.request().newBuilder()
                it.proceed(builder.build())
            }
            .build()
    }

    @Singleton
    @Provides
    fun providerTvShowsApi(
        client: OkHttpClient
    ): TvShowApi {
        val baseURL = BASE_URL
        return getTvShowApi(baseURL, client)
    }
}