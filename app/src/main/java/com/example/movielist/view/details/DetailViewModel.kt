package com.example.movielist.view.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movielist.data.detail.DetailRepository
import com.example.movielist.data.detail.MovieDetail
import com.example.movielist.data.response.RepositoryError
import com.example.movielist.data.response.RepositoryResponse
import com.example.movielist.data.response.ResponseListener

class DetailViewModel(private val repository: DetailRepository): ViewModel() {
    val detail = MutableLiveData<MovieDetail?>()
    fun load(id: Long){
        repository.getDetail(object: ResponseListener<MovieDetail>{
            override fun onResponse(response: RepositoryResponse<MovieDetail>) {
                detail.value = response.data
            }

            override fun onError(repositoryError: RepositoryError) {
               // TODO("Not yet implemented")
            }

        }, movieId = id )


    }
}