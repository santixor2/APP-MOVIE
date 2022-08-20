package com.example.movielist.data.movies

import com.example.movielist.BuildConfig
import com.example.movielist.data.response.Source
import com.example.movielist.data.response.RepositoryError
import com.example.movielist.data.response.RepositoryResponse
import com.example.movielist.data.response.ResponseListener
import com.example.movielist.data.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRemoteDataSource {
    fun getPopularMovie(listener: ResponseListener<PopularMovie>){
        val service = RetrofitService.instance
            .create(MovieService::class.java)
            .getPopular(BuildConfig.API_KEY)

        service.enqueue(object : Callback<PopularMovie> {
            override fun onResponse(call: Call<PopularMovie>, response: Response<PopularMovie>){
                val popularMovie = response.body()

                if (response.isSuccessful && popularMovie != null) {
                    listener.onResponse(
                        RepositoryResponse(
                            data = popularMovie,
                            source = Source.REMOTE
                        )
                    )
                } else{
                    listener.onError(
                        RepositoryError(
                        message = "Error",
                        code = response.code(),
                        source = Source.REMOTE)
                    )
                }

            }

            override fun onFailure(call: Call<PopularMovie>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }
        })

    }
}