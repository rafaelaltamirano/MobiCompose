package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "tv_show")
data class TvShow(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null ,
    val poster: String?,
    val name: String,
    val rating: Float,
)

//@Entity(tableName = "tv_shows")
//data class TvShow(
//    @PrimaryKey(autoGenerate = true)
//    var pk: Long = 0,
//    @SerializedName("id")
//    val tvShowId: Int,
//    @SerializedName("backdrop_path")
//    val poster: String,
//    @SerializedName("original_name")
//    val name: String,
//    @SerializedName("vote_average")
//    val rating: Float,
//): Serializable
