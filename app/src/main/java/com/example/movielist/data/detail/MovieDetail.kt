package com.example.movielist.data.detail

import com.google.gson.annotations.SerializedName

class MovieDetail(
    @SerializedName("id")
    val id:  Int,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("original_title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: String,
    @SerializedName("original_language")
    val language: String,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("release_data")
    val releaseData: String
)

