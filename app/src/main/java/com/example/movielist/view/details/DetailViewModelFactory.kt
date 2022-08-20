package com.example.movielist.view.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movielist.data.detail.DetailRemoteDataSource
import com.example.movielist.data.detail.DetailRepository

class DetailViewModelFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val remoteDataSource = DetailRemoteDataSource()
        val repository = DetailRepository(remoteDataSource)
        return DetailViewModel(repository) as T
    }
}