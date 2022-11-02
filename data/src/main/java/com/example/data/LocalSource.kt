package com.example.data

interface LocalSource<T> {

    suspend fun save(t:  T)

    suspend fun load(): T?

    suspend fun clear()

}