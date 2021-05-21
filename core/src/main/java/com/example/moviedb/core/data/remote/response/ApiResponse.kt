package com.example.moviedb.core.data.remote.response

sealed class ApiResponse<out R>(statusResponse: StatusResponse) {
    data class Success<out T>(val data: T) : ApiResponse<T>(StatusResponse.SUCCESS)
    data class Error(val errorMessage: String) : ApiResponse<Nothing>(StatusResponse.ERROR)
    object Empty : ApiResponse<Nothing>(StatusResponse.EMPTY)
}