package com.example.data.dto


data class ResponseWrapper<T>(
    val total_count: Int,
    val results: T
)


