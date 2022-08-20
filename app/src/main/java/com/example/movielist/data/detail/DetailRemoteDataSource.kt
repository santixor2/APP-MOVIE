package com.example.movielist.data.detail

import com.example.movielist.BuildConfig
import com.example.movielist.data.RetrofitService
import com.example.movielist.data.movies.MovieService
import com.example.movielist.data.response.RepositoryError
import com.example.movielist.data.response.RepositoryResponse
import com.example.movielist.data.response.ResponseListener
import com.example.movielist.data.response.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRemoteDataSource{
    fun getDetail(listener: ResponseListener<MovieDetail>, movieId: Long){
        val service = RetrofitService.instance
            .create(MovieService::class.java)
            .getDetail(movieId,BuildConfig.API_KEY)


        service.enqueue(object : Callback<MovieDetail> {
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>){
                val movieDetail = response.body()

                if(response.isSuccessful && movieDetail != null){
                    listener.onResponse(RepositoryResponse(data = movieDetail, source = Source.REMOTE))
                }else{
                    listener.onError(RepositoryError(message = "error", code = response.code(), Source.REMOTE))
                }

            }

            override fun onFailure(call: Call<MovieDetail>, t: Throwable){
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