package com.sro.pokedexjetpackcompose.util

sealed class Resource<T>(private val data: T? = null, private val message: String? = null) {

    data class Success<T>(val data: T) : Resource<T>(data)
    data class Error<T>(val message: String, val data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()

}