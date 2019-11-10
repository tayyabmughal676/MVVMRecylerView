package com.gaalbaat.mvvmrecylerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {

    // changable
    private val _movies = MutableLiveData<List<Movies>>()
// No changable
    val movies : LiveData<List<Movies>>
        get() = _movies

    suspend fun getMovies(){
        val movies = repository.getMovies()

        _movies.value = movies
    }
}
