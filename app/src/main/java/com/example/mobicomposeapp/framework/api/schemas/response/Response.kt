package com.example.mobicomposeapp.framework.api.schemas.response

interface Response<T> {

    fun toEntity(): T

}