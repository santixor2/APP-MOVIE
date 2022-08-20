package com.example.movielist.data.movies

import com.google.gson.annotations.SerializedName

class Movie(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("poster_path")
    val posterPath: String

)
