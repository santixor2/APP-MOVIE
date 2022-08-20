package com.example.movielist.data.response

interface ResponseListener<T> {
    fun onResponse(response: RepositoryResponse<T>)

    fun onError(repositoryError: RepositoryError)
}