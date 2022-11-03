package com.example.data.dto

interface Response<T> {

    fun toEntity(): T

}