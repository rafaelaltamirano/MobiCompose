package com.example.mobicomposeapp.framework.di

import com.example.usecase.LoginCase
import com.example.usecase.MainCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providerMainCase(
    ): MainCase {
        return MainCase()
    }

    @Singleton
    @Provides
    fun providerLoginCase(
    ): LoginCase {
        return LoginCase(

        )
    }
}