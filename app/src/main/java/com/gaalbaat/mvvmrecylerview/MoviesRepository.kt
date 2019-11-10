package com.gaalbaat.mvvmrecylerview

class MoviesRepository (
    private val api : MoviesApi
) : SafeApiRequest() {

    // suspend fun getMovies fun call apiRequest from SafeApiRequest
    suspend fun getMovies() = apiRequest { api.getMovies() }
}