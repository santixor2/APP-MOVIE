package com.example.movielist.view.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielist.data.movies.Movie
import com.example.movielist.data.movies.MovieRepository
import com.example.movielist.data.movies.PopularMovie
import com.example.movielist.data.response.RepositoryError
import com.example.movielist.data.response.RepositoryResponse
import com.example.movielist.data.response.ResponseListener

class MovieViewModel(private val repository: MovieRepository): ViewModel() {

        val movies = MutableLiveData<List<Movie>>(listOf())

        fun load (){
            repository.getPopularMovie(object : ResponseListener<PopularMovie>{
                override fun onResponse(response: RepositoryResponse<PopularMovie>) {
                    movies.value = response.data.movies
                }

                override fun onError(repositoryError: RepositoryError) {

                }

            })
        }
}