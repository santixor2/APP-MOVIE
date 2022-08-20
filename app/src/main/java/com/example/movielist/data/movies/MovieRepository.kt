package com.example.movielist.data.movies

import com.example.movielist.data.response.ResponseListener

class MovieRepository(private val remoteDataSource: MovieRemoteDataSource){
    fun getPopularMovie(listener: ResponseListener<PopularMovie>){
        this.remoteDataSource.getPopularMovie(listener)
    }
}