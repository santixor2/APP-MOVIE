package com.example.movielist.data.movies

import com.example.movielist.data.detail.MovieDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun getPopular(@Query("api_key") apiKey: String): Call<PopularMovie>

    @GET("movie/{movie_id}")
    fun getDetail(@Path("movie_id") movieId: Long,@Query("api_key") apiKey: String): Call<MovieDetail>
}