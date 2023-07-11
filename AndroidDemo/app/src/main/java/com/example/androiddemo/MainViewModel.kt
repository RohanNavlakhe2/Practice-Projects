package com.example.androiddemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddemo.network.data.MovieList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: MainRepository
) : ViewModel() {

    private val movieFlow: StateFlow<NetworkResult<MovieList>> =
        MutableStateFlow(NetworkResult.None())
    val _movieFlow:StateFlow<NetworkResult<MovieList>> = movieFlow

    suspend fun getMovieList(searhQuery: String): Flow<NetworkResult<MovieList>> {
        return repository.getMovieList(searhQuery)
    }
}