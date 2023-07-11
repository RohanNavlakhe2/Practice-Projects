package com.example.androiddemo

import com.example.androiddemo.network.NetworkInterface
import com.example.androiddemo.network.data.MovieList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class MainRepository(val api:NetworkInterface) {

    fun getMovieList(searchQuery:String) = flow {

         emit(NetworkResult.Loading())

         withContext(Dispatchers.IO){
             val movieList = api.getMovieList(searchQuery)
             emit(NetworkResult.Success(movieList))
         }

    }
}