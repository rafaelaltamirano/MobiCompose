package com.example.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TvShowList(
    @SerializedName("page")
    val page: Int = 1,
    @SerializedName("results")
    val tvShows: List<TvShow>,
) : Serializable