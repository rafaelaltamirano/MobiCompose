package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_show_keys")
data class TvShowKey(
    @PrimaryKey(autoGenerate = false)
    val id: Long? = null,
    val prevPage: Int?,
    val nextPage: Int?,
//    val lastUpdated: Long?,
)
