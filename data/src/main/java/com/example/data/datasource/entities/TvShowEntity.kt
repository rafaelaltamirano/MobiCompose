package com.example.data.datasource.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TvShowEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val poster: String,
    val name: String,
    val rating: Float, // vote overage /2
)
