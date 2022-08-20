package com.example.movielist.data.detail

import com.example.movielist.data.response.ResponseListener

class DetailRepository(val remoteDataSource: DetailRemoteDataSource){
    fun getDetail(listener: ResponseListener<MovieDetail>, movieId:Long){
        this.remoteDataSource.getDetail(listener, movieId = movieId)
    }
}