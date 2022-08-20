package com.example.movielist.view.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movielist.data.movies.MovieRemoteDataSource
import com.example.movielist.data.movies.MovieRepository

class MovieViewModelFactory: ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val remoteDataSource = MovieRemoteDataSource()
        val repository = MovieRepository(remoteDataSource)
        return MovieViewModel(repository) as T
    }
}