package com.example.movielist.data.movies

import com.google.gson.annotations.SerializedName

class PopularMovie(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>
)